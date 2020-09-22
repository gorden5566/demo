package com.gorden5566.demos.pipeline.impl;

import com.gorden5566.demos.pipeline.Handler;
import com.gorden5566.demos.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public class DefaultPipeline implements Pipeline {

    /**
     * all handler
     */
    private List<Handler> handlerList = new ArrayList<>();

    /**
     * the first handler
     */
    private Handler baseHandler;

    /**
     * key: current handler
     * value: next handler
     */
    private Map<Handler, Handler> nextHandlerMap;

    @Override
    public void addLast(Handler handler) {
        if (handler != null) {
            this.handlerList.add(handler);
        }
    }

    @Override
    public void init() {
        // the first handler is base handler
        this.baseHandler = this.handlerList.get(0);

        // init nextHandlerMap
        this.nextHandlerMap = new HashMap<>();
        int size = this.handlerList.size();
        for (int index = 0; index < size; index++) {
            Handler currentHandler = this.handlerList.get(index);

            Handler nextHandler = null;
            if (index + 1 < size) {
                nextHandler = this.handlerList.get(index + 1);
            }

            this.nextHandlerMap.put(currentHandler, nextHandler);
        }
    }

    @Override
    public Handler getBaseHandler() {
        return baseHandler;
    }

    @Override
    public Handler getNext(Handler handler) {
        return nextHandlerMap.get(handler);
    }
}
