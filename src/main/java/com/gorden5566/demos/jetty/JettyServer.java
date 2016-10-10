package com.gorden5566.demos.jetty;

import com.gorden5566.demos.jetty.handler.HelloHandler;
import org.eclipse.jetty.server.Server;

public class JettyServer {
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}
