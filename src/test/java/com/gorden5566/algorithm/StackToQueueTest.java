package com.gorden5566.algorithm;

import com.gorden5566.algorithm.stack.StackToQueue;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2019-03-07
 */
public class StackToQueueTest {

    @Test
    public void testPop() {
        StackToQueue queue = new StackToQueue();

        queue.push(1);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(2);
        System.out.println(queue.pop());

        queue.push(6);
        System.out.println(queue.pop());
    }
}