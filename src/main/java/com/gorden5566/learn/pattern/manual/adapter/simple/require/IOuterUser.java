package com.gorden5566.learn.pattern.manual.adapter.simple.require;

import java.util.Map;

public interface IOuterUser {
    /**
     * 基本信息， 比如名称、 性别、 手机号码等
     *
     * @return
     */
    Map<String, String> getUserBaseInfo();

    /**
     * 工作区域信息
     *
     * @return
     */
    Map<String, String> getUserOfficeInfo();

    /**
     * 用户的家庭信息
     *
     * @return
     */
    Map<String, String> getUserHomeInfo();
}
