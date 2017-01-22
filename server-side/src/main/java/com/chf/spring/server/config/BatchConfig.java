package com.chf.spring.server.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.chf.spring.common.constants.MyProfiles;
import com.chf.spring.server.domain.Task;
import com.chf.spring.server.repository.TaskRepository;
import com.chf.spring.server.service.batch.EmptyObjectReader;
import com.chf.spring.server.service.batch.NopProcessor;
import com.chf.spring.server.service.batch.TaskProcessor;
import com.chf.spring.server.service.batch.TaskReader;
import com.chf.spring.server.service.batch.TaskWriter;

@Configuration
@EnableBatchProcessing
@Profile(MyProfiles.BATCH)
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private EmptyObjectReader emptyObjectReader;

	@Autowired
	private TaskProcessor taskProcessor;

	@Autowired
	private NopProcessor nopProcessor;

	@Bean
	public TaskReader taskReader() {
		TaskReader taskReader = new TaskReader();
		taskReader.setRepository(taskRepository);
		return taskReader;
	}

	@Bean
	public TaskWriter taskWriter() {
		TaskWriter taskWriter = new TaskWriter();
		taskWriter.setRepository(taskRepository);
		return taskWriter;
	}

	@Bean
	public Job taskJob() {
		JobBuilder jobBuilder = jobBuilderFactory.get("taskJob").incrementer(new RunIdIncrementer());
		return jobBuilder.start(step1()).next(step2()).build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Task, Task> chunk(10).reader(taskReader()).processor(taskProcessor)
				.writer(taskWriter()).build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2").<Object, Void> chunk(1).reader(emptyObjectReader).processor(nopProcessor)
				.build();
	}
}
