package com.gorden5566.demos.pattern.strategy.enums;

/**
 * @author gorden5566
 * @date 2019-03-26
 */
public class TestCalculator {
    public static void main(String[] args) {
        int exec = Calculator.ADD.exec(3, 4);
        System.out.println(exec);
    }
}
