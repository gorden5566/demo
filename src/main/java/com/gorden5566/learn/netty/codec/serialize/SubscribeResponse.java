package com.gorden5566.learn.netty.codec.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gorden5566
 * @date 2019/07/21
 */
@Data
public class SubscribeResponse implements Serializable {
    private static final long serialVersionUID = 1769018754389376836L;

    private int subReqId;
    private int respCode;
    private String desc;
}
