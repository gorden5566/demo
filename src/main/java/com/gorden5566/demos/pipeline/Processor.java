package com.gorden5566.demos.pipeline;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public interface Processor<R, T> {

    /**
     * add a handler to last
     *
     * @param handler
     */
    void addLast(Handler handler);

    /**
     * init processor
     */
    void init();

    /**
     * process request
     *
     * @param request
     * @return
     */
    T process(R request);
}
