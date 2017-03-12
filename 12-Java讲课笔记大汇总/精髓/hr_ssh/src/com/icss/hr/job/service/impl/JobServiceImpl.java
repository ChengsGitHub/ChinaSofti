package com.icss.hr.job.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.JobVo;

@Transactional(rollbackFor=Exception.class)
public class JobServiceImpl implements JobService {

	private JobDao dao;

	public void setDao(JobDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(JobVo vo) {

		Job job = new Job(vo.getJobId(), vo.getJobName(), vo.getJobMinSalary(),
				vo.getJobMaxSalary());

		dao.add(job);
	}

	@Override
	public void delete(String jobId) {

		dao.delete(jobId);
	}

	@Override
	public void update(JobVo vo) {

		Job job = new Job(vo.getJobId(), vo.getJobName(), vo.getJobMinSalary(),
				vo.getJobMaxSalary());

		dao.update(job);

	}

	@Transactional(readOnly=true)
	public List<Job> query() {

		List<Job> list = dao.query();

		return list;
	}

	@Transactional(readOnly=true)
	public Job queryById(String jobId) {

		Job job = dao.queryById(jobId);

		return job;
	}

}
