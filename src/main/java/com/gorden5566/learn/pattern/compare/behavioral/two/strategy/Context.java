package com.gorden5566.learn.pattern.compare.behavioral.two.strategy;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Context {
    private WorkAlgorithm workMethod;

    public WorkAlgorithm getWorkMethod() {
        return workMethod;
    }

    public void setWorkMethod(WorkAlgorithm workMethod) {
        this.workMethod = workMethod;
    }

    /**
     * 每个算法都有必须具有的功能
     */
    public void work(){
        workMethod.work();
    }
}
