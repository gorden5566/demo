package com.gorden5566.learn.pattern.compare.cross.two.colleague.media;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.AbsMediator;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.IPosition;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.ISalary;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.ITax;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Mediator extends AbsMediator {
    @Override
    public void up(ISalary salary) {
        upSalary();
        upTax();
    }

    @Override
    public void up(IPosition position) {
        upPosition();
        upSalary();
        upTax();
    }

    @Override
    public void up(ITax tax) {
        upTax();
        downSalary();
    }

    @Override
    public void down(ISalary salary) {
        downSalary();
        downTax();
    }

    @Override
    public void down(IPosition position) {
        downPosition();
        downSalary();
        downTax();
    }

    @Override
    public void down(ITax tax) {
        downTax();
        downSalary();
    }

    private void upSalary() {
        System.out.println("工资翻倍，乐翻天");
    }

    private void upTax() {
        System.out.println("税收上升，为国家做贡献");
    }

    private void upPosition() {
        System.out.println("职位上升一级，狂喜");
    }

    private void downSalary() {
        System.out.println("经济不景气，降低工资");
    }

    private void downTax() {
        System.out.println("税收减低，国家收入减少");
    }

    private void downPosition() {
        System.out.println("官降三级，比自杀还痛苦");
    }
}
