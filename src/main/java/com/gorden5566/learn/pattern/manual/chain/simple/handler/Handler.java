package com.gorden5566.learn.pattern.manual.chain.simple.handler;

import com.gorden5566.learn.pattern.manual.chain.simple.IWomen;

public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    //能处理的级别
    private int level = 0;
    //责任传递， 下一个人责任人是谁
    private Handler nextHandler;

    public Handler(int level) {
        this.level = level;
    }

    /**
     * 一个女性（ 女儿、 妻子或者是母亲） 要求逛街， 你要处理这个请求
     *
     * @param women
     */
    public final void handleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            //有后续环节， 才把请求往后递送
            if (this.nextHandler != null) {
                this.nextHandler.handleMessage(women);
            }
            //已经没有后续处理人了， 不用处理了
            else {
                System.out.println("---没地方请示了， 按不同意处理---\n");
            }
        }
    }

    /**
     * 如果不属于你处理的请求， 你应该让她找下一个环节的人， 如女儿出嫁了，
     * 还向父亲请示是否可以逛街， 那父亲就应该告诉女儿， 应该找丈夫请示
     *
     * @param handler
     */
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 有请示那当然要回应
     *
     * @param women
     */
    protected abstract void response(IWomen women);
}
