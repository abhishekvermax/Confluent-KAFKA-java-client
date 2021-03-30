package com.example.kafka.component;

import com.example.kafka.utils.ConfigReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Consumer extends ConfigReader {

    private final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    private final String SSL_CONFIG_FILE = "sslConfigFile";
    private final String SCHEMA_REGISTRY_URL = "schema.registry.url";

    public KafkaConsumer<String, GenericRecord> consume(String clusterConfig, String topicName) throws IOException {

        Properties adminProps = new Properties();
        adminProps.load(new FileInputStream(ConfigReader.getValue(clusterConfig, SSL_CONFIG_FILE)));;
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigReader.getValue(clusterConfig, BOOTSTRAP_SERVERS));

        adminProps.put(ConsumerConfig.GROUP_ID_CONFIG, "connect-saphana-kafka-connect-source-claim_suffix-v2");
        //adminProps.put("session.timeout.ms", "6000"); // default value of group.min.session.timeout.ms.
        adminProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        adminProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
        adminProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
        adminProps.put(SCHEMA_REGISTRY_URL, ConfigReader.getValue(clusterConfig, SCHEMA_REGISTRY_URL));
        KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(adminProps);

        //TopicPartition topicPartition = new TopicPartition(topicName, 0);
        //List<TopicPartition> partitions = Arrays.asList(topicPartition);
        //CONSUMER.consume("",topicName).assign(partitions);
        //CONSUMER.consume("",topicName).seekToBeginning(partitions);

        consumer.subscribe(Arrays.asList(topicName));
        return consumer;
    }
}
