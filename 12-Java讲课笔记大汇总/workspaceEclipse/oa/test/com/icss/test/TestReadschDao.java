package com.icss.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.work.dao.ReadschDao;
import com.icss.oa.work.pojo.Readsch;

public class TestReadschDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ReadschDao dao = (ReadschDao) context.getBean(ReadschDao.class);
	
	@Test
	public void testInsert() throws IOException {
			Readsch readsch = new Readsch(2,0,4,8);
			dao.insert(readsch); 
	}
	
	@Test
	public void testGetCount() {
		int count = dao.getCount(1);
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(1),2);
		List<Map> list = dao.query(pager,1);
		for (Map readsch : list) {
			System.out.println(readsch);
		}
	}
	
	@Test
	public void testQuery2() {
		Pager pager = new Pager(dao.getCount(1),1);
		List<Map> list = dao.query2(pager,1);
		for (Map readsch : list) {
			System.out.println(readsch);
		}
	}
}