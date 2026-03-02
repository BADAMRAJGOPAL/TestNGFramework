package com.automationexercise.configreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private  ConfigReader(){

    }
    // get from system env need to be implemented
    static Properties properties;
    static {
        try{
            FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file from: " , e);
        }
    }

    public static String get(String key){
       String value =properties.getProperty(key);
       if(value==null){
           throw new RuntimeException("Key not found in config file: " + key);
       }
       return value.trim();
    }
}
