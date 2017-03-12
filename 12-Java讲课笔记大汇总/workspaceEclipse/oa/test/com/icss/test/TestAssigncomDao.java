package com.icss.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.dao.AssigncomDao;
import com.icss.oa.assign.pojo.Assigncom;

public class TestAssigncomDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private AssigncomDao dao = (AssigncomDao) context.getBean(AssigncomDao.class);
	
	@Test
	public void testInsert() throws IOException {
		for(int i=0;i<=15;i++)
		{
			Assigncom assigncom = new Assigncom("IBM��˾","���� 13213121562","java����ʦ�����ݿ������","�����ߣ�����ʦ�����Ա",20000,"�����õ�");
			dao.insert(assigncom); 
		}
	}
	
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(),2);
		List<Assigncom> list = dao.query(pager);
		for (Assigncom assigncom : list) {
			System.out.println(assigncom.getAssigncomName());
		}
	}
}