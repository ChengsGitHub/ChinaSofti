package com.icss.test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.dao.ExphistoryDao;
import com.icss.oa.assign.pojo.Exphistory;

public class TestExphistoryDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ExphistoryDao dao = (ExphistoryDao) context.getBean(ExphistoryDao.class);
	
	@Test
	public void testInsert() throws IOException {	
			//Exphistory exphistory = new Exphistory(1,33,"正在被派遣","大连中软",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),20000,"这家伙很懒，每天想着领工资");
			Exphistory exphistory1 = new Exphistory(1,2,"正在被派遣","IBM",Date.valueOf("2007-5-6"),Date.valueOf("2010-5-5"),20000,"这家伙很懒，每天想着领工资");
			
			Exphistory exphistory2 = new Exphistory(1,2,"正在被派遣","大连中软",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),20000,"这家伙每天想着领工资");
			Exphistory exphistory3 = new Exphistory(1,2,"正在被派遣","IBM",Date.valueOf("2007-5-6"),Date.valueOf("2010-5-5"),20000,"这家伙每天想着领工资");
			//dao.insert(exphistory);
			dao.insert(exphistory1); 
			dao.insert(exphistory2); 
			dao.insert(exphistory3); 
	}
	

	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
		
	@Test
	public void testQuery2() {
		
		List<Exphistory> list = dao.query(1);
		for (Exphistory exphistory : list) {
			System.out.println(exphistory);
		}
	}
}