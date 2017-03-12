package com.icss.hr.job.service;

import java.util.ArrayList;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.vo.JobVo;

public interface JobService {

	void insert(JobVo vo) throws Exception;

	void update(JobVo vo) throws Exception;

	void delete(String jobId) throws Exception;

	Job queryById(String jobId) throws Exception;

	ArrayList<Job> query() throws Exception;

}