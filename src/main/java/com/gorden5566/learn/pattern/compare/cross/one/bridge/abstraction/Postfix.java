package com.gorden5566.learn.pattern.compare.cross.one.bridge.abstraction;

import com.gorden5566.learn.pattern.compare.cross.one.bridge.implementor.MailTemplate;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Postfix extends MailServer {
    public Postfix(MailTemplate mail) {
        super(mail);
    }

    @Override
    public void sendMail() {
        //增加邮件服务器信息
        String context ="Received: from XXXX (unknown [xxx.xxx.xxx.xxx]) by aaa.aaa.com (Postfix) with ESMTP id 8DBCD172B8\n" ;
        super.mail.add(context);
        super.sendMail();
    }
}
