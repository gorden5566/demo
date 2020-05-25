package com.gorden5566.leetcode.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/26
 */
public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("trie".toCharArray());
        System.out.println(trie.find("trie".toCharArray()));
        System.out.println(trie.find("true".toCharArray()));

        trie.insert("true".toCharArray());
        System.out.println(trie.find("true".toCharArray()));
    }
}