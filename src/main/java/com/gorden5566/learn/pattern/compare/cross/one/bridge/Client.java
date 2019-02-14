package com.gorden5566.learn.pattern.compare.cross.one.bridge;

import com.gorden5566.learn.pattern.compare.cross.one.bridge.abstraction.MailServer;
import com.gorden5566.learn.pattern.compare.cross.one.bridge.abstraction.Postfix;
import com.gorden5566.learn.pattern.compare.cross.one.bridge.implementor.HtmlMail;
import com.gorden5566.learn.pattern.compare.cross.one.bridge.implementor.MailTemplate;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public class Client {
    public static void main(String[] args) {
        //创建一封TEXT格式的邮件
        MailTemplate template = new HtmlMail("a@a.com", "b@b.com", "外星人攻击地球了", " 结局是外星人被地球人打败了！");
        //使用Postfix发送邮件
        MailServer mail = new Postfix(template);
        //发送邮件
        mail.sendMail();
    }
}
