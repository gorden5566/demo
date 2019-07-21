package com.gorden5566.learn.netty.codec.protobuf;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author gorden5566
 * @date 2019/07/21
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeRequestProto.SubscribeRequest request = (SubscribeRequestProto.SubscribeRequest) msg;
        if ("Test".equalsIgnoreCase(request.getUserName())) {
            System.out.println("server accept req: " + request.toString());
            ctx.writeAndFlush(resp(request.getSubReqId()));
        }
    }

    private SubscribeResponseProto.SubscribeResponse resp(int subReqId) {
        SubscribeResponseProto.SubscribeResponse.Builder builder = SubscribeResponseProto.SubscribeResponse.newBuilder();
        builder.setSubReqId(subReqId);
        builder.setRespCode(0);
        builder.setDesc("Never give up");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
