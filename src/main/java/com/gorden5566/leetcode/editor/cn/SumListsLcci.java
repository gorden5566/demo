//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学


package com.gorden5566.leetcode.editor.cn;
public class SumListsLcci{
    public static void main(String[] args) {
         Solution solution = new SumListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return null;
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            int current = sum % 10;
            carry = sum / 10;

            p.next = new ListNode(current);

            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 != null) {
            while (p1 != null) {
                int sum = p1.val + carry;
                int current = sum % 10;
                carry = sum / 10;

                p.next = new ListNode(current);
                p = p.next;
                p1 = p1.next;
            }
        } else if (p2 != null) {
            while (p2 != null) {
                int sum = p2.val + carry;
                int current = sum % 10;
                carry = sum / 10;

                p.next = new ListNode(current);
                p = p.next;
                p2 = p2.next;
            }
        }

        if (carry > 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}