package com.gorden5566.demos.pipeline;

/**
 * @author gorden5566
 * @date 2020/09/23
 */
public interface Handler<R, T> {

    /**
     * get next handler in the pipeline
     *
     * @param pipeline
     * @return
     */
    Handler getNext(Pipeline pipeline);

    /**
     * process the request
     *
     * @param pipeline
     * @param request
     * @param response
     */
    void handle(Pipeline pipeline, R request, T response);
}
