package com.gorden5566.learn.pattern.chain.demo.handler;

import com.gorden5566.learn.pattern.chain.demo.Level;
import com.gorden5566.learn.pattern.chain.demo.Request;
import com.gorden5566.learn.pattern.chain.demo.Response;

public class ConcreteHandler2 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return Level.MIDDLE_LEVEL;
    }

    @Override
    protected Response echo(Request request) {
        return new Response("ConcreteHandler2");
    }
}
