package com.gorden5566.learn.pattern.manual.observer.simple.subject;

import com.gorden5566.learn.pattern.manual.observer.simple.observer.ILiSi;

import java.util.ArrayList;
import java.util.List;

public class HanFeiZi implements IHanFeiZi {

    private List<ILiSi> list = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        for (ILiSi iLiSi : list) {
            iLiSi.update("韩非子在吃饭");
        }
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        for (ILiSi iLiSi : list) {
            iLiSi.update("韩非子在娱乐");
        }
    }

    public void addObserver(ILiSi liSi) {
        this.list.add(liSi);
    }
}
