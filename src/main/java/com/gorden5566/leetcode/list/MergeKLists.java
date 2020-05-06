package com.gorden5566.leetcode.list;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * <p>
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author gorden5566
 * @date 2020/05/06
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode p = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            p = mergeTwoLists(p, lists[i]);
        }
        return p;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int left = 0;
        int right = lists.length - 1;

        while (left < right) {
            // 依次合并到左边
            while (left < right) {
                lists[left] = mergeTwoLists(lists[left], lists[right]);
                left++;
                right--;
            }

            // 重置left
            left = 0;
        }

        return lists[0];
    }

    /**
     * 合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == l2) {
            return l1;
        }

        // 哨兵
        ListNode preHead = new ListNode(-1);

        ListNode p = preHead;
        while (l1 != null && l2 != null) {
            // 查找下一个节点
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        // 连接剩余节点
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }

        return preHead.next;
    }
}
