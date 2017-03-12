package com.icss.oa.folder.service;

import java.util.List;

import com.icss.oa.folder.pojo.Document;

public interface DocumentService {
	public void insert(Document document);
	public List<Document> queryByFolderId(Integer folderId);
	public Document queryById(Integer documentId);
	public void deleteByDocumentId(Integer documentId);
}
