package com.gorden5566.learn.netty.codec.serialize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author gorden5566
 * @date 2019/07/21
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeRequest request = (SubscribeRequest) msg;
        if ("Test".equalsIgnoreCase(request.getUserName())) {
            System.out.println("server accept req: " + request.toString());
            ctx.writeAndFlush(resp(request.getSubReqId()));
        }
    }

    private SubscribeResponse resp(int subReqId) {
        SubscribeResponse response = new SubscribeResponse();
        response.setSubReqId(subReqId);
        response.setRespCode(0);
        response.setDesc("Never give up");
        return response;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
