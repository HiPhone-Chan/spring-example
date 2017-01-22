package com.chf.spring.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.chf.spring.common.constants.MyProfiles;
import com.chf.spring.common.domain.Message;

@Service
@Profile(MyProfiles.JMS)
public class JmsService {

	private final Logger log = LoggerFactory.getLogger(JmsService.class);

	@JmsListener(destination = "message", containerFactory = "myFactory")
	public void receiveMessage(Message msg) {
		log.info("Client received < {} > ", msg);
	}

}
