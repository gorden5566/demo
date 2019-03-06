package com.gorden5566.demos.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gorden5566
 * @date 2019-03-05
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        Socket socket;

        ServerSocket serverSocket = new ServerSocket(7777);

        while (true) {
            socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("result is: " + bufferedReader.readLine());
        }
    }
}
