package com.icss.test;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.bus.dao.BusorderDao;
import com.icss.oa.bus.pojo.Busorder;
import com.icss.oa.common.Pager;






public class TestBusorderDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private BusorderDao dao = (BusorderDao) context.getBean(BusorderDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Busorder busorder = new Busorder(4,"°ÂµÏ",Timestamp.valueOf("2010-5-6 12:00:00"),"xxx",0);
		dao.insert(busorder);		
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 5;i ++) {
			Busorder busorder = new Busorder(4,"°ÂµÏ"+i,Timestamp.valueOf("2010-5-6 13:00:00"),"xxx"+i,0);
		dao.insert(busorder);
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Busorder busorder = new Busorder (21,4,"´óÖÚ",Timestamp.valueOf("2011-5-6 14:00:00"),"xxx",1);
		dao.update( busorder);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(21);
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount(2);
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(2),2);
		List<Map> list = dao.query(pager, 1);
		for (Map busorder : list) {
			System.out.println(busorder);
		}
	}
}