package com.example.SystemEvents;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectionConfig {
    public ConnectionConfig() {

    }

    private String PREFIX = "database.connection.";

    public ArrayList<String> getConnectionProps () {

        ArrayList<String> propsList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/connection.properties");
            Properties properties = new Properties();

            properties.load(fis);
            propsList.add(properties.get(PREFIX + "url").toString());
            propsList.add(properties.getProperty(PREFIX + "username").toString());
            propsList.add(properties.getProperty(PREFIX +  "password").toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return propsList;
    }
}