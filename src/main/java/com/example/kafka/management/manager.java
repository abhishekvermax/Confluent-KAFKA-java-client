package com.example.kafka.management;

public interface manager {
     default void delete(){}
     default void config(){}
     default void update(){}
     default void create(){}

}
