package com.gorden5566.algorithm.stack;

import java.util.Stack;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class StackMin {
    Stack<Integer> valStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        valStack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
        }
    }

    public void pop() {
        Integer pop = valStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return valStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
