package com.tianjunwei.learn.exchange.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv)throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		String routingKey = "error.log";
		String message = "hello exchange topic";

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
		System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

		connection.close();
	}
}
