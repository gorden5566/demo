package com.gorden5566.demos.thread.connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author gorden5566
 * @date 2019/1/5
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.notifyAll();
            }
        }
    }

    /**
     * 在 mills 内无法获取到连接，将会返回 null
     *
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            // 无超时时间设置
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }

                return pool.removeFirst();
            } else {
                // 超时时间点
                long future = System.currentTimeMillis() + mills;
                // 剩余的时间
                long remaining = mills;

                // 连接池为空，并且还有剩余时间，继续等待
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }

                Connection result = null;

                // 取出一个连接
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }

                return result;
            }
        }
    }
}
