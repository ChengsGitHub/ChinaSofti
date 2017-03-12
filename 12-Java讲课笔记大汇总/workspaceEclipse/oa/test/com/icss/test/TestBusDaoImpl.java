package com.icss.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.bus.dao.BusDao;
import com.icss.oa.bus.pojo.Bus;
import com.icss.oa.common.Pager;





public class TestBusDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private BusDao dao = (BusDao) context.getBean(BusDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Bus bus = new Bus("°ÂµÏ","ÁÉA12345",1,empty_blob());
		dao.insert(bus);		
	}
	
	private byte[] empty_blob() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Test
	public void testUpdate() throws Exception {
		Bus bus = new Bus(1,"°ÂµÏ","ÁÉA12345",1,empty_blob());
		dao.update(bus);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(),2);
		List<Bus> list = dao.query(pager);
		for (Bus bus : list) {
			System.out.println(bus);
		}
	}
}