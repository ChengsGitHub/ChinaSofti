package com.icss.test;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

public class TestEmpDao {

	private EmpDaoImpl dao = new EmpDaoImpl();

	@Test
	public void testInsert() throws Exception {

		Job job = new Job();
		job.setJobId("FWY");

		Dept dept = new Dept();
		dept.setDeptId(11);

		Emp emp = new Emp("tom", "tom@163.com", "84755556", Date
				.valueOf("2005-6-9"), job, 2400, dept);
		
		dao.insert(emp);
	}
	
	@Test
	public void testInsertMany() throws Exception {

		Job job = new Job();
		job.setJobId("FWY");

		Dept dept = new Dept();
		dept.setDeptId(11);

		for (int i = 1;i <= 20 ;i ++) {
			Emp emp = new Emp("jack"+i, "jack@163.com", "83632826", Date
					.valueOf("2005-6-9"), job, 3600, dept);
			
			dao.insert(emp);
		}
		
		
	}
	

	@Test
	public void testUpdate() throws Exception {

		Job job = new Job();
		job.setJobId("JDY");

		Dept dept = new Dept();
		dept.setDeptId(12);

		Emp emp = new Emp(5,"½Ü¿Ë", "½Ó¿¨@163.com", "1111", Date
				.valueOf("2001-1-1"), job, 2111, dept);
		
		dao.update(emp);
	}
	
	@Test
	public void testDelete() throws Exception {
		
		dao.delete(8);
	}

	@Test
	public void testGetCount() throws Exception {		
		int count = dao.getCount();		
		System.out.println(count);
		Assert.assertEquals(20, count);
	}
	
	@Test
	public void testQueryById() throws Exception {

		Emp emp = dao.queryById(5);		
		System.out.println(emp);
		System.out.println(emp.getJob().getJobId());
		System.out.println(emp.getDept().getDeptId());
	}
	
	@Test
	public void testQuery() throws Exception {

		Pager pager = new Pager(dao.getCount(),-5);
		ArrayList<Emp> list = dao.query(pager);
		
		for (Emp e : list) {
			System.out.println(e);
			System.out.println(e.getDept().getDeptName());
			System.out.println(e.getJob().getJobName());
		}
	
	}
}
