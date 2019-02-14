package com.gorden5566.learn.pattern.compare.behavioral.three.chain;

import com.gorden5566.learn.pattern.compare.behavioral.three.IPUtils;
import com.gorden5566.learn.pattern.compare.behavioral.three.Recorder;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class DnsServer {

    private DnsServer upperServer;

    public void setUpperServer(DnsServer upperServer) {
        this.upperServer = upperServer;
    }

    /**
     * 解析域名
     *
     * @param domain
     * @return
     */
    public final Recorder resolve(String domain) {
        //是本服务器能解析的域名
        if (isLocal(domain)) {
            return echo(domain);
        }

        //提交上级DNS进行解析
        return upperServer.resolve(domain);
    }

    /**
     * 每个DNS都有一个数据处理区（ZONE）,检查域名是否在本区中
     *
     * @param domain
     * @return
     */
    protected abstract boolean isLocal(String domain);

    /**
     * 每个DNS服务器都必须实现解析任务
     *
     * @param domain
     * @return
     */
    protected Recorder echo(String domain) {
        Recorder recorder = new Recorder();

        //获得IP地址
        recorder.setIp(IPUtils.genIpAddress());
        recorder.setDomain(domain);
        return recorder;
    }
}
