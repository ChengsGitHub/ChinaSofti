package com.icss.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.dao.Emp1Dao;
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;

public class TestEmp1 {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private Emp1Dao dao1 = (Emp1Dao) context.getBean(Emp1Dao.class);
	private Emp1Service service = (Emp1Service) context.getBean(Emp1Service.class);
	
	//Emp1ServiceImpl service =new Emp1ServiceImpl();
	@Test
	public void testQueryByName() {
		List<Emp1> list = dao1.queryByName("李四");
		System.out.println(list);
	}
	
	
	@Test
	public void testQueryByOther() {
		List<Map<String, Object>> list = dao1.queryByOther("李四",null,1);
		for (Map map : list) {
			System.out.println(map);
		}
			
	}
	
	
	
	@Test
	public void testQueryByOtherService() {

		List<Map<String, Object>> list=service.queryByOther("李四",2,3);
		System.out.println(list);
	}
	
	
	@Test
	public void testQueryBy() {
		List<Emp1> list = service.queryByName("李四");
		System.out.println(list);
	}
	
	
	
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao1.getCount(), 1);
		List<Emp1> list = dao1.query(pager);
		for (Emp1 emp1 : list) {
			System.out.println(emp1);
		}
	}
	

	@Test
	public void testQueryById() {
		Emp1 emp1 = dao1.queryById(6);
		System.out.println(emp1);
	}
	
	
}
