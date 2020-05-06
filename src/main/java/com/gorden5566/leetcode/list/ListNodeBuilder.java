package com.gorden5566.leetcode.list;

import java.util.List;

public class ListNodeBuilder {
    private ListNode head;
    private ListNode tail;

    public static ListNodeBuilder builder() {
        return new ListNodeBuilder();
    }

    /**
     * 添加一个节点
     *
     * @param val
     * @return
     */
    public ListNodeBuilder addNode(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        return this;
    }

    /**
     * 添加一组节点
     *
     * @param valArr
     * @return
     */
    public ListNodeBuilder addNodes(int[] valArr) {
        if (valArr == null || valArr.length == 0) {
            return this;
        }
        for (int val : valArr) {
            addNode(val);
        }
        return this;
    }

    /**
     * 添加一组节点
     *
     * @param valList
     * @return
     */
    public ListNodeBuilder addNodes(List<Integer> valList) {
        if (valList == null || valList.isEmpty()) {
            return this;
        }
        for (Integer val : valList) {
            if (val != null) {
                addNode(val);
            }
        }
        return this;
    }

    /**
     * 构建
     *
     * @return
     */
    public ListNode build() {
        return head;
    }
}
