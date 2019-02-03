package com.gorden5566.learn.pattern.factory.common.extend.impl;

import com.gorden5566.learn.pattern.factory.common.extend.AbstractWhiteHuman;

public class MaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("白人男性");
    }
}
