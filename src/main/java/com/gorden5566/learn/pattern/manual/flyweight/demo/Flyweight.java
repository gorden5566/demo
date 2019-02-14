package com.gorden5566.learn.pattern.manual.flyweight.demo;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public abstract class Flyweight {

    /**
     * 内部状态
     */
    private String intrinsic;

    /**
     * 外部状态
     */
    protected final String Extrinsic;

    public Flyweight(String extrinsic) {
        Extrinsic = extrinsic;
    }

    /**
     * 定义业务操作
     */
    public abstract void operate();

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
