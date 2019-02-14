package com.gorden5566.learn.pattern.compare.cross.one.bridge.abstraction;

import com.gorden5566.learn.pattern.compare.cross.one.bridge.abstraction.MailServer;
import com.gorden5566.learn.pattern.compare.cross.one.bridge.implementor.MailTemplate;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class SendMail extends MailServer {
    public SendMail(MailTemplate mail) {
        super(mail);
    }

    @Override
    public void sendMail() {
        //增加邮件服务器信息
        super.mail.add("Received: (sendmail); 7 Nov 2018 04:14:44 +0100");
        super.sendMail();
    }
}
