package com.student.job.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.student.job.base.BaseJob;

public class OnlineClearJob extends BaseJob{

	@Override
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {
		 System.out.println("hello");		
	}

}
