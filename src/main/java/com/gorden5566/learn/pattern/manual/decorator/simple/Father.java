package com.gorden5566.learn.pattern.manual.decorator.simple;

import com.gorden5566.learn.pattern.manual.decorator.simple.decorator.HighScoreDecorator;
import com.gorden5566.learn.pattern.manual.decorator.simple.report.FourthGradeSchoolReport;
import com.gorden5566.learn.pattern.manual.decorator.simple.report.SchoolReport;

public class Father {
    public static void main(String[] args) {
        SchoolReport sr = new FourthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
//        sr = new SortDecorator(sr);
        sr.report();
        sr.sign("老三");
    }
}
