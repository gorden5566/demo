package com.gorden5566.learn.pattern.manual.decorator.simple.decorator;

import com.gorden5566.learn.pattern.manual.decorator.simple.report.SchoolReport;

public class Decorator extends SchoolReport {
    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    public void report() {
        this.schoolReport.report();
    }

    @Override
    public void sign(String name) {
        this.schoolReport.sign(name);
    }
}
