package com.chf.spring.common.utils;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

public final class AmqpClient {

	final static String EXCHANGE_NAME = "exchange-chf";

	final static String ROUTING_KEY = "ROUTING_KEY";

	private static RabbitTemplate rabbitTemplate = rabbitTemplate();

	private AmqpClient() {
	}

	public static ConnectionFactory connectionFactory() {
		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses("localhost");
		return cf;
	}

	public static RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		RetryTemplate retryTemplate = new RetryTemplate();
		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(500);
		backOffPolicy.setMultiplier(10.0);
		backOffPolicy.setMaxInterval(10000);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		template.setRetryTemplate(retryTemplate);
		return template;
	}

	public static void sendMsg(String msg) {
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, msg);
	}

}
