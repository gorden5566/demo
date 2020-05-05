package com.gorden5566.leetcode.list;

/**
 * @author gorden5566
 * @date 2020/05/06
 */
public class ListUtils {
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.printf("[%s]", current.val);
            current = current.next;

            if (current != null) {
                System.out.printf("->");
            }
        }
        System.out.println();
    }
}
