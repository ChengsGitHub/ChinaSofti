package com.icss.oa.folder.pojo;

import java.util.Arrays;

public class Document {
  
    private Integer documentId;

   
    private String documentName;

    private Integer folderId;

   
    private Integer documentSize;

  
    private byte[] documentData;

 
    public Integer getDocumentId() {
        return documentId;
    }

 
    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

  
    public Document() {
		super();
	}


	public Document(String documentName, Integer folderId, byte[] documentData) {
		super();
		this.documentName = documentName;
		this.folderId = folderId;
		this.documentData = documentData;
	}


	public Document(String documentName, Integer folderId,
			Integer documentSize, byte[] documentData) {
		super();
		this.documentName = documentName;
		this.folderId = folderId;
		this.documentSize = documentSize;
		this.documentData = documentData;
	}


	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName="
				+ documentName + ", folderId=" + folderId + ", documentSize="
				+ documentSize + ", documentData="
				+ Arrays.toString(documentData) + "]";
	}


	public Document(Integer documentId, String documentName, Integer folderId,
			Integer documentSize, byte[] documentData) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.folderId = folderId;
		this.documentSize = documentSize;
		this.documentData = documentData;
	}


	public String getDocumentName() {
        return documentName;
    }

 
    public void setDocumentName(String documentName) {
        this.documentName = documentName == null ? null : documentName.trim();
    }

   
    public Integer getFolderId() {
        return folderId;
    }

   
    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

   
    public Integer getDocumentSize() {
        return documentSize;
    }

  
    public void setDocumentSize(Integer documentSize) {
        this.documentSize = documentSize;
    }

   
    public byte[] getDocumentData() {
        return documentData;
    }

   
    public void setDocumentData(byte[] documentData) {
        this.documentData = documentData;
    }
}