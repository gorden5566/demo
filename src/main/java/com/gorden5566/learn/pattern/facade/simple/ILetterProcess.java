package com.gorden5566.learn.pattern.facade.simple;

public interface ILetterProcess {
    /**
     * 首先要写信的内容
     *
     * @param context
     */
    void writeContext(String context);

    /**
     * 其次写信封
     *
     * @param address
     */
    void fillEnvelope(String address);

    /**
     * 把信放到信封里
     */
    void letterInoToEnvelope();

    /**
     * 然后邮递
     */
    void sendLetter();
}
