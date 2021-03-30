package com.example.kafka.component;

import com.example.kafka.utils.ConfigReader;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Admin extends ConfigReader {

    private final String BOOTSTRAP_SERVERS = "bootstrapServers";
    private final String SSL_CONFIG_FILE="sslConfigFile";

    public AdminClient client(String jsonPath) throws IOException{

        Properties adminProps = new Properties();
        adminProps.load(new FileInputStream(ConfigReader.getValue(jsonPath, SSL_CONFIG_FILE)));
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigReader.getValue(jsonPath, BOOTSTRAP_SERVERS));

        return AdminClient.create(adminProps);
    }
}
