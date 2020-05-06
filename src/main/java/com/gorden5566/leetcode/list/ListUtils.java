package com.gorden5566.leetcode.list;

import java.util.HashSet;
import java.util.Set;

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

        // 用于检测环
        Set<ListNode> nodes = new HashSet<>();

        ListNode current = head;
        while (current != null && !nodes.contains(current)) {
            nodes.add(current);
            System.out.printf("[%s]", current.val);
            current = current.next;

            if (current != null) {
                System.out.printf("->");
            }
        }

        // 环节点
        if (current != null) {
            System.out.printf("(%s)", current.val);
        }
        System.out.println();
    }
}
