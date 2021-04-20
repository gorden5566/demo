package com.gorden5566.leetcode.list;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * <p>
 * 输出：1->1->2->3->4->4
 *
 * @author gorden5566
 * @date 2020/05/06
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }
        return sentinel.next;
    }
}
