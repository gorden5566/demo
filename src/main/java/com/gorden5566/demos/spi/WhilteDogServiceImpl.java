package com.gorden5566.demos.spi;

/**
 * @author gorden5566
 * @date 2019-03-08
 */
public class WhilteDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("白色dog。。。呼呼大睡觉...");
    }
}
