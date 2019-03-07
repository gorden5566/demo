package com.gorden5566.algorithm.list;

import com.gorden5566.algorithm.util.ListNode;
import com.gorden5566.algorithm.util.ListUtils;

/**
 * 排序号的链表，去掉其中重复的元素，例如1>2>3>3>4>4>5，变成1>2>5
 *
 * @author gorden5566
 * @date 2019-03-07
 */
public class RemoveRepeat {
    public static void removeRepeat(ListNode list) {
        if (list == null) {
            return;
        }

        ListNode current = list;
        ListNode next = current.next;
        while (next != null) {
            boolean repeat = false;

            // 找到第一个不重复的作为next
            while (next != null && next.val == current.val) {
                next = next.next;
                repeat = true;
            }

            if (repeat) {
                current.next = next;
            }

            // 后移
            current = next;
            next = next.next;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,4,5};

        ListNode list = ListUtils.newList(array);
        ListUtils.printList(list);

        removeRepeat(list);

        ListUtils.printList(list);
    }
}
