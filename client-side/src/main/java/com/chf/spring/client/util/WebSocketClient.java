package com.chf.spring.client.util;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint(configurator = WebSocketConfig.class)
public class WebSocketClient {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Connected to endpoint: " + session.getBasicRemote());
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println(session.getId() + " get msg :" + message);
	}

	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	public static void main(String[] args) {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			String uri = "wss://" + Constants.DOMAIN + "/websocket/connect";
			Session session = container.connectToServer(WebSocketClient.class, new URI(uri));

			while (true) {
				session.getBasicRemote().sendText("asdasdasd");
				Thread.sleep(10000);
			}
			// session.close(); // 关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
