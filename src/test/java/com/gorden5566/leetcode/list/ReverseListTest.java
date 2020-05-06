package com.gorden5566.leetcode.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/06
 */
public class ReverseListTest {

    @Test
    public void reverseList1() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 3, 4, 5)).build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList(head);
        ListUtils.printList(reverseList);
    }

    @Test
    public void reverseList2() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1}).build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList(head);
        ListUtils.printList(reverseList);
    }

    @Test
    public void reverseList3() {
        ListNode head = ListNodeBuilder.builder().build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList(head);
        ListUtils.printList(reverseList);
    }

    @Test
    public void reverseList11() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1, 2, 3, 4, 5}).build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList1(head);
        ListUtils.printList(reverseList);
    }

    @Test
    public void reverseList12() {
        ListNode head = ListNodeBuilder.builder().addNodes(new int[]{1}).build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList1(head);
        ListUtils.printList(reverseList);
    }

    @Test
    public void reverseList13() {
        ListNode head = ListNodeBuilder.builder().build();
        ListUtils.printList(head);
        ListNode reverseList = new ReverseList().reverseList1(head);
        ListUtils.printList(reverseList);
    }
}