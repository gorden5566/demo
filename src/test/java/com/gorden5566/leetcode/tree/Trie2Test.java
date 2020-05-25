package com.gorden5566.leetcode.tree;

import org.junit.Test;

/**
 * @author gorden5566
 * @date 2020/05/26
 */
public class Trie2Test {

    @Test
    public void test() {
        Trie2 trie = new Trie2();
        trie.insert("gorden5566".toCharArray());
        System.out.println(trie.find("gorden".toCharArray()));
        System.out.println(trie.find("gorden5566".toCharArray()));

        trie.insert("算法".toCharArray());
        System.out.println(trie.find("算法".toCharArray()));
    }
}