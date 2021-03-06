package com.gorden5566.learn.pattern.compare.behavioral.three.observer.observer;

import com.gorden5566.learn.pattern.compare.behavioral.three.Recorder;
import com.gorden5566.learn.pattern.compare.behavioral.three.observer.DnsServer;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class SHDnsServer extends DnsServer {
    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("上海DNS服务器");
    }

    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }
}
