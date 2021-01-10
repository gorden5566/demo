package com.gorden5566.algorithm.collection.map;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public interface Map<K, V> {

    /**
     * put key value pair
     *
     * @param key
     * @param value
     * @return
     */
    V put(K key, V value);

    /**
     * get by key
     *
     * @param key
     * @return
     */
    V get(Object key);

    /**
     * get map size
     *
     * @return
     */
    int size();
}
