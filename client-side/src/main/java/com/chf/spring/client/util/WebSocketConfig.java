package com.chf.spring.client.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpointConfig.Configurator;
import javax.websocket.HandshakeResponse;

public class WebSocketConfig extends Configurator {

	public void beforeRequest(Map<String, List<String>> headers) {
		String token = "Bearer " + Oauth2Client.getAcceeToken().toString();
		headers.put("Authorization", Arrays.asList(token));
	}

	public void afterResponse(HandshakeResponse handshakeResponse) {
		// NO-OP
	}
}
