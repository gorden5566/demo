package com.gorden5566.demos.jetty;

import com.gorden5566.demos.jetty.handler.HelloHandler;
import org.eclipse.jetty.server.Server;

public class JettyServer {
    public static void main(String[] args) throws Exception
    {
		// 创建Server
        Server server = new Server(8080);
		// 设置Handler
        server.setHandler(new HelloHandler());
		// 启动Server
        server.start();
        server.join();
    }
}
