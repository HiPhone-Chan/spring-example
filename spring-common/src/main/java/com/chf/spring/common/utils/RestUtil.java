package com.chf.spring.common.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestUtil {

	private static RestTemplate template = new RestTemplate();

	public static <T> T get(String url, Class<T> responseType) {
		return template.getForObject(url, responseType);
	}

	public static <T> T post(String url, Object request, Class<T> responseType) {
		ResponseEntity<T> entity = template.postForEntity(url, request, responseType);
		return entity.getBody();
	}

	public static void put(String url, Object request) {
		template.put(url, request);
	}
}
