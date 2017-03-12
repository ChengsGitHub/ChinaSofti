package com.icss.oa.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.dao.JobDaoImpl;
import com.icss.oa.system.pojo.Job;

@Service
@Transactional(rollbackFor = Exception.class)
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao dao;

	public void insert(Job job) {
		dao.insert(job);
	}

	public void update(Job job) {
		dao.update(job);
	}

	public void delete(Integer jobId) {
		dao.delete(jobId);
	}

	public Job queryById(Integer jobId) {

		return dao.queryById(jobId);
	}

	public List<Job> query(Pager pager) {

		return dao.query(pager);
	}

	public int getCount() {

		return dao.getCount();
	}

}