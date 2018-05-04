package com.tianjunwei.learn.queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Send {
	
	private final static String QUEUE_NAME = "hello1";

	public static void main(String[] args) throws IOException, TimeoutException {
		//创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//IP地址
		factory.setHost("127.0.0.1");
		//端口
		factory.setPort(5672);
		//用户名
		//factory.setUsername("guest");
		//密码
		//factory.setPassword("geust");
		//创建连接
		Connection connection = factory.newConnection();
		//创建通道
		Channel channel = connection.createChannel();
		//设置持久化为true
		boolean durable = true;
		//设置queue名称
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		int i =0;
		String message = "Hello World!"+i;
		//向queue中发送数据
		channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		i++;
		channel.close();
		connection.close();
	}

}
