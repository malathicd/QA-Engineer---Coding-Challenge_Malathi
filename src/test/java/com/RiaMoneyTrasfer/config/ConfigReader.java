package com.RiaMoneyTrasfer.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();
    private static boolean loaded = false;

    private ConfigReader() {
    }

    public static synchronized void loadProperties() {
        if (loaded) {
            return;
        }

        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException(
                        "config.properties was not found in src/test/resources");
            }
            PROPERTIES.load(input);
            loaded = true;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        loadProperties();
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing or empty property in config.properties: " + key);
        }
        return value.trim();
    }
}
