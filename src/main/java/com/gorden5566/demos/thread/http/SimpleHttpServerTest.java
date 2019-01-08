package com.gorden5566.demos.thread.http;

import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class SimpleHttpServerTest {
    public static void main(String[] args) throws IOException {
        SimpleHttpServer.setPort(4001);
        SimpleHttpServer.setBasePath("/Users/gorden5566");

        SimpleHttpServer.start();

        System.out.println("test");
    }
}
