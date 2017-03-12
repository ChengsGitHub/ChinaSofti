package com.icss.hr.job.service;

import java.util.List;

import com.icss.hr.job.po.Job;
import com.icss.hr.job.vo.JobVo;

public interface JobService {

	void add(JobVo vo);
	
	void delete(String jobId);
	
	void update(JobVo vo);
	
	List<Job> query();
	
	Job queryById(String jobId);
		
}