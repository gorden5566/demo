package com.gorden5566.algorithm;

import com.gorden5566.algorithm.list.ReverseList;
import com.gorden5566.algorithm.util.ListNode;
import com.gorden5566.algorithm.util.ListUtils;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class ReverseListTest {

    @Test
    public void testReverseList() {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.newList(array);
        ListUtils.printList(head);

        ListNode node = ReverseList.ReverseList(head);
        ListUtils.printList(node);
    }
}