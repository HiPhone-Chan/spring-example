package com.chf.spring.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.chf.spring.common.utils.SpringUtil;
import com.chf.spring.server.config.ConfigProperties;

@ComponentScan({ "com.chf.spring" })
@EnableAutoConfiguration
@EnableConfigurationProperties({ ConfigProperties.class })
public class Application {

	public static void main(String[] args) {
		SpringUtil.springbootRun(Application.class, args);
	}

}
