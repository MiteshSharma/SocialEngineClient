package com.myth.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * Created by mitesh on 26/01/16.
 */
public class JsonParser {
    private Gson gson;
    private static JsonParser instance;

    private JsonParser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static JsonParser getInstance() {
        if (instance == null)
            instance = new JsonParser();
        return instance;
    }

    public <T> T fromJson(String jsonString, Class<T> classOfT) {
        return gson.fromJson(jsonString, classOfT);
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }
}
