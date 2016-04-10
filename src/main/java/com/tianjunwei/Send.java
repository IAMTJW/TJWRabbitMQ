/** 
*@ProjectName: TTRabbitMQ 
*@FileName: Send.java 
*@Date: 2016年4月10日 
*@Copyright: 2016 tianjunwei All rights reserved. 
*/  
package com.tianjunwei;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  

/**    
* @Title: Send.java  
* @Package com.tianjunwei  
* @Description: 发送数据 
* @author tianjunwei  tiantianjunwei@126.com   
* @date 2016年4月10日 下午10:16:17  
* @version V1.0    
*/
public class Send {
	//队列名称  
    private final static String QUEUE_NAME = "hello";  
  
    public static void main(String[] argv) throws java.io.IOException, TimeoutException  
    {  
        /** 
         * 创建连接连接到MabbitMQ 
         */  
        ConnectionFactory factory = new ConnectionFactory();  
        //设置MabbitMQ所在主机ip或者主机名  
        factory.setHost("localhost");  
        //创建一个连接  
        Connection connection = factory.newConnection();  
        //创建一个频道  
        Channel channel = connection.createChannel();  
        //指定一个队列  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
        //发送的消息  
        String message = "hello world! tian";  
        //往队列中发出一条消息  
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());  
        System.out.println(" [x] Sent '" + message + "'");  
        //关闭频道和连接  
        channel.close();  
        connection.close();  
     }  
}
