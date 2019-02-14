package com.gorden5566.learn.pattern.compare.behavioral.three.chain.chain;

import com.gorden5566.learn.pattern.compare.behavioral.three.chain.DnsServer;
import com.gorden5566.learn.pattern.compare.behavioral.three.Recorder;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class ChinaTopDnsServer extends DnsServer {
    @Override
    protected boolean isLocal(String domain) {
        return domain.endsWith(".cn");
    }

    @Override
    protected Recorder echo(String domain) {
        Recorder recorder = super.echo(domain);
        recorder.setOwner("中国顶级DNS服务器");
        return recorder;
    }
}
