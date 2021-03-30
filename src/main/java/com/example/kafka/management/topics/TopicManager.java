package com.example.kafka.management.topics;

import com.example.kafka.management.manager;

import java.io.IOException;

public interface TopicManager extends manager {

    default Boolean delete(String clusterConfig,String topicName) {
        return false;
    }
    default Boolean create(String clusterConfig,String topicName,int numPartitions,short replicationFactor){
        return false;
    }



}
