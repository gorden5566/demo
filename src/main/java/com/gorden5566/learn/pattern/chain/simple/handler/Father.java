package com.gorden5566.learn.pattern.chain.simple.handler;

import com.gorden5566.learn.pattern.chain.simple.IWomen;

public class Father extends Handler {

    public Father() {
        super(FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }
}
