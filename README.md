# KAFKA-java-client
Java based management project to handle REST Api and KAFKA configs

Project Structure:

```
.
├── cluster_config.json
├── kafka-java-client.drawio
├── kafka-java-client.iml
├── kafka-java-client.jpg
├── manual_java_install.md
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── kafka
    │   │               ├── component
    │   │               │   ├── Admin.java
    │   │               │   ├── Consumer.java
    │   │               │   └── Producer.java
    │   │               ├── management
    │   │               │   ├── connectors
    │   │               │   │   ├── ConnectorManagerImpl.java
    │   │               │   │   └── ConnectorManager.java
    │   │               │   ├── jobs
    │   │               │   │   └── Manage.java
    │   │               │   ├── manager.java
    │   │               │   ├── schemas
    │   │               │   │   ├── SchemaManagerImpl.java
    │   │               │   │   └── SchemaManager.java
    │   │               │   └── topics
    │   │               │       ├── TopicManagerImpl.java
    │   │               │       └── TopicManager.java
    │   │               ├── monitoring
    │   │               │   ├── connectors
    │   │               │   │   └── ConnectorMonitor.java
    │   │               │   ├── jobs
    │   │               │   │   └── Monitor.java
    │   │               │   ├── ksql
    │   │               │   │   └── KsqlMonitor.java
    │   │               │   ├── monitor.java
    │   │               │   ├── schemas
    │   │               │   │   ├── SchemaMonitorImpl.java
    │   │               │   │   └── SchemaMonitor.java
    │   │               │   └── topics
    │   │               │       ├── TopicMonitorImpl.java
    │   │               │       └── TopicMonitor.java
    │   │               └── utils
    │   │                   ├── ConfigReader.java
    │   │                   └── Utility.java
    │   └── resources
    └── test
        └── java
            └── com
                └── example
                    └── kafka
                        └── management
```

![plot](https://github.developer.allianz.io/RA-Kafka-Service/KAFKA-java-client/blob/master/kafka-java-client.jpg)


### List All Topics:

```shell script
java -cp kafka-java-client-1.0-jar-with-dependencies.jar com.example.kafka.monitoring.jobs.Monitor cluster_config.json topics
```



### Create Topic:

```shell script
java -cp kafka-java-client-1.0-jar-with-dependencies.jar com.example.kafka.management.jobs.Manage cluster_config.json create-topic javaCreatedTopic1 3 3
```

Arguments explanation:

```shell script
com.example.kafka.management.jobs.Manage -> Takes below parameters

cluster config path : cluster_config.json 

Action to Perform : create-topic 

Topic Name : javaCreatedTopic1

Number of Partitions : 3

replication Factor : 3

```

result:

```shell script
new topic has been created with name: javaCreatedTopic1
```


### Delete Topic

```shell script
java -cp kafka-java-client-1.0-jar-with-dependencies.jar com.example.kafka.management.jobs.Manager cluster_config.json delete-topic javaCreatedTopic
```
Arguments explanation:

```shell script
com.example.kafka.management.jobs.Manage -> Takes below parameters

cluster config path : cluster_config.json 

Action to Perform : delete-topic 

Topic Name : javaCreatedTopic1
```

Result:

```shell script
Topic has been deleted for provided name: javaCreatedTopic1
```

Get Message from topic

```shell script
java -cp kafka-java-client-1.0-jar-with-dependencies.jar com.example.kafka.monitoring.jobs.Monitor cluster_config.json read-topic GRID_CLAIM_SUFFIX
```