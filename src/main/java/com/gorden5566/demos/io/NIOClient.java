package com.gorden5566.demos.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author gorden5566
 * @date 2019-02-19
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();

        String s = "hello world";

        out.write(s.getBytes());
        out.close();
    }
}
