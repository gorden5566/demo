package com.gorden5566.learn.pattern.facade.simple;

public class ModernPostOffice {

    private ILetterProcess letterProcess = new LetterProcessImpl();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        letterProcess.letterInToEnvelope();
        letterProcess.sendLetter();
    }
}
