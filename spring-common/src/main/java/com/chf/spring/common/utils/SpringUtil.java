package com.chf.spring.common.utils;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.chf.spring.common.constants.MyProfiles;

@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		set(applicationContext);
	}

	public static Object getBean(String beanName) {
		return applicationContext == null ? null : applicationContext.getBean(beanName);
	}

	public static <T> T getBean(Class<T> beanClass) {
		return applicationContext == null ? null : applicationContext.getBean(beanClass);
	}

	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
		return applicationContext == null ? null : applicationContext.getBeansWithAnnotation(annotationType);
	}

	public static void publishEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);
	}

	public static ConfigurableApplicationContext springbootRun(Class<?> clz, String[] args) {
		SpringApplication app = new SpringApplication(clz);
		app.setBannerMode(Banner.Mode.OFF);
		app.setLogStartupInfo(false);
		addProfile(app);
		return app.run(args);
	}

	private static void set(ApplicationContext context) {
		applicationContext = context;
	}

	private static void addProfile(SpringApplication app) {
		// comment it to disable
		app.setAdditionalProfiles(MyProfiles.SWAGGER);
		// app.setAdditionalProfiles(MyProfiles.JMS);
		// app.setAdditionalProfiles(MyProfiles.BATCH);
		// app.setAdditionalProfiles(MyProfiles.CLOUD);
	}
}
