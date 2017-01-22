package com.chf.spring.server.service.batch;

import org.springframework.batch.item.data.RepositoryItemWriter;

import com.chf.spring.server.domain.Task;

public class TaskWriter extends RepositoryItemWriter<Task> {

	public TaskWriter() {
		setMethodName("save");
	}
}
