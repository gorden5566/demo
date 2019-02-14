package com.gorden5566.learn.pattern.manual.iterator.demo.aggregate;

import com.gorden5566.learn.pattern.manual.iterator.demo.iterator.ConcreteIterator;
import com.gorden5566.learn.pattern.manual.iterator.demo.iterator.Iterator;

import java.util.Vector;

public class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();

    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {
        this.vector.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(vector);
    }
}
