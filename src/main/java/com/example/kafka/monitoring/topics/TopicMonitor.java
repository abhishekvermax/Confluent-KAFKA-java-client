package com.example.kafka.monitoring.topics;

import com.example.kafka.monitoring.monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface TopicMonitor extends monitor {
    @Override
     default Set<String> list(String jsonPath) throws IOException, ExecutionException, InterruptedException {
         return Collections.emptySet();
     }

    @Override
    default String read(String topicName) {
        return "";
    }

    @Override
    default ArrayList<String> read(String jsonPath, String topicName) throws IOException {
        return new ArrayList<String>();
    }
}
