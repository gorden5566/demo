package com.gorden5566.demos.pattern.proxy.simple;

/**
 * @author gorden5566
 * @date 2018/12/25
 */
public class CountProxy implements Count {

    private Count count;

    public CountProxy(Count count) {
        this.count = count;
    }

    @Override
    public void queryCount() {
        System.out.println("before");
        count.queryCount();
        System.out.println("after");
    }

    @Override
    public void updateCount() {
        System.out.println("before");
        count.updateCount();
        System.out.println("after");
    }

    public static void main(String[] args) {
        Count count = new CountImpl();
        CountProxy proxy = new CountProxy(count);

        proxy.queryCount();
        proxy.updateCount();
    }
}
