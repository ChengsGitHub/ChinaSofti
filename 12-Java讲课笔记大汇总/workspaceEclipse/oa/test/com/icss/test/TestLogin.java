package com.icss.test;



import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.emp1.dao.PermDaoImpl;



public class TestLogin {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private PermDaoImpl dao = (PermDaoImpl) context.getBean(PermDaoImpl.class);
	@Test
	public void testQuery() {
		List<Map<String, Object>> list = dao.qyeryPerm("zhangsan");
		System.out.println(list);
	}
	@Test
	public void testQueryRole() {
		List<Map<String, Object>> list = dao.qyeryRole("zhangsan");
		System.out.println(list);
	}
	
}
