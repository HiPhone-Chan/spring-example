package com.chf.spring.server.service.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.chf.spring.common.utils.SpringUtil;

public class MyWebSocketHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		SpringUtil.publishEvent(new WebSocketEvent(session, WebSocketEvent.CONNECTION_ESTABLISHED));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		SpringUtil.publishEvent(new WebSocketEvent(session, WebSocketEvent.ON_MESSAGE, message));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		SpringUtil.publishEvent(new WebSocketEvent(session, WebSocketEvent.CONNECTION_CLOSED, status));
	}

}
