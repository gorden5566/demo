package com.gorden5566.framework.netty.socks;

import com.gorden5566.framework.netty.socks.handler.SocksMessageEncoder;
import com.gorden5566.framework.netty.socks.handler.SocksServerHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.handler.codec.socks.SocksInitRequestDecoder;

public class SocksProxyPipelineFactory implements ChannelPipelineFactory {

    private final ClientSocketChannelFactory cf;

    public SocksProxyPipelineFactory(ClientSocketChannelFactory cf) {
        this.cf = cf;
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();

        // add handler
//        pipeline.addLast(SocksInitRequestDecoder.getName(),new SocksInitRequestDecoder());
//        pipeline.addLast(SocksMessageEncoder.getName(),new SocksMessageEncoder());
//        pipeline.addLast(SocksServerHandler.getName(),new SocksServerHandler(cf));

        return pipeline;
    }
}
