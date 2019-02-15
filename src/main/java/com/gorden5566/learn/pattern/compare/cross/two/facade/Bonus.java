package com.gorden5566.learn.pattern.compare.cross.two.facade;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Bonus {
    private Attendance attendance = new Attendance();

    public int getBonus() {
        //获得出勤情况
        int workDays = attendance.getWorkDays();

        //奖金计算模型
        int bonus = workDays * 1800 / 30;
        return bonus;
    }
}
