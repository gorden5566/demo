package com.gorden5566.learn.pattern.compare.cross.one.strategy;

import com.gorden5566.learn.pattern.compare.cross.one.strategy.strategy.HtmlMail;
import com.gorden5566.learn.pattern.compare.cross.one.strategy.strategy.MailTemplate;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //创建一封TEXT格式的邮件
        MailTemplate template = new HtmlMail("a@a.com","b@b.com","外星人攻击地球了","结局是外星人被地球人打败了！");
        //创建一个Mail发送程序
        MailServer mail = new MailServer(template);
        //发送邮件
        mail.sendMail();
    }
}
