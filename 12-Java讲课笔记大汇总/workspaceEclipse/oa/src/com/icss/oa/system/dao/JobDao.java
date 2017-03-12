package com.icss.oa.system.dao;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Job;

public interface JobDao {
	public void insert(Job job);
	public void update(Job job) ;
	public void delete(Integer jobId);
	public Job queryById(Integer jobId);
	public List<Job> query(Pager pager);
	public int getCount();
}
