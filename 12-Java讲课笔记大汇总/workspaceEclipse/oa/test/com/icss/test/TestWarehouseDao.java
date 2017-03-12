package com.icss.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.dao.OffsupDao;
import com.icss.oa.asserts.dao.WarehouseDao;
import com.icss.oa.asserts.pojo.Offsup;
import com.icss.oa.asserts.pojo.Warehouse;

public class TestWarehouseDao {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private WarehouseDao dao = (WarehouseDao) context.getBean(WarehouseDao.class);
	
	@Test
	public void testGetCount() {
		int count = dao.getContentCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getContentCount(),2);
		List<Warehouse> list = dao.query(pager);
		for (Warehouse warehouse : list) {
			System.out.println(warehouse);
		}
	}
	@Test
	public void testInsert(){
		for (int i = 70;i <=100 ;i ++) {
			Warehouse warehouse = new Warehouse("µçÄÔ" + i,"±Ê¼Ç±¾", 11);
			dao.insert(warehouse);
		}
	}
}
