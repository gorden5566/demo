package com.gorden5566.algorithm.stack;

import java.util.Stack;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class StackToQueue {
    /**
     * 用于入队
     */
    Stack<Integer> stack1 = new Stack<Integer>();

    /**
     * 用于出队
     */
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        // 入队
        stack1.push(node);
    }

    public int pop() {
        // 不为空，直接出队
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        // 全部倒过来，用于出队
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
