package com.gorden5566.learn.pattern.manual.facade.simple;

public class ModernPostOffice {

    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police police = new Police();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);

        police.checkLetter(letterProcess);

        letterProcess.letterInToEnvelope();
        letterProcess.sendLetter();
    }
}
