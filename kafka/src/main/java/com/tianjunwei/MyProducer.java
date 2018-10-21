package com.tianjunwei;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianjunwei
 * 2018/10/21 17:42
 */
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class MyProducer extends Thread {
    private String topic;
    private KafkaProducer<String,String> producer;

    public MyProducer(String topic) {
        this.topic = topic;
        Properties properties = new Properties();
        properties.put("bootstrap.servers","127.0.0.1:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true){
            String message = "message" + messageNo;
            System.out.println("send = "+message);
            producer.send(new ProducerRecord<String, String>(topic,message));
            messageNo ++;

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new MyProducer("kafka_api").start();
    }
}
