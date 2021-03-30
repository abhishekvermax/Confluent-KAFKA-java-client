package com.example.kafka.management.connectors;

import com.example.kafka.management.manager;

public interface ConnectorManager extends manager {

    public default void status(){}
    public default void delete(){}
    public default void config(){}
    public default void update(){}
    public default void create(){}
}
