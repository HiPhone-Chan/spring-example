package com.chf.spring.common.domain;

import org.junit.Test;

import com.chf.spring.common.utils.JsonUtil;

public class MessageTest {

	@Test
	public void test() {
		Message msg = new Message("hi");
		String str = JsonUtil.formObject(msg);

		Message msg2 = JsonUtil.toObject(str, Message.class);
		System.out.println(msg2);
	}

}
