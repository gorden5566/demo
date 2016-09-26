package com.gorden5566.demos.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StreamsTest {
    private static final Log logger = LogFactory.getLog(StreamsTest.class);
    @Test
    public void test() {
        Streams streams = new Streams("Streams.txt");

        try {
            DataOutputStream out = streams.getDataOutPutStream();
            out.writeInt(3);
            out.writeBoolean(true);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInputStream in = streams.getDataInputStream();
            logger.info(in.readInt());
            logger.info(in.readBoolean());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}