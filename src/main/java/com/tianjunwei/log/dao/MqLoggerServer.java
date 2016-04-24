/** 
 * @ProjectName: TTRabbitMQ 
 * @FileName: MqLoggerServer.java 
 * @Date: 2016年4月24日 
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */  
package com.tianjunwei.log.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.tianjunwei.log.dao.entity.LogInfo;
import com.tianjunwei.mq.MyRabbitTemplate;
import com.alibaba.fastjson.JSON;

/**    
 * 消息处理类 
 * @Title: MqLoggerServer.java  
 * @Package com.tianjunwei.log.dao  
 * @author tianjunwei  tiantianjunwei@126.com   
 * @date 2016年4月24日 下午10:34:50  
 * @version V1.0    
 */
public class MqLoggerServer {

	@Autowired
	private MyRabbitTemplate amqpTemplate;
	
	public void debug(){
		LogInfo debug = JSON.parseObject(amqpTemplate.receiveAndConvert("queue_debug").toString(), LogInfo.class) ;
	}
	
	public void info(){
		LogInfo debug = JSON.parseObject(amqpTemplate.receiveAndConvert("queue_info").toString(), LogInfo.class) ;
	}
	
	public void warn(){
		LogInfo debug = JSON.parseObject(amqpTemplate.receiveAndConvert("queue_warn").toString(), LogInfo.class) ;			
	}
	public void error(){
		LogInfo debug = JSON.parseObject(amqpTemplate.receiveAndConvert("queue_error").toString(), LogInfo.class) ;
	}
}
