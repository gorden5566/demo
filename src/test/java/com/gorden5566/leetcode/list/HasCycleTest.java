package com.gorden5566.leetcode.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author gorden5566
 * @date 2020/05/06
 */
public class HasCycleTest {

    @Test
    public void hasCycle1() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(3, 2, 0, -4)).cycle(1).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle(head);
        System.out.println(hasCycle);
    }

    @Test
    public void hasCycle2() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2)).cycle(0).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle(head);
        System.out.println(hasCycle);
    }

    @Test
    public void hasCycle3() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(1)).cycle(-1).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle(head);
        System.out.println(hasCycle);
    }

    @Test
    public void hasCycle11() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(3, 2, 0, -4)).cycle(1).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle1(head);
        System.out.println(hasCycle);
    }

    @Test
    public void hasCycle12() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(1, 2)).cycle(0).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle1(head);
        System.out.println(hasCycle);
    }

    @Test
    public void hasCycle13() {
        ListNode head = ListNodeBuilder.builder().addNodes(Arrays.asList(1)).cycle(-1).build();
        ListUtils.printList(head);
        boolean hasCycle = new HasCycle().hasCycle1(head);
        System.out.println(hasCycle);
    }
}