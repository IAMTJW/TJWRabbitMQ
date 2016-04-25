package com.tianjunwei.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianjunwei.log.dao.MqLoggerServer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_test.xml")
public class MqLoggerServerTest {
	
	@Autowired
	MqLoggerServer mqLoggerServer;
	
	@Test
	public void mqloggerserverTest(){
		mqLoggerServer.info("sjdj");
	}
}
