package com.tianjunwei.learn.queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {

	
	private final static String QUEUE_NAME = "hello1";

	public static void main(String[] argv)
	      throws java.io.IOException,
	             java.lang.InterruptedException, TimeoutException {

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
		//指定要监听的队列名称
	    channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    //创建消费监听者
	    Consumer consumer = new DefaultConsumer(channel) {
	    	  @Override
	    	  public void handleDelivery(String consumerTag, Envelope envelope,
	    	                             AMQP.BasicProperties properties, byte[] body)
	    	      throws IOException {
	    		  try{
	    			  String message = new String(body, "UTF-8");
	    			  System.out.println(" [x] Received '" + message + "'");
	    		  }finally {
	    			  //收到消息确认
	    			  channel.basicAck(envelope.getDeliveryTag(), false);
				}
	    	   
	    	  }
	    	};
	    //关闭消息自动确认机制，改为主动确认
	    boolean autoAck = false;
	    //启动消费监听者
	    channel.basicConsume(QUEUE_NAME, autoAck, consumer);
	}
	
}
