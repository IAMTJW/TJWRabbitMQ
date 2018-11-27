package com.tianjunwei.general;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

/**
 * @author tianjunwei
 * 2018/10/21 16:21
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("localhost:9876");
        //producer.setInstanceName("rmq-instance");
        producer.start();
        try {
            for (int i = 0; i < 3; i++) {
                Message msg = new Message("TopicA-test",// topic
                        "TagA",// tag
                        (new Date() + "Hello RocketMQ ,QuickStart 11" + i)
                                .getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 0;
        while (true) {

            try {
                Message msg = new Message("TopicA-test",// topic
                        "TagA",// tag
                        (new Date() + "Hello RocketMQ ,QuickStart 11"+i)
                                .getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);

                Thread.sleep(4000);
                i++;

            } catch (Exception e) {

            }

        }
        // producer.shutdown();
    }

}
