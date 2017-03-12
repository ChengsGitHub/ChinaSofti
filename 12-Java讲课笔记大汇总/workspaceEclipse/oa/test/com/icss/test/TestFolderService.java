package com.icss.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.folder.dao.FolderDaoImpl;
import com.icss.oa.folder.pojo.Folder;
import com.icss.oa.folder.service.FolderServiceImpl;

public class TestFolderService {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private FolderServiceImpl service = (FolderServiceImpl) context.getBean(FolderServiceImpl.class);
	
	@Test
	public void testInsert() {
		for(int i=10;i<13;i++){
			Folder folder = new Folder("Êý¾Ý¿â"+i,1,2,1);
			service.insert(folder);
		}
	}	
	
	@Test
	public void testUpdate() {
		Folder folder = new Folder(22,"java");
		service.update(folder);
	}
	
	@Test
	public void testUpdateSharing() {
		Folder folder = new Folder(22,1);
		service.updateSharing(folder);
	}
	
	
	@Test
	public void testDelete() {
		
		service.delete(3);
	}
	
	@Test
	public void testQueryByEmpId() {
		List<Folder> list = service.queryByEmpId(2);
		for (Folder folder : list) {
			System.out.println(folder);
		}
	}
	@Test
	public void testQueryBySharing() {
		List<Folder> list = service.queryBySharing(3);
		for (Folder folder : list) {
			System.out.println(folder);
		}
	}
}
