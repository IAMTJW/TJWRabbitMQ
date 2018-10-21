package com.tianjunwei.learn.exchange.header;

import java.io.IOException;
import java.util.Hashtable;  
import java.util.Map;  
  
import org.springframework.amqp.core.ExchangeTypes;  
  
import com.rabbitmq.client.AMQP;  
import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer;  
  
public class Receiver {  
	
    private final static String EXCHANGE_NAME = "header-exchange";  
    private final static String QUEUE_NAME = "header-queue";  
      
    public static void main(String[] args) throws Exception {  
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("127.0.0.1");  
        // 指定用户 密码  
        //factory.setUsername("admin");  
        //factory.setPassword("admin");  
        // 指定端口  
        factory.setPort(AMQP.PROTOCOL.PORT);  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
          
        //声明转发器和类型headers  
        channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.HEADERS,false,true,null);  
        channel.queueDeclare(QUEUE_NAME,false, false, true,null);  
          
        Map<String, Object> headers = new Hashtable<String, Object>();  
        headers.put("x-match", "any");//all any  
        headers.put("aaa", "01234");  
        headers.put("bbb", "56789");  
        // 为转发器指定队列，设置binding 绑定header键值对  
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME,"", headers); 
        
        System.out.println(queueName+" [*] Waiting for messages. To exit press CTRL+C");
        
        Consumer consumer = new DefaultConsumer(channel) {
  	      @Override
  	      public void handleDelivery(String consumerTag, Envelope envelope,
  	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
  	        String message = new String(body, "UTF-8");
  	        System.out.println(" [x] Received '" + message + "'");
  	      }
  	    };
  	    channel.basicConsume(queueName, true, consumer);
    }  
}  