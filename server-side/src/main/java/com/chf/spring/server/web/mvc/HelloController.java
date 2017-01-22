package com.chf.spring.server.web.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private final Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello(SitePreference sitePreference) {
		log.info("Get {}", sitePreference.name());
		return "hello";
	}
}
