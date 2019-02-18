package com.gorden5566.learn.pattern.manual.builder.string;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    public StringBuilder(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
