package com.gorden5566.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author gorden5566
 * @date 2020/05/06
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            // 快指针赶上了慢指针
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;

            // 不为null就继续快点走
            if (fast != null) {
                fast = fast.next;
            }
        }

        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> nodes = new HashSet<>();
        ListNode p = head;
        while (p != null && !nodes.contains(p)) {
            nodes.add(p);
            p = p.next;
        }

        // 存在环时，p不会为null
        return p != null;
    }
}
