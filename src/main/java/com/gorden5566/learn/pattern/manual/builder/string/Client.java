package com.gorden5566.learn.pattern.manual.builder.string;

/**
 * @author gorden5566
 * @date 2019-02-18
 */
public class Client {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            sb.append((char) ('a' + i));
        }

        System.out.println(sb.toString());
    }
}
