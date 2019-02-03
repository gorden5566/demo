package com.gorden5566.learn.pattern.factory.common.extend.impl;

import com.gorden5566.learn.pattern.factory.common.extend.AbstractYellowHuman;

public class FemaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄人女性");
    }
}
