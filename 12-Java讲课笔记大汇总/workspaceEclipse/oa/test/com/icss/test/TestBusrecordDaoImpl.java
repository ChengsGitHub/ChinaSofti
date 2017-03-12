package com.icss.test;


import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.bus.dao.BusrecordDao;
import com.icss.oa.bus.pojo.Busrecord;
import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Emp;






public class TestBusrecordDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private BusrecordDao dao = (BusrecordDao) context.getBean(BusrecordDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Busrecord busrecord = new Busrecord("李四","吕布","接机","公司-机场",Timestamp.valueOf("2010-5-6 12:00:00"),Timestamp.valueOf("2010-5-6 15:00:00"));
		dao.insert(busrecord);		
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 5;i ++) {
			Busrecord busrecord = new Busrecord("李四"+i,"吕布","接机","公司-机场",Timestamp.valueOf("2010-5-6 12:00:00"),Timestamp.valueOf("2010-5-6 15:00:00"));
		dao.insert(busrecord);
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Busrecord busrecord = new Busrecord (1,"张三","李四","接机","火车站-机场",Timestamp.valueOf("2010-5-6 12:00:00"),Timestamp.valueOf("2010-5-6 15:00:00"));
		dao.update( busrecord);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(6);
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(),2);
		List<Busrecord> list = dao.query(pager);
		for (Busrecord busrecord : list) {
			System.out.println(busrecord);
		}
	}
	
	@Test
	public void testQueryById() throws Exception {
		Busrecord busrecord = dao.queryById(24);
		System.out.println(busrecord);
	}
}