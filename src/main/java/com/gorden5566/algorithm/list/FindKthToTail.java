package com.gorden5566.algorithm.list;

import com.gorden5566.algorithm.util.ListNode;

/**
 * 题目描述
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class FindKthToTail {

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
            if (first == null) {
                return null;
            }
        }

        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}
