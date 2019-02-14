package com.gorden5566.learn.pattern.manual.factory.common.extend.impl;

import com.gorden5566.learn.pattern.manual.factory.common.extend.AbstractYellowHuman;

public class FemaleBlackHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黑人女性");
    }
}
