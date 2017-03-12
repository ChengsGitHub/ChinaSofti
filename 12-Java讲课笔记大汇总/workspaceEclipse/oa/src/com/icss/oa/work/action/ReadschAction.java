package com.icss.oa.work.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.work.pojo.Readsch;
import com.icss.oa.system.service.EmpService;
import com.icss.oa.work.service.ReadschService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/readsch")
@Results({ @Result(name = "success", location = "/readsch/query.action?pageNum=${pageNum}", type = "redirect") })
public class ReadschAction extends BaseAction implements ModelDriven<Readsch> {

	private Readsch readsch = new Readsch();

	private int pageNum;

	private Integer[] ids;

	@Autowired
	private ReadschService service;
	
	@Autowired
	private EmpService empService;
	
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Readsch getReadsch() {
		return readsch;
	}

	public void setReadsch(Readsch readsch) {
		this.readsch = readsch;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Readsch getModel() {

		return readsch;
	}

	@Action("insert")
	public String insert() throws IOException {
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		if(ids==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('请输入读者ID');history.back();</script>");
			return null;
		}
		else{
		for (Integer id : ids) {
			//设置部门ID			
			Integer deptId = empService.queryById(empId).getDeptId();
			readsch.setReadschdeptId(deptId);
			readsch.setReadschempId(id);
			readsch.setReadsch(0);
			readsch.setReadschEmpid(empId);
			service.insert(readsch);
		}
		return "success";
	  }
	}

//	@Action("update")
//	public String update() throws IOException {
//		service.update(readsch);
//		System.out.println("readsch=" + this.readsch);
//		return "success";
//	}

	@Action("delete")
	public String delete() throws IOException {
		service.delete(readsch.getReadschId());
		return "success";
	}

	@Action(value = "toUpdate", results = { @Result(name = "success", location = "/pages/work/ReadSchedule.jsp", type = "dispatcher") })
	public String toUpdate() {
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		
		Readsch readschObj = service.queryById(readsch.getReadschEmpid());
		request.setAttribute("readsch", readschObj);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/work/ChoseRead.jsp?readschEmpid=${emp1Id}", type = "dispatcher") })
	public String query() {
			
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
			
		Pager pager = new Pager(service.getCount(empId), pageNum);
		List<Map> list = service.query(pager,empId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "query2", results = { @Result(name = "success", location = "/pages/work/ReadSchedule.jsp", type = "dispatcher") })
	public String query2() {
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		
		Pager pager = new Pager(service.getOtherCount(empId), pageNum);
		List<Map> list = service.query2(pager,empId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

}