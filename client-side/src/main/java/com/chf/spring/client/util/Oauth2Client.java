package com.chf.spring.client.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class Oauth2Client {

	private static final String TOKEN_URL = Constants.HOST + "/oauth/token";

	public static OAuth2ProtectedResourceDetails passwordResourceDetails() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		List<String> scopes = new ArrayList<>(2);
		scopes.add("write");
		scopes.add("read");
		resource.setAccessTokenUri(TOKEN_URL);
		resource.setClientId("homekitapp");
		resource.setClientSecret("mySecretOAuthSecret");
		resource.setScope(scopes);

		resource.setUsername(Constants.NAME);
		resource.setPassword(Constants.PWD);
		return resource;
	}

	public static OAuth2AccessToken getAcceeToken() {
		OAuth2RestTemplate template = new OAuth2RestTemplate(Oauth2Client.passwordResourceDetails());
		return template.getAccessToken();
	}

	public static void main(String[] args) {
		OAuth2RestTemplate template = new OAuth2RestTemplate(Oauth2Client.passwordResourceDetails());
		String result = template.getForObject(Constants.HOST + "/api/spaces", String.class);
		System.out.println(result);
	}

}
