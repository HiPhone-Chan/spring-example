package com.chf.spring.server.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmptyObjectReader implements ItemReader<Object> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public static final Object EMPTY_OBJECT = new Object();

	private Boolean has = Boolean.TRUE;

	@Override
	public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("read...");
		synchronized (has) {
			has = !has;
			if (!has) {
				return EMPTY_OBJECT;
			}
			return null;
		}
	}

}
