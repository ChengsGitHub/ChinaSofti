package com.icss.test;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.folder.dao.FolderDaoImpl;
import com.icss.oa.folder.pojo.Folder;


public class TestFolder {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private FolderDaoImpl dao = (FolderDaoImpl) context.getBean(FolderDaoImpl.class);
	
	@Test
	public void testInsert() {
		for(int i=15;i<17;i++){
		Folder folder = new Folder("数据库"+i,1,1,0);
		dao.insert(folder);
		}
	}	
	
	@Test
	public void testUpdate() {
		Folder folder = new Folder(4,"高数");
		dao.update(folder);
	}
	
	
	@Test
	public void testDelete() {
		
		dao.delete(2);
	}
	
	@Test
	public void testQueryByEmpId() {
		List<Folder> list = dao.queryByEmpId(1);
		for (Folder folder : list) {
			System.out.println(folder);
		}
	}
}