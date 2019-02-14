package com.gorden5566.learn.pattern.manual.facade.simple;

public class Client {
    public static void main(String[] args) {
        String context = "Hello,It's me,do you know who I am? I'm your old love. I'd like to...";
        String address = "Happy Road No. 666,God Province,Heaven";

        ModernPostOffice postOffice = new ModernPostOffice();
        postOffice.sendLetter(context, address);
    }
}
