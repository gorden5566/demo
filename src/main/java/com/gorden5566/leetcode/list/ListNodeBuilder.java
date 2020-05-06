package com.gorden5566.leetcode.list;

import java.security.InvalidParameterException;
import java.util.List;

public class ListNodeBuilder {
    private ListNode head;
    private ListNode tail;
    private Integer pos;

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
     * 设置环的位置
     * 从0开始
     *
     * @param pos
     * @return
     */
    public ListNodeBuilder cycle(Integer pos) {
        this.pos = pos;
        return this;
    }

    /**
     * 构建
     *
     * @return
     */
    public ListNode build() {
        if (pos != null && pos >= 0) {
            int index = 0;
            ListNode p = head;
            while (index < pos && p != null) {
                index++;
                p = p.next;
            }
            if (index != pos) {
                throw new InvalidParameterException("pos: " + pos);
            }
            tail.next = p;
        }
        return head;
    }
}
