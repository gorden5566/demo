package com.gorden5566.demos.thread.http.server;

import java.io.*;
import java.net.Socket;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class HttpRequestHandler implements Runnable {

    /**
     * 根路径
     */
    private String basePath;

    /**
     * socket 连接
     */
    private Socket socket;

    public HttpRequestHandler(String basePath, Socket socket) {
        this.basePath = basePath;
        this.socket = socket;
    }

    @Override
    public void run() {
        String line = null;
        BufferedReader br = null;
        BufferedReader reader = null;
        PrintWriter out = null;
        InputStream in = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String header = reader.readLine();
            if (header == null) {
                return;
            }

            // 由相对路径计算出绝对路径
            String filePath = basePath + header.split(" ")[1];
            System.out.println("file: " + filePath);
            out = new PrintWriter(socket.getOutputStream());

            File file = new File(filePath);
            if (!file.exists()) {
                out.println("HTTP/1.1 404 Not Found");
                out.println("Server: Molly");
                out.println("");
                out.flush();
                close(br, in, reader, out, socket);
                return;
            }

            // 如果请求资源的后缀为 jpg 或者 ico，则读取资源并输出
            if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                in = new FileInputStream(filePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                int i = 0;
                while ((i = in.read()) != -1) {
                    baos.write(i);
                }

                byte[] array = baos.toByteArray();
                out.println("HTTP/1.1 200 OK");
                out.println("Server: Molly");
                out.println("Content-Type: image/jpeg");
                out.println("Accept-Ranges: bytes");
                out.println("Content-Length: " + array.length);
                out.println("");
//                    socket.getOutputStream().write(array, 0, array.length);
            } else {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                out.println("HTTP/1.1 200 OK");
                out.println("Server: Molly");
                out.println("Content-Type: text/html;charset=UTF-8");
                out.println("");
                while ((line = br.readLine()) != null) {
                    out.println(line);
                }
            }

            out.flush();
        } catch (Exception e) {
            out.println("HTTP/1.1 500");
            out.println("Server: Molly");
            out.println("");
            out.flush();
        } finally {
            close(br, in, reader, out, socket);
        }
    }

    void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
