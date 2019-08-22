package com.gorden5566.learn.netty.servlet;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/08/21
 */
public class ServletHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

        String uri = msg.uri();
        if (uri.startsWith("/")) {
            if (HttpUtil.is100ContinueExpected(msg)) {
                ctx.channel().writeAndFlush(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE));
            }

            handleHttpServletRequest(ctx, msg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    public void handleHttpServletRequest(ChannelHandlerContext ctx, FullHttpRequest request) throws ServletException, IOException {

        // request
        HttpServletRequest req = getHttpServletRequest(ctx, request);

        // response
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        HttpServletResponse resp = getHttpServletResponse(response);

        // get servlet
        Servlet servlet = getServlet();

        // do service
        servlet.service(req, resp);

        // after service
        resp.getWriter().flush();

        ctx.channel().writeAndFlush(response);
    }

    private HttpServletResponse getHttpServletResponse(FullHttpResponse response) {
        return new DefaultHttpServletResponse(response);
    }

    private HttpServletRequest getHttpServletRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        return new DefaultHttpServletRequest(ctx, request);
    }

    private Servlet getServlet() {
        return new HelloServlet();
    }
}
