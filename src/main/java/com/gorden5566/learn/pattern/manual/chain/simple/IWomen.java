package com.gorden5566.learn.pattern.manual.chain.simple;

public interface IWomen {
    /**
     * 获得个人状况
     *
     * @return
     */
    int getType();

    /**
     * 获得个人请示， 你要干什么？ 出去逛街？ 约会?还是看电影？
     *
     * @return
     */
    String getRequest();
}
