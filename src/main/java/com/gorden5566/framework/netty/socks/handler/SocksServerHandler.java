package com.gorden5566.framework.netty.socks.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.handler.codec.socks.*;

public class SocksServerHandler extends SimpleChannelUpstreamHandler {

    private static final String name = "SOCKS_SERVER_HANDLER";

    private final ClientSocketChannelFactory cf;

    public SocksServerHandler(ClientSocketChannelFactory cf) {
        this.cf = cf;
    }

    public static String getName() {
        return name;
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        SocksRequest socksRequest = (SocksRequest) e.getMessage();
        switch (socksRequest.getSocksRequestType()) {
            case INIT:
                //添加cmd解码器
                ctx.getPipeline().addFirst(SocksCmdRequestDecoder.getName(), new SocksCmdRequestDecoder());
                //简单起见，无需认证
                ctx.getChannel().write(new SocksInitResponse(SocksMessage.AuthScheme.NO_AUTH));
                break;
            case AUTH:
                ctx.getPipeline().addFirst(SocksCmdRequestDecoder.getName(), new SocksCmdRequestDecoder());
                //直接成功
                ctx.getChannel().write(new SocksAuthResponse(SocksMessage.AuthStatus.SUCCESS));
                break;
            case CMD:
                SocksCmdRequest req = (SocksCmdRequest) socksRequest;
                if (req.getCmdType() == SocksMessage.CmdType.CONNECT) {
                    //添加处理连接的handler
                    ctx.getPipeline().addLast(SocksServerConnectHandler.getName(), new SocksServerConnectHandler(cf));
                    ctx.getPipeline().remove(this);
                } else {
                    ctx.getChannel().close();
                }
                break;
            case UNKNOWN:
                break;
        }

        super.messageReceived(ctx, e);
    }
}
