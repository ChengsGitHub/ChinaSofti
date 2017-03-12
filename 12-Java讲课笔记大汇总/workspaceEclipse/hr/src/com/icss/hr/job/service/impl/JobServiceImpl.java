package com.icss.hr.job.service.impl;

import java.util.ArrayList;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.JobVo;

public class JobServiceImpl implements JobService {

	private JobDao dao = new JobDaoImpl();

	@Override
	public void insert(JobVo vo) throws Exception {
		Job job = new Job(vo.getJobId(),vo.getJobName(),vo.getJobMinSalary(),vo.getJobMaxSalary());
		dao.insert(job);
	}

	@Override
	public void update(JobVo vo) throws Exception {
		Job job = new Job(vo.getJobId(),vo.getJobName(),vo.getJobMinSalary(),vo.getJobMaxSalary());
		dao.update(job);
	}

	@Override
	public void delete(String jobId) throws Exception {
		dao.delete(jobId);
	}

	@Override
	public Job queryById(String jobId) throws Exception {

		return dao.queryById(jobId);
	}

	@Override
	public ArrayList<Job> query() throws Exception {

		return dao.query();
	}

}