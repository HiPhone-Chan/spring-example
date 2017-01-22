package com.chf.spring.server.service.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.chf.spring.server.domain.Task;

@Service
public class TaskProcessor implements ItemProcessor<Task, Task> {

	@Override
	public Task process(Task item) throws Exception {
		item.setUpdateTime(new Date());
		return item;
	}

}
