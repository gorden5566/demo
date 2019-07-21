package com.gorden5566.learn.netty.codec.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date 2019/07/21
 */
public class TestSubscribeRequestProto {
    private static byte[] encode(SubscribeRequestProto.SubscribeRequest request) {
        return request.toByteArray();
    }

    private static SubscribeRequestProto.SubscribeRequest decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeRequestProto.SubscribeRequest.parseFrom(body);
    }

    private static SubscribeRequestProto.SubscribeRequest createSubscribeRequest() {
        SubscribeRequestProto.SubscribeRequest.Builder builder = SubscribeRequestProto.SubscribeRequest.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("test");
        builder.setProductName("Netty Book");

        List<String> address = new ArrayList<>();
        address.add("ShangHai");
        address.add("BeiJing");
        address.add("ShenZhen");
        builder.addAllAddress(address);

        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeRequestProto.SubscribeRequest request = createSubscribeRequest();
        System.out.println("before encode: " + request.toString());

        SubscribeRequestProto.SubscribeRequest decode = decode(encode(request));
        System.out.println("after decode: " + decode.toString());

        System.out.println("assert equals: --> " + decode.equals(request));
    }
}
