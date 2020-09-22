package com.gorden5566.demos.pipeline;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public interface Pipeline {

    /**
     * add a handle to the tail
     *
     * @param handler
     */
    void addLast(Handler handler);

    /**
     * init pipeline
     */
    void init();

    /**
     * get the first handler
     *
     * @return
     */
    Handler getBaseHandler();

    /**
     * get next handler in the pipeline
     *
     * @param handler current handler
     * @return next handler
     */
    Handler getNext(Handler handler);
}
