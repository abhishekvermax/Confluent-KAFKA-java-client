package com.example.kafka.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public static String getValue(String jsonPath,String Key){

        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(jsonPath));
            return data.get(Key).toString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
