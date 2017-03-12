package com.icss.test;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.pojo.Job;

public class TestJobDao {
	
	private JobDaoImpl dao = new JobDaoImpl();
	
	@Test
	public void testInsert() throws Exception {		
		Job job = new Job("JDY","接待员",2400,3600);
		dao.insert(job);		
	}
	
	@Test
	public void testUpdate() throws Exception {		
		Job job = new Job("JDY","接待员",2500,3700);
		dao.update(job);		
	}
	

	@Test
	public void testDelete() throws Exception {		
		dao.delete("FWY");
	}
	
	@Test
	public void testQueryById() throws Exception {		
		Job job = dao.queryById("JDY");
		System.out.println(job);	
	}
	

	@Test
	public void testQuery() throws Exception {		
		ArrayList<Job> list = dao.query();
		for (Job job : list) {
			System.out.println(job);
		}
	}

}
