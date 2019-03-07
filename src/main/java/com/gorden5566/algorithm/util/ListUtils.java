package com.gorden5566.algorithm.util;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class ListUtils {
    public static ListNode newList(int[] array) {
        ListNode head = null;
        ListNode next = null;
        for (int i = array.length - 1; i >= 0; i--) {
            head = new ListNode(array[i]);
            head.next = next;
            next = head;
        }

        return head;
    }

    public static void printList(ListNode list) {
        if (list == null) {
            System.out.println("empty list");
        }
        for (ListNode node = list; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static void printNode(ListNode node) {
        if (node == null) {
            System.out.println("empty node");
        }
        System.out.println(node.val);
    }
}
