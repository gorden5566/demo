package com.gorden5566.algorithm.collection;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public class SimpleMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] table;

    private int size = 0;

    public SimpleMap() {
        this.table = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        int index = indexFor(key);

        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node<>(key, value);
            this.size++;
            return null;
        }

        // node != null && node.next != null
        while (node.getNext() != null) {
            if (key.equals(node.getKey())) {
                return node.setValue(value);
            }
            node = node.getNext();
        }

        if (key.equals(node.getKey())) {
            return node.setValue(value);
        } else {
            node.setNext(new Node<>(key, value));
            this.size++;
        }
        return null;
    }

    @Override
    public V get(Object key) {
        int index = indexFor(key);
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                return node.getValue();
            }
        }

        return null;
    }

    private int hashCode(Object key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int indexFor(Object key) {
        int h = hashCode(key);
        return h % this.length();
    }

    @Override
    public int size() {
        return this.size;
    }

    private int length() {
        return this.table.length;
    }
}
