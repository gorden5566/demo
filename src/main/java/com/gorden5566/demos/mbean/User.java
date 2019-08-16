package com.gorden5566.demos.mbean;

/**
 * @author gorden5566
 * @date 2019/08/15
 */
public class User implements UserMBean {

    private String name;
    private String password;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void SetPassword(String password) {
        this.password = password;
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
