/** 
*@ProjectName:TTRabbitMQ 
*@FileName: MQProducer.java
*@Date: 2016年4月16日下午4:48:51
*@Copyright: 2016 tianjunwei All rights reserved. 
*/ 
package com.tianjunwei.mq.server;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author tianjunwei
 * @date 2016年4月16日下午5:27:36
 * @modify by user: tianjunwei
 * @modify by reason: 
 * @version V1.0
 */
public class MQProducer {
	
	@Autowired
    private AmqpTemplate amqpTemplate;
     
    public void sendDataToCrQueue(Object obj) {
        amqpTemplate.convertAndSend("queue_one_key", obj);
    }   
}
