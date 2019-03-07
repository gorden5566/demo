package com.gorden5566.algorithm.list;

import com.gorden5566.algorithm.util.ListNode;

import java.util.ArrayList;

/**
 * 题目描述
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author gorden5566
 * @date 2019-03-06
 */
public class PrintList {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        ListNode currentNode = listNode;
        while (currentNode != null) {
            result.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int size = result.size();
        for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--) {
            swap(result, i, j);
        }

        return result;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        final ArrayList l = list;
        l.set(i, l.set(j, l.get(i)));
    }
}
