package com.chf.spring.server.service.plugin;

import com.chf.spring.common.api.MyPlugin;

public class Plugin1 implements MyPlugin {

	@Override
	public boolean supports(String delimiter) {
		return false;
	}

}
