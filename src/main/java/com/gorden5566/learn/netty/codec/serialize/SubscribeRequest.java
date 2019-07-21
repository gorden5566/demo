package com.gorden5566.learn.netty.codec.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gorden5566
 * @date 2019/07/21
 */
@Data
public class SubscribeRequest implements Serializable {
    private static final long serialVersionUID = 6818416184579438028L;

    private int subReqId;
    private String userName;
    private String productName;
    private String phoneNumber;
    private String address;
}
