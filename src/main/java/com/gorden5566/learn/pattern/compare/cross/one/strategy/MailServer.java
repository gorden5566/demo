package com.gorden5566.learn.pattern.compare.cross.one.strategy;

import com.gorden5566.learn.pattern.compare.cross.one.strategy.strategy.MailTemplate;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class MailServer {
    private MailTemplate mail;

    public MailServer(MailTemplate mail) {
        this.mail = mail;
    }

    public void sendMail() {
        System.out.println("====正在发送的邮件信息====");
        //发件人
        System.out.println("发件人：" + mail.getFrom());
        //收件人
        System.out.println("收件人：" + mail.getTo());
        //标题
        System.out.println("邮件标题：" + mail.getSubject());
        //邮件内容
        System.out.println("邮件内容：" + mail.getContext());
    }
}
