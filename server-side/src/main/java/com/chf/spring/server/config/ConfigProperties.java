package com.chf.spring.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

import io.swagger.models.Contact;

@ConfigurationProperties(prefix = "chf")
public class ConfigProperties {

	private final Swagger swagger = new Swagger();

	private final CorsConfiguration cors = new CorsConfiguration();

	public Swagger getSwagger() {
		return swagger;
	}

	public CorsConfiguration getCors() {
		return cors;
	}

	public static class Swagger {

		private String title;

		private String description;

		private String version;

		private String termsOfServiceUrl;

		private Contact contact;

		private String license;

		private String licenseUrl;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getTermsOfServiceUrl() {
			return termsOfServiceUrl;
		}

		public void setTermsOfServiceUrl(String termsOfServiceUrl) {
			this.termsOfServiceUrl = termsOfServiceUrl;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getLicenseUrl() {
			return licenseUrl;
		}

		public void setLicenseUrl(String licenseUrl) {
			this.licenseUrl = licenseUrl;
		}
	}
}
