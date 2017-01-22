package com.chf.spring.server.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootResource {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/swagger-ui.html";
	}

}