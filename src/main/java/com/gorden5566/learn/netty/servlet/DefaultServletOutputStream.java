package com.gorden5566.learn.netty.servlet;

import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.http.FullHttpResponse;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

/**
 * @author gorden5566
 * @date 2019/08/23
 */
public class DefaultServletOutputStream extends ServletOutputStream {

    private ByteBufOutputStream out;

    public DefaultServletOutputStream(FullHttpResponse response) {
        this.out = new ByteBufOutputStream(response.content());
    }

    @Override
    public boolean isReady() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(int b) throws IOException {
        this.out.write(b);
    }


}
