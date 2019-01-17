package com.gorden5566.demos.thread.http.server;

import com.gorden5566.demos.thread.pool.DefaultThreadPool;
import com.gorden5566.demos.thread.pool.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class SimpleHttpServer {
    /**
     * 处理 HttpRequest 的线程池
     */
    private static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(3);

    /**
     * SimpleHttpServer 的根路径
     */
    private static String basePath;
    private static ServerSocket serverSocket;

    /**
     * 服务监听端口
     */
    private static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;

        while ((socket = serverSocket.accept()) != null) {
            // 接收一个客户端 Socket，生成一个 HttpRequestHandler，放入线程池执行
            threadPool.execute(new HttpRequestHandler(basePath, socket));
        }
        serverSocket.close();
    }
}
