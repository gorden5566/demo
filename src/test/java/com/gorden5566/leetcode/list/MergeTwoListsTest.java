package com.gorden5566.leetcode.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/06
 */
public class MergeTwoListsTest {

    @Test
    public void mergeTwoLists1() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode l2 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 3, 4)).build();
        ListUtils.printList(l2);

        ListNode lists = new MergeTwoLists().mergeTwoLists(l1, l2);
        ListUtils.printList(lists);
    }

    @Test
    public void mergeTwoLists2() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode lists = new MergeTwoLists().mergeTwoLists(l1, l1);
        ListUtils.printList(lists);
    }

    @Test
    public void mergeTwoLists11() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode l2 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 3, 4)).build();
        ListUtils.printList(l2);

        ListNode lists = new MergeTwoLists().mergeTwoLists1(l1, l2);
        ListUtils.printList(lists);
    }

    @Test
    public void mergeTwoLists12() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode lists = new MergeTwoLists().mergeTwoLists1(l1, l1);
        ListUtils.printList(lists);
    }

    @Test
    public void mergeTwoLists21() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode l2 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 3, 4)).build();
        ListUtils.printList(l2);

        ListNode lists = new MergeTwoLists().mergeTwoLists2(l1, l2);
        ListUtils.printList(lists);
    }

    @Test
    public void mergeTwoLists22() {
        ListNode l1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2, 4)).build();
        ListUtils.printList(l1);

        ListNode lists = new MergeTwoLists().mergeTwoLists2(l1, l1);
        ListUtils.printList(lists);
    }
}