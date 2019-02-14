package com.gorden5566.learn.pattern.manual.state.simple;

import com.gorden5566.learn.pattern.manual.state.simple.state.ClosingState;

/**
 * @author gorden5566
 * @date 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
