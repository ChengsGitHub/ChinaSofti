package com.icss.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.dao.OffsupDao;
import com.icss.oa.asserts.pojo.Offsup;

public class TestOffsupDao {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private OffsupDao dao = (OffsupDao) context.getBean(OffsupDao.class);
	
	@Test
	public void testGetCount() {
		int count = dao.getContentCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getContentCount(),2);
		List<Offsup> list = dao.query(pager);
		for (Offsup offsup : list) {
			System.out.println(offsup);
		}
	}
//	@Test
//	public void testInsert(){
//		for (int i = 70;i <=100 ;i ++) {
//		Offsup offsup = new Offsup("µçÄÔ" + i,"±Ê¼Ç±¾", "123456", 2000,100,20);
//			dao.insert(offsup);
//		}
//	}
}
