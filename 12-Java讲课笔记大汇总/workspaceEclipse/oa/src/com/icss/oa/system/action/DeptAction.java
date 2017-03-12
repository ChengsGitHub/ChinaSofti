package com.icss.oa.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

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
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.DeptService;
import com.icss.oa.system.service.DeptServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/dept")
@Results({@Result(name = "success", location = "/dept/query.action", type = "redirect")})
public class DeptAction extends BaseAction implements ModelDriven<Dept> {

	private Dept dept = new Dept();

	private int pageNum;// Ò³Âë

	@Autowired
	private DeptService service;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Dept getModel() {
		return dept;
	}

	@Action("insert")
	public String insert() {
		service.insert(dept);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		service.delete(dept.getDeptId());
		return "success";
	}
	
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/systemMana/UpdateDept.jsp", type = "dispatcher") })
	public String toUpdate() {
		Dept deptObj = service.queryById(dept.getDeptId());
		request.setAttribute("dept", deptObj);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(dept);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/systemMana/QueryDept.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Dept> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/QueryDeptSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Dept> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getDeptJson")
	public String getDeptJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Dept deptObj = service.queryById(dept.getDeptId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("deptName", deptObj.getDeptName());
		out.write(gson.toJson(map));
		
		return null;
	}
}