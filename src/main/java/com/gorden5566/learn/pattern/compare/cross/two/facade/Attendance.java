package com.gorden5566.learn.pattern.compare.cross.two.facade;

import java.util.Random;

/**
 * @author gorden5566
 * @date 2019-02-15
 */
public class Attendance {
    /**
     * 得到出勤天数
     *
     * @return
     */
    public int getWorkDays(){
        return (new Random()).nextInt(30);
    }
}
