package com.icss.oa.system.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Job;

@Repository
public class JobDaoImpl implements JobDao{

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Job job)  {
		SqlSession session = factory.openSession();
		session.insert("JOB.insert", job);
	}

	public void update(Job job) {
		SqlSession session = factory.openSession();
		session.update("JOB.update", job);
	}

	public void delete(Integer jobId) {
		SqlSession session = factory.openSession();
		session.delete("JOB.delete", jobId);		
	}

	public Job queryById(Integer jobId) {
		SqlSession session = factory.openSession();
		Job job = session.selectOne("JOB.queryById", jobId);
		return job;
	}

	public List<Job> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Job> list = session.selectList("JOB.query", map);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("JOB.getCount");
		return count;
	}
}