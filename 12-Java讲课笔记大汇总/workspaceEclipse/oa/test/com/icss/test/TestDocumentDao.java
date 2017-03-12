package com.icss.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.folder.dao.DocumentDaoImpl;
import com.icss.oa.folder.dao.FolderDaoImpl;
import com.icss.oa.folder.pojo.Document;

public class TestDocumentDao {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private DocumentDaoImpl dao = (DocumentDaoImpl) context.getBean(DocumentDaoImpl.class);
	
	@Test
	public void testInsert() {
		
		Document document = new Document("javaѧϰ",5,1,empty_blob());
		dao.insert(document);
		}

	private byte[] empty_blob() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void testQueryById() {
		Document document = dao.queryById(8);
		System.out.println(document);
	}
	@Test
	public void testQueryByFolderId() {
		List<Document> document = dao.queryByFolderId(1);
		System.out.println(document);
	}
	
	@Test
	public void delete() {
		dao.deleteByDocumentId(5);
	}

}
