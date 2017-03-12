package com.icss.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmpDao;
import com.icss.oa.system.pojo.Emp;
import com.icss.oa.card.pojo.Personnelcard;

public class TestPerCardService {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private Personnelcard personnelcard = (Personnelcard) context.getBean(Personnelcard.class);
	/*
	@Test
	public void testQuery() {
		Pager pager = new Pager(personnelcard.getCount(), 1);
		List<Emp> list = personnelcard.query2(pager);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void testQuery2() {
		Pager pager = new Pager(personnelcard.getCount(), 1);
		List<Map<String,Object>> list = personnelcard.query2(pager);
		for (Map<String,Object> map : list) {
			System.out.println(map.get("EMP_NAME"));;
		}
	}*/
	
	
}
