package com.tianjunwei;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

/**
 * @author tianjunwei
 * 2018/10/21 17:44
 */
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Arrays;
import java.util.Properties;

public class MyConsumer extends Thread {
    private String topic;
    KafkaConsumer<String, String> consumer;

    public MyConsumer() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("group.id","test");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList("kafka_api"));
    }

    @Override
    public void run() {
        while (true){
            ConsumerRecords<String,String> records = consumer.poll(100);
            for (ConsumerRecord<String,String> recode: records) {
                System.out.println("recodeOffset = " + recode.offset() + "recodeValue = " + recode.value());
            }
        }
    }
    public static void main(String[] args){
        new MyConsumer().start();
    }
}

