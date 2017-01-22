package com.chf.spring.server.service.plugin;

import java.util.List;

import com.chf.spring.common.api.MyPlugin;

public class PluginHost {

	private List<MyPlugin> plugins;

	public PluginHost(List<MyPlugin> plugins) {
		this.plugins = plugins;
	}

}
