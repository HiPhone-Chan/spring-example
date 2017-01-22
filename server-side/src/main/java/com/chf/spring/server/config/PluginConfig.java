package com.chf.spring.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

import com.chf.spring.common.api.MyPlugin;

@Configuration
@EnablePluginRegistries({ MyPlugin.class })
public class PluginConfig {

}
