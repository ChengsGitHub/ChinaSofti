package com.icss.test;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.job.po.Job;

public class TestEmpDao {
	
	private EmpDaoImpl dao = new EmpDaoImpl();
	
	@Test
	public void testInsert() throws Exception {
		
		Job job = new Job();
		job.setJobId("FWY");

		Dept dept = new Dept();
		dept.setDeptId(20);

		Emp emp = new Emp("张三", "zhang@163.com", "10086",
				Date.valueOf("2005-09-06"), job, 2400, dept);
		
		dao.insert(emp);		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		Job job = new Job();
		job.setJobId("FWY");

		Dept dept = new Dept();
		dept.setDeptId(20);

		Emp emp = new Emp(9,"张三999", "zhang999@163.com", "999",
				Date.valueOf("2005-09-09"), job, 9999, dept);
		
		dao.update(emp);	
	}
	
	@Test
	public void testDelete() throws Exception {
				
		dao.delete(41);	
	}
	

	@Test
	public void testQueryById() throws Exception {
	
		Emp emp = dao.queryById(9);
		System.out.println(emp);
	
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 20;i ++) {
		
			Job job = new Job();
			job.setJobId("FWY");
	
			Dept dept = new Dept();
			dept.setDeptId(20);
	
			Emp emp = new Emp("李四" + i, "zhang@163.com", "10086",
					Date.valueOf("2005-09-06"), job, 2400, dept);
			
			dao.insert(emp);		
		}
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount();
		System.out.println(count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(),1);
		ArrayList<Emp> list = dao.query(pager);
		for (Emp e : list) {
			System.out.println(e);
		}
	}

}