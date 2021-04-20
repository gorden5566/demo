package com.gorden5566.leetcode.list;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author gorden5566
 * @date 2020/05/06
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head.next;
        ListNode p = head;

        while (pre != null) {
            ListNode current = pre;
            pre = pre.next;

            current.next = p;
            p = current;
        }
        head.next = null;

        return p;
    }
}
