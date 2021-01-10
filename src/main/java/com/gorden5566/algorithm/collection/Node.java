package com.gorden5566.algorithm.collection;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;

    public Node() {
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
