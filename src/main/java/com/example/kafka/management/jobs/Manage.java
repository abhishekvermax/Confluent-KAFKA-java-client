package com.example.kafka.management.jobs;

import com.example.kafka.management.topics.TopicManagerImpl;


public class Manage extends TopicManagerImpl {

    private static final TopicManagerImpl topicManager = new TopicManagerImpl();


    public static void main(String[] args) {
        System.out.println("This is from management main class");


        if (args[1].equals("create-topic")) {
            if (topicManager.create(args[0],
                    args[2], Integer.parseInt(args[3]), Short.parseShort(args[4])).equals(true)) {
                System.out.println("new topic has been created with name: " + args[2]);
            } else {
                System.out.println("Failure in topic creation: " + args[2]);
            }
        }

        else if(args[1].equals("delete-topic")){
            if (topicManager.delete(args[0],args[2]).equals(true)) {
                System.out.println("Topic has been deleted for provided name: " + args[2]);
            } else {
                System.out.println("Failure in topic deletion: " + args[2]);
            }
        }

    }
}
