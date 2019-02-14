package com.gorden5566.learn.pattern.manual.iterator.demo;

import com.gorden5566.learn.pattern.manual.iterator.demo.aggregate.Aggregate;
import com.gorden5566.learn.pattern.manual.iterator.demo.aggregate.ConcreteAggregate;
import com.gorden5566.learn.pattern.manual.iterator.demo.iterator.Iterator;

public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("abc");
        aggregate.add("aaa");
        aggregate.add("1234");

        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
