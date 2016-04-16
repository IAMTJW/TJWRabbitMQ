/** 
 * @ProjectName:TTRabbitMQ 
 * @FileName: MQConsumer.java
 * @Date: 2016年4月16日下午4:48:51
 * @Copyright: 2016 tianjunwei All rights reserved. 
 */ 
package com.tianjunwei.mq.client;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 
 * @author tianjunwei
 * @date 2016年4月16日下午5:29:04
 * @modify by user: tianjunwei
 * @modify by reason:
 * @version V1.0
 */
public class MQConsumer implements  MessageListener{
	
	@Override
    public void onMessage(Message message) {
        System.out.println(" data ----------------------------------------:" + message.getBody());
    }
}
