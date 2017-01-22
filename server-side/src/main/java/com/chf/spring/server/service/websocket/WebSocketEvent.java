package com.chf.spring.server.service.websocket;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketEvent extends ApplicationEvent {

	private static final long serialVersionUID = 6105423066720657150L;

	public static final String CONNECTION_ESTABLISHED = "established";

	public static final String ON_MESSAGE = "message";

	public static final String CONNECTION_CLOSED = "closed";

	private WebSocketSession session;

	private String type;

	private Object value;

	public WebSocketEvent(WebSocketSession session, String type) {
		this(session, type, null);
	}

	public WebSocketEvent(WebSocketSession session, String type, Object value) {
		super(session);
		this.session = session;
		this.type = type;
		this.value = value;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public String getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}
}
