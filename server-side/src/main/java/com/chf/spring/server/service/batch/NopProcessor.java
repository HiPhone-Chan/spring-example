package com.chf.spring.server.service.batch;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class NopProcessor implements ItemProcessor<Object, Void> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Void process(Object item) throws Exception {
		log.info("NopProcessor {}", new Date());
		return null;
	}

}
