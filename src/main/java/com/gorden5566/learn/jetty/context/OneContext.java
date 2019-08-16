package com.gorden5566.learn.jetty.context;

import com.gorden5566.learn.jetty.hello.HelloHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * @author gorden5566
 * @date 2019/08/16
 */
public class OneContext {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ContextHandler context = new ContextHandler();
        context.setContextPath("/hello");
        context.setHandler(new HelloHandler());

        server.setHandler(context);

        server.start();
        server.join();
    }
}
