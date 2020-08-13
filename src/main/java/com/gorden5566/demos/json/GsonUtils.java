package com.gorden5566.demos.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author gorden5566
 * @date 2020/08/14
 */
public class GsonUtils {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String toPrettyJson(Object object) {
        return gson.toJson(object);
    }

    public static JsonObject fromJson(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }
}
