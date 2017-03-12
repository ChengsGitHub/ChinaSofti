package com.icss.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.dao.ExpinfDao;
import com.icss.oa.assign.pojo.Expinf;

public class TestExpinfDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ExpinfDao dao = (ExpinfDao) context.getBean(ExpinfDao.class);
	
//	@Test
//	public void testInsert() throws IOException {
//		for(int i=0;i<=15;i++)
//		{
//			File file = new File("C:\Users\Lenovo\Desktop\001.jpg");
//			byte[] bytes = FileCopyUtils.copyToByteArray(file);
//			Expinf expinf = new Expinf("李四","大学本科","擅长java和数据库","在中软就职","大连",20000,bytes);
//			dao.insert(expinf); 
//		}
//	}
	@Test
	public void testInsert() throws IOException {
		for(int i=0;i<=15;i++)
		{
			Expinf expinf = new Expinf("李四","大学本科","擅长java和数据库","在中软就职","大连",20000,empty_blob());
			dao.insert(expinf); 
		}
	}
	private byte[] empty_blob() {
		// TODO Auto-generated method stub
		return null;
	}
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(),2);
		List<Expinf> list = dao.query(pager);
		for (Expinf expinf : list) {
			System.out.println(expinf);
		}
	}
	
	@Test
	public void testDownload() {
		Expinf expinf = dao.download(81);
		System.out.println(expinf);
	}
}