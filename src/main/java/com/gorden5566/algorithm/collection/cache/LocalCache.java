package com.gorden5566.algorithm.collection.cache;

import com.gorden5566.algorithm.collection.map.Map;
import com.gorden5566.algorithm.collection.map.SimpleMap;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public class LocalCache<K, V> implements Cache<K, V> {

    private final int capacity;

    private Map<K, Node<K, V>> hashMap;

    private Node<K, V> head;
    private Node<K, V> tail;

    public LocalCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new SimpleMap<>(capacity);
    }

    @Override
    public V put(K key, V value) {
        V old = null;
        if (hashMap.containsKey(key)) {
            Node<K, V> node = hashMap.get(key);
            old = node.getValue();
            node.setValue(value);
            remove(node);
            addToTail(node);
        } else if (hashMap.size() >= capacity) {
            Node<K, V> node = removeHead();
            hashMap.remove(node.getKey());

            Node<K, V> newNode = new Node<>(key, value);
            hashMap.put(key, newNode);
            addToTail(newNode);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            hashMap.put(key, newNode);
            addToTail(newNode);
        }

        return old;
    }

    private Node<K, V> removeHead() {
        if (head == null) {
            return null;
        }

        Node<K, V> node = head;
        if (head == tail) {
            head = tail = null;
            return node;
        }

        head = head.getNext();
        return node;
    }

    private void remove(Node<K, V> node) {
        if (node == null) {
            return;
        }

        if (node == head) {
            head = node.getNext();
        } else if (tail == node) {
            tail = node.getNext();
        } else {
            node.getPre().setNext(node.getNext());
        }
    }

    private void addToTail(Node<K, V> node) {
        if (node == null) {
            return;
        }

        if (tail == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        addToTail(node);
        return node.getValue();
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        private Node<K, V> pre;
        private Node<K, V> post;

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

        public Node<K, V> getPre() {
            return pre;
        }

        public void setPre(Node<K, V> pre) {
            this.pre = pre;
        }

        public Node<K, V> getPost() {
            return post;
        }

        public void setPost(Node<K, V> post) {
            this.post = post;
        }
    }
}
