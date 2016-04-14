/** 
*@ProjectName: TTRabbitMQ 
*@FileName: ReceiveLogsToConsole.java 
*@Date: 2016年4月12日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/  
package com.tianjunwei.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**    
* @Title: ReceiveLogsToConsole.java  
* @Package com.tianjunwei.fanout  
* @Description: 收集日志打印到控制台 
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月12日 下午11:34:28  
* @version V1.0    
*/
public class ReceiveLogsToConsole {
	private final static String EXCHANGE_NAME = "ex_log";
	public static void main(String [] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		 channel.exchangeDeclare(EXCHANGE_NAME, "fanout");  
	        // 创建一个非持久的、唯一的且自动删除的队列  
	        String queueName = channel.queueDeclare().getQueue();  
	        // 为转发器指定队列，设置binding  
	        channel.queueBind(queueName, EXCHANGE_NAME, "");  
	  
	        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");  
	  
	        QueueingConsumer consumer = new QueueingConsumer(channel);  
	        // 指定接收者，第二个参数为自动应答，无需手动应答  
	        channel.basicConsume(queueName, true, consumer);  
	  
	        while (true)  
	        {  
	            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
	            String message = new String(delivery.getBody());  
	            System.out.println(" [x] Received '" + message + "'");  
	  
	        }  
	}
}
