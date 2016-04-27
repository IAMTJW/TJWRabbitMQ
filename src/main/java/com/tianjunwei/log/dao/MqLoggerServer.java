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

	private MyRabbitTemplate amqpTemplate;

	SqlSessionTemplate sqlSessionTemplate;

	

	private static final String sqlPrfix = "com.tianjunwei.log.dao.entity.LogInfo.";

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
		
		String data = new String(message.getBody());
		System.out.println(data);
		LogInfo info = JSON.parseObject(data, LogInfo.class);
		sqlSessionTemplate.insert(sqlPrfix + "info", info);
	}
	
	public MyRabbitTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(MyRabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
