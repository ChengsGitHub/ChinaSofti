package com.icss.test;


import java.util.ArrayList;

import org.junit.Test;




import com.icss.hr.job.dao.impl.JobDaoImpl;
import com.icss.hr.job.po.Job;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestJobDao {
	
	private JobDaoImpl dao =new JobDaoImpl();
	
	@Test
	public void testInsert() throws Exception{
		Job job = new Job("FWY","服务员",3000,8000);
		dao.insert(job);		
	}
		
	@Test
	public void testUpdate() throws Exception{
		Job job = new Job("JL","总经理",3000,3500);
		dao.update(job);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete("JL");		
	}
	
	@Test
	public void testQueryById() throws Exception{
		Job job = dao.queryById("FWY");
		System.out.println(job);		
	}
	
	@Test
	public void testQuery() throws Exception{
		ArrayList<Job> list = dao.query();
		for (Job d : list) {
			System.out.println(d);
		}
	}
	

}
