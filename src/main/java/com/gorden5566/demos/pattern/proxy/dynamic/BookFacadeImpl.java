package com.gorden5566.demos.pattern.proxy.dynamic;

/**
 * @author gorden5566
 * @date 2018/12/25
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("addBook...");
    }
}
