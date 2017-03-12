package com.icss.oa.folder.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.icss.oa.common.BaseAction;
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.folder.pojo.Folder;
import com.icss.oa.folder.service.FolderService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/folder")
@Results({ @Result(name = "success", location = "/pages/folderMana/QueryFolder.jsp", type = "redirect") })
public class FolderAction extends BaseAction implements ModelDriven<Folder> {

	private Folder folder = new Folder();
	private Emp1 emp1 = new Emp1();
	private String subFolderName;
	private Integer sharing;
	
	private int pageNum;
	@Autowired
	private FolderService service;

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public Integer getSharing() {
		return sharing;
	}

	public void setSharing(Integer sharing) {
		this.sharing = sharing;
	}


	public String getSubFolderName() {
		return subFolderName;
	}

	public void setSubFolderName(String subFolderName) {
		this.subFolderName = subFolderName;
	}

	@Override
	public Folder getModel() {

		return folder;
	}
	
	@Action("insert")
	public String insert() {
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		folder.setEmpId(empId);
		folder.setFolderName(subFolderName);
		service.insert(folder);
		return "success";
	}
	
	@Action(value="updateSharing" ,results = { @Result(name = "success", location = "/pages/folderMana/QuerySharingDir.jsp", type = "dispatcher") })
	public String updateSharing() {
		service.updateSharing(folder);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(folder);
		return "success";
	}
	
	
	@Action("delete")
	public String delete() {
		service.delete(folder.getFolderId());
		return "success";
	}
	
	
	
	
	
	@Action(value="queryBySharing",results = { @Result(name = "success", location = "/pages/folderMana/QuerySharingDir.jsp", type = "dispatcher") })
	public String queryBySharing() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		
		HttpSession session = request.getSession();
		Integer emp1Id = (Integer) session.getAttribute("emp1Id");
		
		List<Folder> list = service.queryBySharing(emp1Id);
		
		List<Map> jsonList = new ArrayList<Map>();
		
		HashMap rootMap = new HashMap();
		rootMap.put("id", 1);
		rootMap.put("pId",0);
		rootMap.put("name","根目录");
		rootMap.put("isParent", true);
		rootMap.put("open", true);
		
		jsonList.add(rootMap);
		
		for (Folder folder : list) {
			HashMap map = new HashMap();
			map.put("id", folder.getFolderId());
			map.put("pId",folder.getParentId());
			map.put("name", folder.getFolderName());
			map.put("isParent", true);
						
			jsonList.add(map);
		}
		
		out.print(gson.toJson(jsonList));
		
		return null;
		
	}
	
@Action(value="queryByEmpId",results = { @Result(name = "success", location = "/pages/folderMana/QueryFolder.jsp", type = "dispatcher") })
public String query() throws IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		
		List<Folder> list = service.queryByEmpId(empId);
		
		List<Map> jsonList = new ArrayList<Map>();
		
		HashMap rootMap = new HashMap();
		rootMap.put("id", 1);
		rootMap.put("pId",0);
		rootMap.put("name","根目录");
		rootMap.put("isParent", true);
		rootMap.put("open", true);
		
		jsonList.add(rootMap);
		
		for (Folder folder : list) {
			HashMap map = new HashMap();
			map.put("id", folder.getFolderId());
			map.put("pId",folder.getParentId());
			map.put("name", folder.getFolderName());
			map.put("isParent", true);
						
			jsonList.add(map);
		}
		
		out.print(gson.toJson(jsonList));
		
		return null;
	}
@Action(value="queryOtherEmpSharing",results = { @Result(name = "success", location = "/pages/folderMana/QueryOthersSharingDir.jsp", type = "dispatcher") })
public String queryOtherEmpSharing() throws IOException {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	Gson gson = new Gson();
	List<Folder> list = service.queryBySharing(folder.getEmpId());
	List<Map> jsonList = new ArrayList<Map>();
	
	HashMap rootMap = new HashMap();
	rootMap.put("id", 1);
	rootMap.put("pId",0);
	rootMap.put("name","根目录");
	rootMap.put("isParent", true);
	rootMap.put("open", true);
	
	jsonList.add(rootMap);
	
	for (Folder folder : list) {
		HashMap map = new HashMap();
		map.put("id", folder.getFolderId());
		map.put("pId",folder.getParentId());
		map.put("name", folder.getFolderName());
		map.put("isParent", true);
					
		jsonList.add(map);
	}
	
	out.print(gson.toJson(jsonList));
	
	return null;
	
}


}