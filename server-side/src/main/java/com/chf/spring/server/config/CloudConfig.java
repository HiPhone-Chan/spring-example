package com.chf.spring.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.chf.spring.common.constants.MyProfiles;

@Configuration
@Profile(MyProfiles.CLOUD)
//@EnableTransactionManagement
//@EnableTask
public class CloudConfig {

//	@Bean
//	public TaskBatchExecutionListenerBeanPostProcessor batchTaskExecutionListenerBeanPostProcessor() {
//		TaskBatchExecutionListenerBeanPostProcessor postProcessor = new TaskBatchExecutionListenerBeanPostProcessor();
//		postProcessor.setJobNames(Arrays.asList(new String[] { "job1" }));
//
//		return postProcessor;
//	}
}
