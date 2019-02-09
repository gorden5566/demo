package com.gorden5566.learn.pattern.observer.simple;

import com.gorden5566.learn.pattern.observer.simple.observer.LiSi;
import com.gorden5566.learn.pattern.observer.simple.subject.HanFeiZi;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();

        // 李斯来观察了
        hanFeiZi.addObserver(new LiSi());

        //然后我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();
        //韩非子娱乐了
        hanFeiZi.haveFun();
    }
}
