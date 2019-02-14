package com.gorden5566.learn.pattern.compare.behavioral.three;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Recorder {
    /**
     * 域名
     */
    private String domain;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 属主
     */
    private String owner;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        String str = "域名：" + this.domain;
        str = str + "\nIP地址：" + this.ip;
        str = str + "\n解析者：" + this.owner;
        return str;
    }
}
