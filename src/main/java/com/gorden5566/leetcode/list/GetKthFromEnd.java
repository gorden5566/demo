package com.gorden5566.leetcode.list;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // pre往后移动k个位置
        ListNode pre = head;
        int index = 0;
        while (index < k && pre != null) {
            pre = pre.next;
            index++;
        }

        // 链表长度小于k
        if (index != k) {
            return null;
        }

        // pre移动到尾节点之后
        ListNode target = head;
        while (pre != null) {
            pre = pre.next;
            target = target.next;
        }

        return target;
    }
}
