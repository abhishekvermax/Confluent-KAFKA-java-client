package com.example.kafka.monitoring.jobs;

import com.example.kafka.monitoring.schemas.SchemaMonitorImpl;
import com.example.kafka.monitoring.topics.TopicMonitorImpl;


public class Monitor extends SchemaMonitorImpl {

    private static final SchemaMonitorImpl schemaMonitor = new SchemaMonitorImpl();
    private static final TopicMonitorImpl topicMonitor = new TopicMonitorImpl();


    public static void main(String[] args) throws Exception {
        System.out.println("This is from Monitoring main class");

        if (args[1].equals("schemas")) {
            System.out.println(schemaMonitor.read(args[0]));
        } else if (args[1].equals("topics")) {
            System.out.println(topicMonitor.list(args[0]));
        } else if (args[1].equals("read-topic")) {
                for (String x:topicMonitor.read(args[0], args[2])){
                    System.out.println(x);
                }


        }
    }

}




