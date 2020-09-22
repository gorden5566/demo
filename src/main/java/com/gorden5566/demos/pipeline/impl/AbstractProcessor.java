package com.gorden5566.demos.pipeline.impl;

import com.gorden5566.demos.pipeline.Handler;
import com.gorden5566.demos.pipeline.Pipeline;
import com.gorden5566.demos.pipeline.Processor;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public abstract class AbstractProcessor<R, T> implements Processor<R, T> {

    private Pipeline pipeline = new DefaultPipeline();

    protected Handler getBaseHandler() {
        return pipeline.getBaseHandler();
    }

    @Override
    public void addLast(Handler handler) {
        this.pipeline.addLast(handler);
    }

    @Override
    public void init() {
        this.pipeline.init();
    }

    @Override
    public T process(R request) {
        T response = newResponse();

        getBaseHandler().handle(pipeline, request, response);

        return response;
    }

    /**
     * produce a response instance
     *
     * @return
     */
    protected abstract T newResponse();
}
