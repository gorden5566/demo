package com.gorden5566.demos.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_SIZE;

    public FIFOCache(int maxSize) {
        super(maxSize, 0.75f, false);
        MAX_SIZE = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_SIZE;
    }
}
