package com.gorden5566.learn.pattern.flyweight.simple;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class SignInfo4Pool extends SignInfo {

    /**
     * 定义一个对象池提取的KEY值
     */
    private String key;

    public SignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
