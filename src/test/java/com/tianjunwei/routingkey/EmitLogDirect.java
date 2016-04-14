/** 
*@ProjectName: TTRabbitMQ 
*@FileName: EmitLogDirect.java 
*@Date: 2016年4月12日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/
package com.tianjunwei.routingkey;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Title: EmitLogDirect.java
 * @Package com.tianjunwei.routingkey
 * @Description: 配置routingkey
 * @author tianjunwei tiantianjunwei@126.com
 * @date 2016年4月12日 下午11:53:47
 * @version V1.0
 */
public class EmitLogDirect {
	private static final String EXCHANGE_NAME = "ex_logs_direct";
	private static final String[] SEVERITIES = { "info", "warning", "error" };

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {
		// 创建连接和频道
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明转发器的类型
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");

		// 发送6条消息
		for (int i = 0; i < 16; i++) {
			String severity = getSeverity();
			String message = severity + "_log :" + UUID.randomUUID().toString();
			// 发布消息至转发器，指定routingkey
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}

		channel.close();
		connection.close();
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
