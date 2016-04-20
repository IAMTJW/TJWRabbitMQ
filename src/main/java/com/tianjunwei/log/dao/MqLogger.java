/** 
 * @ProjectName: TTRabbitMQ 
 * @FileName: MqLogger.java 
 * @Date: 2016年4月17日 
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */  
package com.tianjunwei.log.dao;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianjunwei.log.dao.entity.LogInfo;
import com.tianjunwei.mq.MyRabbitTemplate;

/**
 * 模仿ch.qos.logback.classic.Logger这个类
 * @author tianjunwei
 * @date 2016年4月17日下午4:21:47
 * @modify by user: tianjunwei
 * @modify by reason:
 * @version V1.0
 */
public class MqLogger {

	private static final String exchange = "log_exchange";
	private static final String rout_info = "rout_info";
	private static final String rout_debug = "rout_debug";
	private static final String rout_warn = "rout_warn";
	private static final String rout_error = "rout_error";
	
	private LogInfo logInfo = new LogInfo();
	
	@Autowired
	private MyRabbitTemplate amqpTemplate;
	
	/*public MqLogger(Class<?> clazz) {
		logInfo = new LogInfo();
		logInfo.setClassName(clazz.getName());
	}*/


	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	public void debug(String msg, Throwable t) {
		logInfo.setLogInfo(msg);
		logInfo.setException(t.getMessage());
		amqpTemplate.convertAndSend(exchange, rout_debug,logInfo);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	public void info(String msg, Throwable t) {
		logInfo.setLogInfo(msg);
		logInfo.setException(t.getMessage());
		amqpTemplate.convertAndSend(exchange,rout_info, logInfo);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	public void warn(String msg, Throwable t) {
		logInfo.setLogInfo(msg);
		logInfo.setException(t.getMessage());
		amqpTemplate.convertAndSend(exchange,rout_warn, logInfo);
	}

	/**
	 *
	 * @param msg
	 * @param t 
	 * 2016年4月17日
	 */ 
	public void error(String msg, Throwable t) {
		logInfo.setLogInfo(msg);
		logInfo.setException(t.getMessage());
		amqpTemplate.convertAndSend(exchange,rout_error, logInfo);
	}
	/**
	 * @return the amqpTemplate
	 */
	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	/**
	 * @param amqpTemplate the amqpTemplate to set
	 */
	public void setAmqpTemplate(MyRabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

}
