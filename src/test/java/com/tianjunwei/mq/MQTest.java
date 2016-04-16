
package com.tianjunwei.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianjunwei.mq.client.MQConsumer;
import com.tianjunwei.mq.server.MQProducer;

/**
 * 
 * @author tianjunwei
 * @date 2016年4月16日下午5:31:21
 * @modify by user: tianjunwei
 * @modify by reason:
 * @version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_test.xml")
public class MQTest {
	
	@Autowired
	MQProducer mqProducer;
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Test
	public void test(){
		mqProducer.sendDataToCrQueue("hello rabbitmq");
	}
	
}
