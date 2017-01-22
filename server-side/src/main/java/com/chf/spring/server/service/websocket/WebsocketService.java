package com.chf.spring.server.service.websocket;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
public class WebsocketService implements ApplicationListener<WebSocketEvent> {

	private final Logger log = LoggerFactory.getLogger(WebsocketService.class);

	private Map<String, WebSocketSession> sessionMap;

	public WebsocketService() {
		sessionMap = new ConcurrentHashMap<>();
	}

	@Override
	public void onApplicationEvent(WebSocketEvent event) {
		WebSocketSession webSocketSession = event.getSession();
		Principal principal = webSocketSession.getPrincipal();
		String currentLogin = (principal == null) ? null : principal.getName();
		try {
			switch (event.getType()) {
			case WebSocketEvent.CONNECTION_ESTABLISHED:
				log.info("Connection established : {} - {}", webSocketSession.getId(), currentLogin);
				if (StringUtils.isNotEmpty(currentLogin)) {
					WebSocketSession lastSession = sessionMap.get(currentLogin);
					if (lastSession != null && !lastSession.getId().equals(webSocketSession.getId())) {
						lastSession.close();
					}
					sessionMap.put(currentLogin, webSocketSession);
				}
				break;
			case WebSocketEvent.ON_MESSAGE:
				// act as echo
				webSocketSession.sendMessage((WebSocketMessage<?>) event.getValue());
				if (StringUtils.isNotEmpty(currentLogin)) {
					sessionMap.put(currentLogin, webSocketSession);
				}
				break;
			case WebSocketEvent.CONNECTION_CLOSED:
				String closedLogin = null;
				CloseStatus status = (CloseStatus) event.getValue();
				log.info("Connection closed : {} - {}", webSocketSession.getId(), status.getReason());
				for (String login : sessionMap.keySet()) {
					WebSocketSession session = sessionMap.get(login);
					if (webSocketSession.getId().equals(session.getId())) {
						closedLogin = login;
						break;
					}
				}
				if (closedLogin != null) {
					sessionMap.remove(closedLogin);
				}
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
