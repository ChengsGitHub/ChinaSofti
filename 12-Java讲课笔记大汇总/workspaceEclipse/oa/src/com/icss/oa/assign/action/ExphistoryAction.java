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
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.assign.pojo.Exphistory;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.assign.service.ExphistoryService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/exphistory")
@Results({ @Result(name = "success", location = "/expinf/query.action?pageNum=${pageNum}", type = "redirect") })
public class ExphistoryAction extends BaseAction implements ModelDriven<Exphistory> {

	private Exphistory exphistory = new Exphistory();

	private int pageNum;
	
	@Autowired
	private ExphistoryService service;

	public Exphistory getExphistory() {
		return exphistory;
	}

	public void setExphistory(Exphistory exphistory) {
		this.exphistory = exphistory;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Exphistory getModel() {

		return exphistory;
	}
	
	//@Action("insert")
	@Action(value="insert",results = { @Result(name = "success", location = "/exphistory/toUpdate.action?exphistoryId1=${exphistoryId1}", type = "redirect")})
	public String insert() {
		service.insert(exphistory);
		return "success";
	}
	
	@Action(value="update",results = { @Result(name = "success", location = "/exphistory/toUpdate.action?exphistoryId1=${exphistoryId1}", type = "redirect")})
	public String update() {
		service.update(exphistory);
		return "success";
	}
	
	//@Action("delete")
	@Action(value="delete",results = { @Result(name = "success", location = "/exphistory/toUpdate.action?exphistoryId1=${exphistoryId1}", type = "redirect")})
	public String delete() {
		service.delete(exphistory.getExphistoryId2());
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/assign/ExphistoryDetails.jsp", type = "dispatcher")})
	public String toUpdate() {				
		List<Exphistory> list = service.query(exphistory.getExphistoryId1());
		request.setAttribute("list", list);	
		return "success";
	}

	/*
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/QueryExpinf.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Exphistory> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	*/
	
}