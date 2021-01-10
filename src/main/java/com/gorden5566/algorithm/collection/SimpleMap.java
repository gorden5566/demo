package com.gorden5566.algorithm.collection;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public class SimpleMap<K, V> implements Map<K, V>{

    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] table;

    private int size = 0;

    public SimpleMap() {
        this.table = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        int h = hashCode(key);
        int index = h % this.length();
        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            this.size++;
            return null;
        }

        Node<K, V> node = table[index];
        while (node.getNext() != null && !key.equals(node.getKey())) {
            node = node.getNext();
        }
        if (key.equals(node.getKey())) {
            V old = node.getValue();
            node.setValue(value);
            return old;
        } else {
            node.setNext(new Node<>(key, value));
            this.size++;
            return null;
        }
    }

    @Override
    public V get(Object key) {
        int h = hashCode(key);
        int index = h % this.length();

        Node<K, V> node = table[index];
        while (node != null && !key.equals(node.getKey())) {
            node = node.getNext();
        }

        return node != null ? node.getValue() : null;
    }

    private int hashCode(Object key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    @Override
    public int size() {
        return this.size;
    }

    private int length() {
        return this.table.length;
    }
}
