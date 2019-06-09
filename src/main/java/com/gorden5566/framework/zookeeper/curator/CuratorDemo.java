package com.gorden5566.framework.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019-05-25
 */
public class CuratorDemo {

    private static Logger logger = LoggerFactory.getLogger(CuratorDemo.class);

    private static String zookeeperConnectionString = "127.0.0.1:2181";

    public static void main(String[] args) throws IOException {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();

        try {
            client.create().creatingParentsIfNeeded().forPath("/my/path", "CuratorDemo".getBytes());
        } catch (Exception e) {
           logger.error("create node failed", e);
        }

        System.in.read();
    }
}
