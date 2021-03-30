package com.example.kafka.management.topics;

import com.example.kafka.component.Admin;
import org.apache.kafka.clients.admin.CreateTopicsOptions;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class TopicManagerImpl extends Admin implements TopicManager{

    private static final Admin ADMIN = new Admin();

    @Override
    public Boolean delete(String clusterConfig,String topicName){
        try {
            KafkaFuture<Void> future = ADMIN.client(clusterConfig)
                    .deleteTopics(Collections
                    .singleton(topicName)).all();
            future.get();
            return true;
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean create(String clusterConfig,String topicName,int numPartitions,short replicationFactor) {
        try {
            KafkaFuture<Void> future = ADMIN.client(clusterConfig)
                    .createTopics(Collections.singleton(new NewTopic(topicName,
                                    numPartitions,
                                    replicationFactor)),
                            new CreateTopicsOptions().timeoutMs(10000))
                    .all();
            future.get();
            return true;
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
