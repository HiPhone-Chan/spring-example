package com.chf.spring.common.support;

import com.chf.spring.common.api.MyPlugin;

//@Component
public class DefaultPlugin implements MyPlugin {

	@Override
	public boolean supports(String delimiter) {
		return true;
	}

}
