package com.gorden5566.learn.jetty.hello;

import org.eclipse.jetty.server.Server;

/**
 * @author gorden5566
 * @date 2019/08/16
 */
public class OneHandler {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());

        server.start();
        server.join();
    }
}
