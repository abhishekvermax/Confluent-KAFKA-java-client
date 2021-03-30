package com.example.kafka.monitoring.schemas;

import com.example.kafka.monitoring.monitor;

import java.io.IOException;

public interface SchemaMonitor extends monitor {
    default String read(String jsonPath)  throws IOException {
        return "";
    }
}
