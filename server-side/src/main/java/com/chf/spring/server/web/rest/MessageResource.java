package com.chf.spring.server.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chf.spring.common.domain.Message;

@RestController
@RequestMapping("/api/message")
public class MessageResource extends ApiResource {

	@RequestMapping(method = RequestMethod.GET)
	public Message getMessages() {
		Message message = new Message();
		message.setContent("hi");
		return message;
	}
}
