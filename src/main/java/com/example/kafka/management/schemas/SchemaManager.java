package com.example.kafka.management.schemas;

import com.example.kafka.management.manager;

import java.io.IOException;

public interface SchemaManager extends manager {
    default void delete(){}
    default void update(){}
}
