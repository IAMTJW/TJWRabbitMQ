package com.tianjunwei.learn.exchange.direct;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	 private static final String EXCHANGE_NAME = "direct_logs";

	    public static void main(String[] argv)
	                  throws java.io.IOException, TimeoutException {

	        ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("localhost");
	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();

	        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

	        String severity = "info";
	        String message = "hello exchange direct";

	        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
	        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

	        channel.close();
	        connection.close();
	    }
}
