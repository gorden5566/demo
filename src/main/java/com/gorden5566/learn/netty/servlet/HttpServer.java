package com.gorden5566.learn.netty.servlet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author gorden5566
 * @date 2019/08/20
 */
public class HttpServer {
    public static void main(String[] args) throws InterruptedException {
        DefaultServletFactory.addServletWithMapping(HelloServlet.class, "/");
        DefaultServletFactory.addServletWithMapping(HelloServlet.class, "/hello");

        new HttpServer().run("127.0.0.1", 8080);
    }

    public void run(final String host, final int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(getChannelInitializer());

            ChannelFuture future = bootstrap.bind(host, port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private ChannelInitializer getChannelInitializer() {
        return new DefaultChannelInitializer();
    }
}
