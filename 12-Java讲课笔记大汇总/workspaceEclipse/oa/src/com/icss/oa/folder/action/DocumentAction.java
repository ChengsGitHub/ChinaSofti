package com.icss.oa.folder.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import com.icss.oa.common.BaseAction;
import com.icss.oa.folder.pojo.Document;
import com.icss.oa.folder.service.DocumentService;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/document")
@Results({ @Result(name = "success", location = "/document/queryByFolderId.action?folderId=${document.folderId}", type = "redirect") })
public class DocumentAction extends BaseAction implements ModelDriven<Document>  {
	
	private File documentDataForm;// 上传文件数据
	
	private Document document = new Document();
	
	private String documentDataFormFileName;// 文件名称

	private String documentDataFormContentType;// 文件类型
	
	private Integer empId;
	@Autowired
	private DocumentService documentServiceImpl;
		
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	

	public File getDocumentDataForm() {
		return documentDataForm;
	}

	public void setDocumentDataForm(File documentDataForm) {
		this.documentDataForm = documentDataForm;
	}

	
	

	public String getDocumentDataFormFileName() {
		return documentDataFormFileName;
	}

	public void setDocumentDataFormFileName(String documentDataFormFileName) {
		this.documentDataFormFileName = documentDataFormFileName;
	}

	public String getDocumentDataFormContentType() {
		return documentDataFormContentType;
	}

	public void setDocumentDataFormContentType(String documentDataFormContentType) {
		this.documentDataFormContentType = documentDataFormContentType;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Action(value="delete",results = { @Result(name = "success", location = "/document/queryByFolderId.action?folderId=${document.folderId}", type = "redirect")})
	public String delete() {
		documentServiceImpl.deleteByDocumentId(document.getDocumentId());
		return "success";
	}
	
	@Action(value="queryByFolderId",results = { @Result(name = "success", location = "/pages/folderMana/QueryDocument.jsp", type = "dispatcher")})
	public String queryByFolderId() {
		List<Document> list =documentServiceImpl.queryByFolderId(document.getFolderId());
		request.setAttribute("list", list);
		return "success";
	}
	
	@Action(value="queryByEmpFolderId",results = { @Result(name = "success", location = "/pages/folderMana/QueryEmpDocument.jsp", type = "dispatcher")})
	public String queryByEmpFolderId() {
		List<Document> list =documentServiceImpl.queryByFolderId(document.getFolderId());
		request.setAttribute("list", list);
		return "success";
	}
	@Action("uploadDocument")
	public String uploadDocument() throws IOException {
		if(this.getDocumentDataForm() == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('请选择文件');history.back();</script>");
			return null;
		}
		byte[] documentData = FileCopyUtils.copyToByteArray(this.getDocumentDataForm());
		System.out.println("documentData=" + documentData.length);
		
		Document documentvar = new Document(documentDataFormFileName,document.getFolderId(),(int)this.getDocumentDataForm().length(),documentData);
				
		documentServiceImpl.insert(documentvar);

		return "success";
	}

	@Override
	public Document getModel() {
		// TODO Auto-generated method stub
		return document;
	}
	
	
	
	@Action("downloadDocument")
	public String downloadDocument() throws IOException {		
		
		Document documentObj = documentServiceImpl.queryById(document.getDocumentId());
		
		String filename = URLEncoder.encode(documentObj.getDocumentName(), "utf-8");
		
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		
		OutputStream out = response.getOutputStream();
				
		byte[] documentData = documentObj.getDocumentData();
		
		FileCopyUtils.copy(documentData, out);
		
		return null;
	}
	
}