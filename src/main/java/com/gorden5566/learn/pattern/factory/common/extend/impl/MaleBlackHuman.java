package com.gorden5566.learn.pattern.factory.common.extend.impl;

import com.gorden5566.learn.pattern.factory.common.extend.AbstractBlackHuman;

public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑人男性");
    }
}
