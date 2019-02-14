package com.gorden5566.learn.pattern.compare.behavioral.three.observer;

import com.gorden5566.learn.pattern.compare.behavioral.three.IPUtils;
import com.gorden5566.learn.pattern.compare.behavioral.three.Recorder;

import java.util.Observable;
import java.util.Observer;

/**
 * 既是被观察者，发送请求通知
 * 又是观察者，接收下级发过来的通知
 *
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class DnsServer extends Observable implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        Recorder recorder = (Recorder) arg;
        //如果本机能解析
        if (isLocal(recorder)) {
            recorder.setIp(IPUtils.genIpAddress());
        }
        //本机不能解析，则提交到上级DNS
        else {
            responseFromUpperServer(recorder);
        }

        //签名
        sign(recorder);
    }

    /**
     * 作为被观察者，允许增加观察者，这里上级DNS一般只有一个
     *
     * @param dnsServer
     */
    public void setUpperServer(DnsServer dnsServer) {
        //先清空，然后再增加
        super.deleteObservers();

        // 作为被观察者Observable，添加观察者Observer
        super.addObserver(dnsServer);
    }

    /**
     * 向父DNS请求解析，也就是通知观察者
     *
     * @param recorder
     */
    private void responseFromUpperServer(Recorder recorder) {
        super.setChanged();

        // 作为被观察者Observable，通知观察者Observer
        super.notifyObservers(recorder);
    }

    /**
     * 每个DNS服务器签上自己的名字
     *
     * @param recorder
     */
    protected abstract void sign(Recorder recorder);

    /**
     * 每个DNS服务器都必须定义自己的处理级别
     *
     * @param recorder
     * @return
     */
    protected abstract boolean isLocal(Recorder recorder);
}
