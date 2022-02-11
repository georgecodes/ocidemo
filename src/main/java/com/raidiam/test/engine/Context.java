package com.raidiam.test.engine;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Object> properties = new HashMap<>();

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public String getProperty(String key) {
        Object value = properties.get(key);
        if(value instanceof String) {
            return String.valueOf(value);
        }
        throw new RuntimeException("Property " + key + " is not a string");
    }

    public JsonObject getObject(String key) {
        Object value = properties.get(key);
        if(value instanceof JsonObject) {
            return (JsonObject) value;
        }
        throw new RuntimeException("Property " + key + " is not a json object");
    }

    public int getIntProperty(String key) {
        Object value = properties.get(key);
        if(value instanceof Integer) {
            return (int) value;
        }
        throw new RuntimeException("Property " + key + " is not an integer");
    }

}
