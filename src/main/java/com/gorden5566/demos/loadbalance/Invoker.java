package com.gorden5566.demos.loadbalance;

/**
 * @author gorden5566
 * @date 2019/09/01
 */
public class Invoker {
    private String address;

    private int weight;

    private int invokeNum = 0;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getInvokeNum() {
        return invokeNum;
    }

    public void setInvokeNum(int invokeNum) {
        this.invokeNum = invokeNum;
    }

    /**
     * 模拟调用
     */
    public void invoke() {
        invokeNum++;
    }

    @Override
    public String toString() {
        return "Invoker{" +
            "address='" + address + '\'' +
            ", weight=" + weight +
            ", invokeNum=" + invokeNum +
            '}';
    }
}
