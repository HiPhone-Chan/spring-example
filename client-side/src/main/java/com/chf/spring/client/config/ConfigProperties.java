package com.chf.spring.client.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@ConfigurationProperties(prefix = "chf")
public class ConfigProperties {

	private final GithubResource github = new GithubResource();

	public GithubResource getGithub() {
		return github;
	}

	public static class GithubResource {

		private OAuth2ProtectedResourceDetails client = new AuthorizationCodeResourceDetails();

		private ResourceServerProperties resource = new ResourceServerProperties();

		public OAuth2ProtectedResourceDetails getClient() {
			return client;
		}

		public void setClient(OAuth2ProtectedResourceDetails client) {
			this.client = client;
		}

		public ResourceServerProperties getResource() {
			return resource;
		}

		public void setResource(ResourceServerProperties resource) {
			this.resource = resource;
		}
	}
}
