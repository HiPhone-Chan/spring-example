package com.chf.spring.server.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.chf.spring.common.constants.MyProfiles;
import com.chf.spring.common.domain.Message;

@Service
@Profile(MyProfiles.JMS)
public class JmsService {

	private final Logger log = LoggerFactory.getLogger(JmsService.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "message", containerFactory = "myFactory")
	public void receiveMessage(Message msg) {
		log.info("Server received < {} > ", msg);
	}

	@Scheduled(fixedDelay = 600 * 1000)
	public void task() {
		jmsTemplate.convertAndSend("message", new Message("Hello."));

	}
}
