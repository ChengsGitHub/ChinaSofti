package com.icss.hr.job.dao;

import java.util.ArrayList;

import com.icss.hr.job.po.Job;

public interface JobDao {

	void insert(Job job) throws Exception;

	void update(Job job) throws Exception;

	void delete(String jobId) throws Exception;

	Job queryById(String jobId) throws Exception;

	ArrayList<Job> query() throws Exception;

}