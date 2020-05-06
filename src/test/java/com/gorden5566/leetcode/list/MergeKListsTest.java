package com.gorden5566.leetcode.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/06
 */
public class MergeKListsTest {

    @Test
    public void mergeKLists1() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();
        ListNode list2 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 3, 4)).build();
        ListNode list3 = ListNodeBuilder.builder().addNodes(Arrays.asList(2, 6)).build();

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode mergeKLists = new MergeKLists().mergeKLists(lists);
        ListUtils.printList(mergeKLists);
    }

    @Test
    public void mergeKLists2() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();

        ListNode[] lists = new ListNode[]{list1, list1};

        ListNode mergeKLists = new MergeKLists().mergeKLists(lists);
        ListUtils.printList(mergeKLists);
    }

    @Test
    public void mergeKLists3() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();

        ListNode[] lists = new ListNode[]{list1, null};

        ListNode mergeKLists = new MergeKLists().mergeKLists(lists);
        ListUtils.printList(mergeKLists);
    }

    @Test
    public void mergeKLists11() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();
        ListNode list2 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 3, 4)).build();
        ListNode list3 = ListNodeBuilder.builder().addNodes(Arrays.asList(2, 6)).build();

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode mergeKLists = new MergeKLists().mergeKLists1(lists);
        ListUtils.printList(mergeKLists);
    }

    @Test
    public void mergeKLists12() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();

        ListNode[] lists = new ListNode[]{list1, list1};

        ListNode mergeKLists = new MergeKLists().mergeKLists1(lists);
        ListUtils.printList(mergeKLists);
    }

    @Test
    public void mergeKLists13() {
        ListNode list1 = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 4, 5)).build();

        ListNode[] lists = new ListNode[]{list1, null};

        ListNode mergeKLists = new MergeKLists().mergeKLists1(lists);
        ListUtils.printList(mergeKLists);
    }
}