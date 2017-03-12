package com.icss.oa.folder.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.folder.dao.DocumentDao;
import com.icss.oa.folder.dao.DocumentDaoImpl;
import com.icss.oa.folder.pojo.Document;
@Service
@Transactional(rollbackFor = Exception.class)
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	private DocumentDao dao;

	public void insert(Document document) {
		dao.insert(document);
	}
	

	public List<Document> queryByFolderId(Integer folderId) {	
		return dao.queryByFolderId(folderId);
	}
	public Document queryById(Integer documentId) {
		Document document = dao.queryById(documentId);		
		return document;
	}
	
	public void deleteByDocumentId(Integer documentId) {
		dao.deleteByDocumentId(documentId);
	}
	
}