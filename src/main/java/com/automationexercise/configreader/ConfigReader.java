package com.automationexercise.configreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties = new Properties();

    static {
        String path = "D:\\TestNGFramework\\src\\test\\java\\com\\automationexercise\\resources\\config.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file from: " + path, e);
        }
    }

    private ConfigReader() {
    }

    // get from system env need to be implemented

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config file: " + key);
        }
        return value.trim();
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean getIsHeadLess() {
        return Boolean.parseBoolean(get("isheadless"));
    }


}
