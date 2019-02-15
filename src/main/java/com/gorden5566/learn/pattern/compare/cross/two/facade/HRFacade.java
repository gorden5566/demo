package com.gorden5566.learn.pattern.compare.cross.two.facade;

import java.util.Date;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class HRFacade {
    /**
     * 总工资情况
     */
    private SalaryProvider salaryProvider = new SalaryProvider();

    /**
     * 考勤情况
     */
    private Attendance attendance = new Attendance();

    /**
     * 查询一个人的总收入
     *
     * @param name
     * @param date
     * @return
     */
    public int querySalary(String name, Date date) {
        return salaryProvider.totalSalary();
    }

    /**
     * 查询一个员工一个月工作了多少天
     *
     * @param name
     * @return
     */
    public int queryWorkDays(String name) {
        return attendance.getWorkDays();
    }
}
