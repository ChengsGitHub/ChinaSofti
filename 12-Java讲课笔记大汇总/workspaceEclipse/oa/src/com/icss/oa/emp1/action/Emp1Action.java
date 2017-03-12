package com.icss.oa.emp1.action;

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
import com.icss.oa.common.Pager;

import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.folder.service.FolderService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/emp1")
@Results({ @Result(name = "success", location = "/emp1/query.action", type = "redirect") })
public class Emp1Action extends BaseAction implements ModelDriven<Emp1> {

	private Emp1 emp1 = new Emp1();
	
	private int pageNum;
	
	@Autowired
	private Emp1Service service;
	@Autowired
	private FolderService folderServiceImpl;

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Emp1 getModel() {

		return emp1;
	}
	
	@Action(value="update",results = { @Result(name = "success", location = "/emp1/read.action", type = "redirect")})
	public String update() {
		service.update(emp1);
		return "success";
	}

	
	@Action(value="queryByOther",results = { @Result(name = "success", location = "/pages/emp1/QueryEmp1.jsp", type = "dispatcher")})
	public String queryByOther() {
		
		System.out.println("empName=" + emp1.getEmp1Name());
		
		List<Map<String,Object>> list =service.queryByOther(emp1.getEmp1Name(),emp1.getDeptId() ,emp1.getJobId());
		request.setAttribute("list", list);
		return "success";
	}

	
	@Action(value="read",results = { @Result(name = "success", location = "/pages/emp1/Emp1Details.jsp", type = "dispatcher")})
	public String toUpdate() {
		HttpSession session = request.getSession();
		Integer emp1Id = (Integer) session.getAttribute("emp1Id");
		Emp1 emp1Obj = service.queryById(emp1Id);
		request.setAttribute("emp1", emp1Obj);
		return "success";
	}
	
	@Action(value="readEmp",results = { @Result(name = "success", location = "/pages/emp1/OtherEmp1Details.jsp", type = "dispatcher")})
	public String toUpdateEmp() {
		Emp1 emp1Obj = service.queryById(emp1.getEmp1Id());
		request.setAttribute("emp1", emp1Obj);
		return "success";
	}
	
	
	@Action(value="query",results = { @Result(name = "success", location = "/pages/emp1/QueryEmp1.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Map<String,Object>> list = service.query2(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/message/QueryEmpSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Emp1> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmallOne", results = { @Result(name = "success", location = "/pages/message/QueryEmpSmallOne.jsp", type = "dispatcher") })
	public String querySmallOne() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Emp1> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	
	
	@Action(value = "queryMeetingSmall", results = { @Result(name = "success", location = "/pages/meeting/QueryEmpSmall.jsp", type = "dispatcher") })
	public String queryMeetingSmall() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Emp1> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	/**
	 * 提供手机端数据访问接口，返回员工JSON数据
	 * @throws IOException 
	 */
	@Action(value = "androidQuery", results = { @Result(name = "success", location = "/pages/emp1/QueryEmp1.jsp", type = "dispatcher") })
	public String androidQuery() throws IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Emp1> list = service.query(pager);
		
		List<Map> list2 = new ArrayList<Map>();
		
		for (Emp1 e : list) {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("empId", e.getEmp1Id());
			map.put("empName", e.getEmp1Name());
			map.put("empMobile", e.getEmp1Mobile());
			list2.add(map);
		}
		
		Gson gson = new Gson();
		
		HashMap jsonMap = new HashMap();
		jsonMap.put("pageCount", pager.getPageCount());
		jsonMap.put("list", list2);
		
		String jsonStr = gson.toJson(jsonMap);
		out.write(jsonStr);
		
		return null;
	}
	
}