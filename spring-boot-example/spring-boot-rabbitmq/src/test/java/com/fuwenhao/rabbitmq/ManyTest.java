package com.fuwenhao.rabbitmq;

import com.fuwenhao.many.NeoSender;
import com.fuwenhao.many.NeoSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	@Autowired
	private NeoSender neoSender;

	@Autowired
	private NeoSender2 neoSender2;

	/**
	 * 一对多发送
	 * @throws Exception
	 */
	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			neoSender.send(i);
		}
	}

	/**
	 * 多对多发送
	 * @throws Exception
	 */
	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			neoSender.send(i);
			neoSender2.send(i);
		}
	}

}