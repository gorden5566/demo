package com.gorden5566.demos.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author gorden5566
 * @date 2019-03-06
 */
public class ZooKeeperProSync implements Watcher {

    private static Logger logger = LoggerFactory.getLogger(ZooKeeperProSync.class);

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        //zookeeper配置数据存放路径
        String path = "/username";

        //连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new ZooKeeperProSync());

        //等待zk连接成功的通知
        connectedSemaphore.await();

        try {
            zk.create(path, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            logger.error("create node failed", e);
        }

        //获取path目录节点的配置数据，并注册默认的监听器
        logger.info(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        if (KeeperState.SyncConnected == event.getState()) {
            //zk连接成功通知事件
            if (EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            }

            // zk目录节点数据变化通知事件
            else if (event.getType() == EventType.NodeDataChanged) {
                try {
                    logger.info("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                }
            }
        }
    }
}
