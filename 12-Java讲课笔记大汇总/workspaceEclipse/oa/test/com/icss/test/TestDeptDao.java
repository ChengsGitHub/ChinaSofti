package com.icss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.DeptDao;
import com.icss.oa.system.dao.DeptDaoImpl;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.service.DeptService;

public class TestDeptDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private DeptDao dao = (DeptDao) context.getBean(DeptDao.class);
	private DeptService service=(DeptService) context.getBean(DeptService.class);
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	@Test
	public void testInsert() {
		Dept dept=new Dept("www","www");
		service.insert(dept);
	}
	
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(),2);
		List<Dept> list = dao.query(pager);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}
}