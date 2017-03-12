package com.icss.oa.folder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.icss.oa.folder.pojo.Document;


@Repository
public class DocumentDaoImpl implements DocumentDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Document document) {
		SqlSession session = factory.openSession();
		session.insert("DOCUMENT.insert", document);		
	}
	
	public List<Document> queryByFolderId(Integer folderId) {
		SqlSession session = factory.openSession();
		List<Document> list = session.selectList("DOCUMENT.queryByFolderId", folderId);		
		return list;
	}
	
	public Document queryById(Integer documentId) {
		SqlSession session = factory.openSession();
		Document document = session.selectOne("DOCUMENT.queryById", documentId);		
		return document;
	}
	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("DOCUMENT.getCount");
		return count;
	}
	public void deleteByDocumentId(Integer documentId) {
		SqlSession session = factory.openSession();
		session.delete("DOCUMENT.deleteByDocumentId", documentId);
	}
	
}