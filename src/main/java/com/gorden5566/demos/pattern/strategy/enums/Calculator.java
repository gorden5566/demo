package com.gorden5566.demos.pattern.strategy.enums;

/**
 * @author gorden5566
 * @date 2019-03-26
 */
public enum Calculator {

    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },

    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    }
    ;

    public abstract int exec(int a, int b);

    private String value = "";

    Calculator(String value) {
        this.value = value;
    }
}
