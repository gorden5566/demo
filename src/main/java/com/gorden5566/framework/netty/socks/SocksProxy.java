package com.gorden5566.framework.netty.socks;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocksProxy {
    public void run() {
        // 新建线程池
        Executor executor = Executors.newCachedThreadPool();
        Executor executorWorker = Executors.newCachedThreadPool();
        ServerBootstrap serverBootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(executor, executorWorker));

        // 初始化代理部分使用的client
        NioClientSocketChannelFactory cf = new NioClientSocketChannelFactory(executor, executorWorker);

        // 设置处理逻辑
        serverBootstrap.setPipelineFactory(new SocksProxyPipelineFactory(cf));

        // Start up the server.
        serverBootstrap.bind(new InetSocketAddress(1080));
    }

    public static void main(String[] args) {
        new SocksProxy().run();
    }
}
