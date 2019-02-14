package com.gorden5566.learn.pattern.manual.chain.demo.handler;

import com.gorden5566.learn.pattern.manual.chain.demo.Level;
import com.gorden5566.learn.pattern.manual.chain.demo.Request;
import com.gorden5566.learn.pattern.manual.chain.demo.Response;

public abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final Response handleMessage(Request request) {
        Response response = null;
        //判断是否是自己的处理级别
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            //不属于自己的处理级别
            //判断是否有下一个处理者
            if (this.nextHandler != null) {
                response = this.nextHandler.handleMessage(request);
            } else {
            //没有适当的处理者， 业务自行处理
            }
        }
        return response;
    }

    /**
     * 每个处理者都有一个处理级别
     *
     * @return
     */
    protected abstract Level getHandlerLevel();

    /**
     * 每个处理者都必须实现处理任务
     *
     * @param request
     * @return
     */
    protected abstract Response echo(Request request);
}
