package com.gorden5566.learn.pattern.factory.common.extend.impl;

import com.gorden5566.learn.pattern.factory.common.extend.AbstractWhiteHuman;

public class FemaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("白人女性");
    }
}
