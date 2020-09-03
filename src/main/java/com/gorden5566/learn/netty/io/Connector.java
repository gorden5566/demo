package com.gorden5566.learn.netty.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.ServerSocketChannel;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class Connector {
    private String host;
    private int port;
    private boolean reuseAddress;
    private int acceptQueueSize;

    private volatile ServerSocketChannel acceptChannel;
    private volatile int localPort;

    /**
     * @link SocketOptions#TCP_NODELAY
     */
    private volatile boolean acceptedTcpNoDelay = true;

    /**
     * @link SocketOptions#SO_RCVBUF
     */
    private volatile int acceptedReceiveBufferSize = -1;

    /**
     * @link SocketOptions#SO_SNDBUF SO_SNDBUF
     */
    private volatile int acceptedSendBufferSize = -1;

    public void open() throws IOException {
        if (acceptChannel == null) {
            acceptChannel = openAcceptChannel();

            // set non blocking
            acceptChannel.configureBlocking(true);

            localPort = acceptChannel.socket().getLocalPort();
            if (localPort <= 0) {
                throw new IOException("Server channel not bound");
            }
        }
    }

    public ServerSocketChannel openAcceptChannel() throws IOException {
        // open an server socket channel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        // get address
        InetSocketAddress bindAddress = getHost() == null ? new InetSocketAddress(getPort()) : new InetSocketAddress(getHost(), getPort());

        // reuse address
        serverChannel.socket().setReuseAddress(getReuseAddress());

        // bind address, set backlog
        serverChannel.socket().bind(bindAddress, getAcceptQueueSize());

        return serverChannel;
    }

    public void configure(Socket socket) {
        try {
            socket.setTcpNoDelay(acceptedTcpNoDelay);
            if (acceptedReceiveBufferSize > -1) {
                socket.setReceiveBufferSize(acceptedReceiveBufferSize);
            }
            if (acceptedSendBufferSize > -1) {
                socket.setSendBufferSize(acceptedSendBufferSize);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean getReuseAddress() {
        return reuseAddress;
    }

    public void setReuseAddress(boolean reuseAddress) {
        this.reuseAddress = reuseAddress;
    }

    public int getAcceptQueueSize() {
        return acceptQueueSize;
    }

    public void setAcceptQueueSize(int acceptQueueSize) {
        this.acceptQueueSize = acceptQueueSize;
    }
}
