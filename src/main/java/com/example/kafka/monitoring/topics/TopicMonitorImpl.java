package com.example.kafka.monitoring.topics;

import com.example.kafka.component.Admin;
import com.example.kafka.component.Consumer;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.TopicPartition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class TopicMonitorImpl implements TopicMonitor {

    private static final Admin ADMIN = new Admin();

    @Override
    public Set<String> list(String clusterConfig) throws IOException, ExecutionException, InterruptedException {


        ListTopicsResult ltr = ADMIN.client(clusterConfig).listTopics();
        KafkaFuture<Set<String>> names = ltr.names();

        return names.get();
    }


    @Override
    public ArrayList<String> read(String clusterConfig, String topicName) throws IOException {
        Consumer CONSUMER = new Consumer();
        ArrayList<String> recordList = new ArrayList<String>();

        try {

            System.out.println("Subscribed to topic " + topicName);

            int i = 0;
            while (i<1){
                ConsumerRecords<String, GenericRecord> records = CONSUMER.consume(clusterConfig,topicName).poll(1000);
                if(records.isEmpty()){
                    System.out.println("empty records");
                }
                else{
                    for (ConsumerRecord<String, GenericRecord> record : records) {
                        recordList.add(
                        record.value().toString()
                        );
                        i++;
                    }
                    CONSUMER.consume(clusterConfig,topicName).commitSync();
                }

            }
            return recordList;
        } catch (Exception e) {
            e.printStackTrace();
            return recordList;
        } finally {
            CONSUMER.consume(clusterConfig,topicName).commitSync();
            CONSUMER.consume(clusterConfig,topicName).close();

        }


    }
}
