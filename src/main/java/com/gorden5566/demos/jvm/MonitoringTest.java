package com.gorden5566.demos.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MonitoringTest {
    /**
     * 内存占位符对象，一个 OOMObject 大约占 64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
