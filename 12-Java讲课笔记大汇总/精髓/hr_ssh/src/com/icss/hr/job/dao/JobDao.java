package com.icss.hr.job.dao;

import java.util.List;

import com.icss.hr.job.po.Job;

/**
 * 职务DAO接口
 * @author Administrator
 *
 */
public interface JobDao {
	
	void add(Job job);
	
	void update(Job job) ;
	
	void delete(String jobId) ;
	
	Job queryById(String jobId);
	
	List<Job> query();

}