package com.gorden5566.leetcode.list;

import org.junit.Test;

public class GetKthFromEndTest {

    @Test
    public void getKthFromEnd1() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1, 2, 3, 4, 5}).build();
        ListUtils.printList(head);
        ListNode kthFromEnd = new GetKthFromEnd().getKthFromEnd(head, 2);
        ListUtils.printList(kthFromEnd);
    }

    @Test
    public void getKthFromEnd2() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1}).build();
        ListUtils.printList(head);
        ListNode kthFromEnd = new GetKthFromEnd().getKthFromEnd(head, 2);
        ListUtils.printList(kthFromEnd);
    }

    @Test
    public void getKthFromEnd3() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1, 2}).build();
        ListUtils.printList(head);
        ListNode kthFromEnd = new GetKthFromEnd().getKthFromEnd(head, 2);
        ListUtils.printList(kthFromEnd);
    }

    @Test
    public void getKthFromEnd4() {
        ListNode head = ListNodeBuilder.builder().build();
        ListUtils.printList(head);
        ListNode kthFromEnd = new GetKthFromEnd().getKthFromEnd(head, 2);
        ListUtils.printList(kthFromEnd);
    }
}