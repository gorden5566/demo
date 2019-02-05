package com.gorden5566.learn.pattern.chain.demo;

import com.gorden5566.learn.pattern.chain.demo.handler.ConcreteHandler1;
import com.gorden5566.learn.pattern.chain.demo.handler.ConcreteHandler2;
import com.gorden5566.learn.pattern.chain.demo.handler.ConcreteHandler3;
import com.gorden5566.learn.pattern.chain.demo.handler.Handler;

public class Client {
    public static void main(String[] args) {
        //声明所有的处理节点
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        //设置链中的阶段顺序1-->2-->3
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        //提交请求， 返回结果
        Response response = handler1.handleMessage(new Request());
        System.out.println(response);
    }
}
