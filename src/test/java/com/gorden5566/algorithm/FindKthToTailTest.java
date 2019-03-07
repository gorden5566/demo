package com.gorden5566.algorithm;

import com.gorden5566.algorithm.list.FindKthToTail;
import com.gorden5566.algorithm.util.ListNode;
import com.gorden5566.algorithm.util.ListUtils;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class FindKthToTailTest {

    @Test
    public void testFindKthToTail() {
        int[] array = {1,2,3,4,5};
        ListNode list = ListUtils.newList(array);
        ListUtils.printList(list);

        ListNode node = FindKthToTail.FindKthToTail(list, 1);
        ListUtils.printList(node);

    }
}