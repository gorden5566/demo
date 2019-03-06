package com.gorden5566.demos.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author gorden5566
 * @date 2019-03-05
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        // 建立 socket
        Socket socket = new Socket("127.0.0.1", 7777);

        // 用于输出到 socket
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        printWriter.write(bufferedReader.readLine());

        // close
        printWriter.close();
        bufferedReader.close();
    }
}
