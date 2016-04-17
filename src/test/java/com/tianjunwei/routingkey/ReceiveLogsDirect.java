/** 
*@ProjectName: TTRabbitMQ 
*@FileName: ReceiveLogsDirect.java 
*@Date: 2016年4月12日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/
package com.tianjunwei.routingkey;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @Title: ReceiveLogsDirect.java
 * @Package com.tianjunwei.routingkey
 * @Description: 接收端
 * @author tianjunwei tiantianjunwei@126.com
 * @date 2016年4月12日 下午11:55:11
 * @version V1.0
 */
public class ReceiveLogsDirect {
	private static final String EXCHANGE_NAME = "log_exchange";
	private static final String[] SEVERITIES = { "info","warning", "error" };

	public static void main(String[] argv) throws java.io.IOException, java.lang.InterruptedException, TimeoutException {
		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明direct类型转发器
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");

		//String queueName = channel.queueDeclare().getQueue();
		String severity = getSeverity();
		// 指定binding_key
		channel.queueBind("queue_trace", EXCHANGE_NAME, "rout_trace");
		System.out.println(" [*] Waiting for " + severity + " logs. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("queue_trace", true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());

			System.out.println(" [x] Received '" + message + "'");
		}
	}

	/**
	 * 随机产生一种日志类型
	 * 
	 * @return
	 */
	private static String getSeverity() {
		Random random = new Random();
		int ranVal = random.nextInt(3);
		return SEVERITIES[ranVal];
	}
}
