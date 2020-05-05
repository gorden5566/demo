package com.gorden5566.leetcode.list;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author gorden5566
 * @date 2020/05/06
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 只有head节点
        if (head.next == null) {
            return head;
        }

        // 还有后续节点
        ListNode tail = head.next;
        ListNode reverseHead = reverseList(tail);

        tail.next = head;
        head.next = null;

        return reverseHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // 两个指针用于反转
        ListNode pre = head.next;
        ListNode p = head;

        // head.next
        head.next = null;

        // 双指针后移，依次反转
        while (pre != null) {
            // 保存pre节点指针
            ListNode temp = pre;

            // pre往后移
            pre = pre.next;

            // 修改指针指向方向
            temp.next = p;

            // p跟过来
            p = temp;
        }

        return p;
    }
}
