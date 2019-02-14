package com.gorden5566.learn.pattern.compare.cross.one.strategy.strategy;

/**
 * @author gorden5566
 * @date 2019-02-14
 */
public abstract class MailTemplate {
    /**
     * 邮件发件人
     */
    private String from;

    /**
     * 收件人
     */
    private String to;

    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String context;

    public MailTemplate(String from, String to, String subject, String context) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.context = context;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
