/** 
 * @ProjectName:TTRabbitMQ 
 * @FileName: MQProducer.java
 * @Date: 2016年4月16日下午4:48:51
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */ 
package com.tianjunwei.mq.server;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.tianjunwei.mq.MyRabbitTemplate;

/**
 * 
 * @author tianjunwei
 * @date 2016年4月16日下午5:27:36
 * @modify by user: tianjunwei
 * @modify by reason: 
 * @version V1.0
 */
public class MQProducer {
	
    private MyRabbitTemplate amqpTemplate;
     
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

	public void sendDataToCrQueue(Object obj) {
        amqpTemplate.convertAndSend("log-exchange","rout_trace", obj);
        amqpTemplate.convertAndSend("log-exchange","rout_trace", obj);
        
       //System.err.println(amqpTemplate.receiveAndConvert("queue_one_key"));
       
    }   
}
