package com.icss.hr.job.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.po.Job;

public class JobDaoImpl implements JobDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Job job) {
		Session session = sessionFactory.getCurrentSession();		
		session.save(job);	
	}

	@Override
	public void update(Job job) {
		Session session = sessionFactory.getCurrentSession();	
		session.update(job);
	}

	@Override
	public void delete(String jobId) {
		Session session = sessionFactory.getCurrentSession();	
		Job job = (Job) session.get(Job.class, jobId);
		session.delete(job);
	}

	@Override
	public Job queryById(String jobId) {
		Session session = sessionFactory.getCurrentSession();	
		Job job = (Job) session.get(Job.class, jobId);
		return job;
	}

	@Override
	public List<Job> query() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Job j";
		Query query = session.createQuery(hql);
		List<Job> list = query.list();

		return list;
	}

}