package com.chf.spring.server.service.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.data.domain.Sort.Direction;

import com.chf.spring.server.domain.Task;

public class TaskReader extends RepositoryItemReader<Task> {

	public TaskReader() {
		Map<String, Direction> sorts = new HashMap<>();
		sorts.put("createTime", Direction.ASC);

		setSort(sorts);
		setMethodName("findAll");
	}
}
