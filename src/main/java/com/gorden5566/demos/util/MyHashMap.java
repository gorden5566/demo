package com.gorden5566.demos.util;

import java.util.*;

/**
 * @author gorden5566
 * @date 2019/1/10
 */
public class MyHashMap<K, V> /*implements Map<K, V>*/ {

    private static final int DEFAULT_CAPACITY = 16;

    private Entry<K, V>[] table;

    private int size = 0;

    public MyHashMap() {
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    class Entry<K, V> {
        private K k;
        private V v;
        private Entry next;

        public Entry(K k, V v, Entry next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % DEFAULT_CAPACITY;

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.k.equals(key)) {
                return entry.v;
            }
        }

        return null;
    }

    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % DEFAULT_CAPACITY;

        // 判断原key是否存在，若存在则修改对应的value
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.k.equals(key)) {
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }

        // 新创建节点，指向当前的头结点
        addEntry(key, value, index);

        return null;
    }

    private void addEntry(K key, V value, int index) {
        Entry entry = new Entry(key, value, table[index]);
        table[index] = entry;
        size++;
    }
}
