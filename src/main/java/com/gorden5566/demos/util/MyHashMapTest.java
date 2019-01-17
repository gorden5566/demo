package com.gorden5566.demos.util;

import java.util.Map;

/**
 * @author gorden5566
 * @date 2019/1/10
 */
public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap();

        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "value" + i);
        }

        map.put("key1", "test");

        System.out.println(map.get("key1"));
    }
}
