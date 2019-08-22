package com.gorden5566.learn.netty.servlet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author gorden5566
 * @date 2019/08/23
 */
public class DefaultChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
        ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
        ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        ch.pipeline().addLast("servlet-handler", new ServletHandler());
    }
}
