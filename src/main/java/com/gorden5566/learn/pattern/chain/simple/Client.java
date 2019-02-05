package com.gorden5566.learn.pattern.chain.simple;

import com.gorden5566.learn.pattern.chain.simple.handler.Father;
import com.gorden5566.learn.pattern.chain.simple.handler.Handler;
import com.gorden5566.learn.pattern.chain.simple.handler.Husband;
import com.gorden5566.learn.pattern.chain.simple.handler.Son;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        //随机挑选几个女性
        Random rand = new Random();
        List<IWomen> womenList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            womenList.add(new Women(rand.nextInt(4), "我要出去逛街"));
        }
        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        //设置请示顺序
        father.setNext(husband);
        husband.setNext(son);

        for (IWomen women : womenList) {
            father.handleMessage(women);
        }
    }
}
