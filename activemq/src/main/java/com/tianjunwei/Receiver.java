package com.tianjunwei;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Receiver
{
    public void requestHandler(HashMap<Serializable,Serializable> requestParam) throws Exception
    {
        System.out.println("requestHandler....."+requestParam.toString());
        for(Map.Entry<Serializable, Serializable> entry : requestParam.entrySet())
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception
    {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("RequestQueue");
        //消息消费（接收）者
        MessageConsumer consumer = session.createConsumer(destination);

        Receiver processor = new Receiver();
        System.out.println("Receiver is waiting");
        while(true)
        {
            ObjectMessage message = (ObjectMessage) consumer.receive(1000);
            if(null != message)
            {
                System.out.println(message);
                HashMap<Serializable,Serializable> requestParam = (HashMap<Serializable,Serializable>) message.getObject();
                processor.requestHandler(requestParam);
            }
        }
    }
}
