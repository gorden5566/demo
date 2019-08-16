package com.gorden5566.learn.jetty.simple;

import org.eclipse.jetty.server.Server;

/**
 * @author gorden5566
 * @date 2019/08/16
 */
public class SimplestServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.start();
        server.dumpStdErr();
        server.join();
    }
}
