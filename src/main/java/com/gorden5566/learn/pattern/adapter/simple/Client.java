package com.gorden5566.learn.pattern.adapter.simple;

import com.gorden5566.learn.pattern.adapter.simple.origin.IUserInfo;

public class Client {
    public static void main(String[] args) {
        IUserInfo youngGirl = new OuterUserInfo();

        for (int i = 0; i <= 10; i++) {
            System.out.println(youngGirl.getMobileNumber());
        }
    }
}
