package com.gorden5566.learn.pattern.compare.behavioral.three.chain;

import com.gorden5566.learn.pattern.compare.behavioral.three.Recorder;
import com.gorden5566.learn.pattern.compare.behavioral.three.chain.chain.ChinaTopDnsServer;
import com.gorden5566.learn.pattern.compare.behavioral.three.chain.chain.SHDnsServer;
import com.gorden5566.learn.pattern.compare.behavioral.three.chain.chain.TopDnsServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //上海域名服务器
        DnsServer sh = new SHDnsServer();
        //中国顶级域名服务器
        DnsServer china = new ChinaTopDnsServer();
        //全球顶级域名服务器
        DnsServer top = new TopDnsServer();

        //定义查询路径
        china.setUpperServer(top);
        sh.setUpperServer(china);

        //解析域名
        System.out.println("=====域名解析模拟器=====");
        while (true) {
            System.out.println("请输入域名(输入N退出):");
            String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();

            if (domain.equalsIgnoreCase("n")) {
                return;
            }

            Recorder recorder = sh.resolve(domain);
            System.out.println("----DNS服务器解析结果----");
            System.out.println(recorder);
        }
    }
}
