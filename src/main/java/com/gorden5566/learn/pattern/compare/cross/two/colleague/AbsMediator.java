package com.gorden5566.learn.pattern.compare.cross.two.colleague;

import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Position;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Salary;
import com.gorden5566.learn.pattern.compare.cross.two.colleague.colleague.Tax;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public abstract class AbsMediator {
    /**
     * 工资
     */
    protected final ISalary salary;

    /**
     * 职位
     */
    protected final IPosition position;

    /**
     * 税收
     */
    protected final ITax tax;

    public AbsMediator() {
        this.salary = new Salary(this);
        this.position = new Position(this);
        this.tax = new Tax(this);
    }

    /**
     * 工资增加了
     *
     * @param salary
     */
    public abstract void up(ISalary salary);

    /**
     * 职位提升了
     *
     * @param position
     */
    public abstract void up(IPosition position);

    /**
     * 税收增加了
     *
     * @param tax
     */
    public abstract void up(ITax tax);

    /**
     * 工资降低了
     *
     * @param salary
     */
    public abstract void down(ISalary salary);

    /**
     * 职位降低了
     *
     * @param position
     */
    public abstract void down(IPosition position);

    /**
     * 税收降低了
     *
     * @param tax
     */
    public abstract void down(ITax tax);
}
