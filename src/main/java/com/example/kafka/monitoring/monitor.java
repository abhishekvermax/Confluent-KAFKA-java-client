package com.example.kafka.monitoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface monitor {
    default String read(String topicName) throws IOException {
        return "";
    }

    default ArrayList<String> read(String jsonPath, String topicName) throws IOException {
        return new ArrayList<String>();
    }

    default Set<String> list(String jsonPath) throws IOException, ExecutionException, InterruptedException {
        return Collections.emptySet();
    }

}
