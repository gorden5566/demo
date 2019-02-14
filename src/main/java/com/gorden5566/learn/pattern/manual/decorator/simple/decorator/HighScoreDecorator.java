package com.gorden5566.learn.pattern.manual.decorator.simple.decorator;

import com.gorden5566.learn.pattern.manual.decorator.simple.report.SchoolReport;

public class HighScoreDecorator extends Decorator {
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    private void reportHighScore() {
        System.out.println("这次考试语文最高是75， 数学是78， 自然是80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
