package com.icss.oa.assign.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.icss.oa.assign.pojo.Assigncom;
import com.icss.oa.assign.service.AssigncomService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/assigncom")
@Results({ @Result(name = "success", location = "/assigncom/query.action?pageNum=${pageNum}", type = "redirect") })
public class AssigncomAction extends BaseAction implements ModelDriven<Assigncom> {

	private Assigncom assigncom = new Assigncom();

	private int pageNum;
	
	@Autowired
	private AssigncomService service;

	public Assigncom getAssigncom() {
		return assigncom;
	}

	public void setAssigncom(Assigncom assigncom) {
		this.assigncom = assigncom;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Assigncom getModel() {

		return assigncom;
	}
	
	@Action("insert")
	public String insert() {
		service.insert(assigncom);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(assigncom);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		service.delete(assigncom.getAssigncomId());
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/assign/AssigncomDetails.jsp", type = "dispatcher")})
	public String toUpdate() {
		Assigncom assigncomObj = service.queryById(assigncom.getAssigncomId());
		request.setAttribute("assigncom", assigncomObj);
		return "success";
	}
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/assign/QueryAssigncom.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Assigncom> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/assign/QueryAssigncomSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Assigncom> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action("getAssigncomJson")
	public String getAssigncomJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Assigncom assigncomObj = service.queryById(assigncom.getAssigncomId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("assigncomName", assigncomObj.getAssigncomName());
		out.write(gson.toJson(map));

		return null;
	}
	
}