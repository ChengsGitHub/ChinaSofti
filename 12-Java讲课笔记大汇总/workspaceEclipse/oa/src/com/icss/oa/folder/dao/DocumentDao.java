package com.icss.oa.folder.dao;

import java.util.List;

import com.icss.oa.folder.pojo.Document;

public interface DocumentDao {
	public void insert(Document document) ;
	public List<Document> queryByFolderId(Integer folderId) ;
	public Document queryById(Integer documentId);
	public int getCount() ;
	public void deleteByDocumentId(Integer documentId);
}
