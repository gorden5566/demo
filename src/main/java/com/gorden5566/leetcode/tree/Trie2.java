package com.gorden5566.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2020/05/26
 */
public class Trie2 {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            if (p.childMap.get(text[i]) == null) {
                TrieNode node = new TrieNode(text[i]);
                p.childMap.put(text[i], node);
            }
            p = p.childMap.get(text[i]);
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            if (p.childMap.get(pattern[i]) == null) {
                return false;
            }
            p = p.childMap.get(pattern[i]);
        }
        return p.isEndingChar;
    }

    public class TrieNode {
        public char data;
        public Map<Character, TrieNode> childMap = new HashMap<>();
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
