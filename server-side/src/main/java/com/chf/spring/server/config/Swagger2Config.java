package com.chf.spring.server.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import com.chf.spring.common.constants.MyProfiles;
import com.chf.spring.server.config.ConfigProperties.Swagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile(MyProfiles.SWAGGER)
public class Swagger2Config {

	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

	@Autowired
	private ConfigProperties properties;

	@Bean
	public Docket swaggerSpringfoxDocket() {
		StopWatch watch = new StopWatch();
		watch.start();
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class)
				.directModelSubstitute(java.time.LocalDate.class, String.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).select()
				.paths(regex(DEFAULT_INCLUDE_PATTERN)).build();
		watch.stop();
		return docket;
	}

	private ApiInfo apiInfo() {
		Swagger swagger = properties.getSwagger();
		return new ApiInfoBuilder().title(swagger.getTitle()).description(swagger.getDescription())
				.version(swagger.getVersion()).termsOfServiceUrl(swagger.getTermsOfServiceUrl())
				.license(swagger.getLicense()).licenseUrl(swagger.getLicenseUrl()).build();
	}

}
