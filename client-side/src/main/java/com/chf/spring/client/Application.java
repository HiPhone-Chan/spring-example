package com.chf.spring.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.chf.spring.client.config.ConfigProperties;
import com.chf.spring.common.utils.SpringUtil;

@SpringBootApplication
@EnableConfigurationProperties({ ConfigProperties.class })
public class Application {

	public static void main(String[] args) {
		SpringUtil.springbootRun(Application.class, args);
	}

}
