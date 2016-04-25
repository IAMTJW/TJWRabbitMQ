/** 
 * @ProjectName: TTRabbitMQ 
 * @FileName: MqLoggerServer.java 
 * @Date: 2016年4月24日 
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */
package com.tianjunwei.log.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianjunwei.log.dao.entity.LogInfo;
import com.tianjunwei.mq.MyRabbitTemplate;
import com.alibaba.fastjson.JSON;

/**
 * 消息处理类
 * 
 * @Title: MqLoggerServer.java
 * @Package com.tianjunwei.log.dao
 * @author tianjunwei tiantianjunwei@126.com
 * @date 2016年4月24日 下午10:34:50
 * @version V1.0
 */
public class MqLoggerServer implements MessageListener {

	@Autowired
	private MyRabbitTemplate amqpTemplate;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private static final String sqlPrfix = "com.tianjunwei.log.dao.entity.Login.";

	public void debug() {
		LogInfo debug = JSON.parseObject(
				amqpTemplate.receiveAndConvert("queue_debug").toString(),
				LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "debug", debug);
	}

	public void info(String data) {
		// = amqpTemplate.receiveAndConvert("queue_info").toString();
		LogInfo info = JSON.parseObject(data, LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "info", info);
	}

	public void warn() {
		LogInfo warn = JSON.parseObject(
				amqpTemplate.receiveAndConvert("queue_warn").toString(),
				LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "warn", warn);
	}

	public void error() {
		LogInfo error = JSON.parseObject(
				amqpTemplate.receiveAndConvert("queue_error").toString(),
				LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "error", error);
	}

	@Override
	public void onMessage(Message message) {

		System.out.println(message.getBody());
		byte[] data = message.getBody();
		LogInfo info = JSON.parseObject(data, LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "info", info);
	}
}
