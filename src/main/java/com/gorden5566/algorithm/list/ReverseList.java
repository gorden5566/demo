package com.gorden5566.algorithm.list;

import com.gorden5566.algorithm.util.ListNode;

/**
 * 题目描述
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class ReverseList {

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;

            if (next == null) {
                reverseHead = node;
            }

            node.next = pre;

            pre = node;
            node = next;
        }

        return reverseHead;
    }
}
