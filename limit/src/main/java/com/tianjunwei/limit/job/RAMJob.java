package com.tianjunwei.limit.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/12/2 7:53 下午
 * @ClassName com.tianjunwei.limit.job
 */
public class RAMJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        System.err.println("Say hello to Quartz " + System.currentTimeMillis());
    }

}
