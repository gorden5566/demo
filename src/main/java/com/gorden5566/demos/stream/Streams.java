package com.gorden5566.demos.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Streams {
    private static final Logger logger = LoggerFactory.getLogger(Streams.class);

    private static final String CLASSPATH;
    static {
        CLASSPATH = Streams.class.getClassLoader().getResource("").getPath();
    }

    private String fileName;

    public Streams(String fileName) {
        this.fileName = CLASSPATH + fileName;
    }

    public DataOutputStream getDataOutPutStream() throws IOException {
        logger.info("fileName: " + fileName);
        // 节点流FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        // 过滤流BufferedOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        // 过滤流DataOutputStream
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

        return dataOutputStream;
    }

    public DataInputStream getDataInputStream() throws IOException {
        logger.info("fileName: " + fileName);
        // 节点流FileInputStream
        FileInputStream fileInputStream = new FileInputStream(fileName);
        // 装饰流BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // 装饰流DataInputStream
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        return dataInputStream;
    }
}
