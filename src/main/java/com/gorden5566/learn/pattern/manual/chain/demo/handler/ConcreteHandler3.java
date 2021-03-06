package com.gorden5566.learn.pattern.manual.chain.demo.handler;

import com.gorden5566.learn.pattern.manual.chain.demo.Level;
import com.gorden5566.learn.pattern.manual.chain.demo.Request;
import com.gorden5566.learn.pattern.manual.chain.demo.Response;

public class ConcreteHandler3 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return Level.HIGH_LEVEL;
    }

    @Override
    protected Response echo(Request request) {
        return new Response("ConcreteHandler3");
    }
}
