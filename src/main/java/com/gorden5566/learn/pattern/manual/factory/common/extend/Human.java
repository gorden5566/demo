package com.gorden5566.learn.pattern.manual.factory.common.extend;

public interface Human {
    /**
     * 每个人种的皮肤都有相应的颜色
     */
    void getColor();

    /**
     * 人类会说话
     */
    void talk();

    /**
     * 每个人都有性别
     */
    void getSex();
}
