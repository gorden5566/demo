package com.gorden5566.demos.algorithm;

import org.junit.Test;

import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache<String, String> cache = new LRUCache<>(8);
        for (int i = 0; i < 32; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }

        cache.get(String.valueOf(25));

        for (Map.Entry<String, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}