package com.gorden5566.demos.mbean;

/**
 * @author gorden5566
 * @date 2019/08/15
 */
public interface UserMBean {

    String getName();

    void SetName(String name);

    String getPassword();

    void SetPassword(String password);

    int add(int x, int y);
}
