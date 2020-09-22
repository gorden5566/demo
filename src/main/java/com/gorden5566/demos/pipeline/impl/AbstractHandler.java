package com.gorden5566.demos.pipeline.impl;

import com.gorden5566.demos.pipeline.Handler;
import com.gorden5566.demos.pipeline.Pipeline;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public abstract class AbstractHandler<R, T> implements Handler<R, T> {

    @Override
    public Handler getNext(Pipeline pipeline) {
        return pipeline == null ? null : pipeline.getNext(this);
    }

    @Override
    public void handle(Pipeline pipeline, R request, T response) {
        preHandle(request, response);
        doHandle(pipeline, request, response);
    }

    /**
     * pre process before doHandle
     *
     * @param request
     * @param response
     */
    protected void preHandle(R request, T response) {
        // default do nothing
    }

    /**
     * do handle
     *
     * @param pipeline
     * @param request
     * @param response
     */
    protected abstract void doHandle(Pipeline pipeline, R request, T response);

    /**
     * call next handler
     *
     * @param pipeline
     * @param request
     * @param response
     */
    protected void handleNext(Pipeline pipeline, R request, T response) {
        Handler nextHandler = getNext(pipeline);
        if (nextHandler != null) {
            nextHandler.handle(pipeline, request, response);
        }
    }
}
