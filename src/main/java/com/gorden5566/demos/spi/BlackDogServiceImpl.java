package com.gorden5566.demos.spi;

/**
 * @author gorden5566
 * @date 2019-03-08
 */
public class BlackDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("黑色dog。。。汪汪叫，不睡觉...");
    }
}
