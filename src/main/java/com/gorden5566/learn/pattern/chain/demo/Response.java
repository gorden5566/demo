package com.gorden5566.learn.pattern.chain.demo;

public class Response {
    private String msg;

    public Response(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
            "msg='" + msg + '\'' +
            '}';
    }
}
