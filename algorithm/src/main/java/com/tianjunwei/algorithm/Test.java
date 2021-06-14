package com.tianjunwei.algorithm;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/3/25 3:48 下午
 * @ClassName com.tianjunwei.algorithm
 */
public class Test {

    public static long dayDiff(Date d1, Date d2) {

        return (d1.getTime() - d2.getTime()) / 86400000L;
    }

    public static void main(String [] args) {
        Date startTime = new Date();

        Date endTime = new Date(System.currentTimeMillis() + 86400000L *3 );

        System.err.println(dayDiff(endTime,startTime));

    }

}
