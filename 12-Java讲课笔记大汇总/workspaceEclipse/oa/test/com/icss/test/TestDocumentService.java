package com.icss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.folder.pojo.Document;
import com.icss.oa.folder.pojo.Folder;
import com.icss.oa.folder.service.DocumentServiceImpl;

public class TestDocumentService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private DocumentServiceImpl service = (DocumentServiceImpl) context.getBean(DocumentServiceImpl.class);
	@Test
	public void testInsert() {
		for(int i=10;i<13;i++){
			Document document = new Document("javaѧϰ",5,1,empty_blob());
			service.insert(document);
		}
	}	
	
	private byte[] empty_blob() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testDelete() {
		
		service.deleteByDocumentId(5);
	}
	
	@Test
	public void testQueryByFolderId() {
		List<Document> list = service.queryByFolderId(5);
		for (Document document : list) {
			System.out.println(document);
		}
	}

	@Test
	public void testQueryByDocumentId() {
		Document document = service.queryById(8);
		
			System.out.println(document);
		
	}
	
}
