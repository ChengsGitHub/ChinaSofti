package com.icss.oa.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
import com.icss.oa.system.dao.EmpDao;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Emp;
import com.icss.oa.system.pojo.Role;
import com.icss.oa.system.service.EmpService;
import com.icss.oa.system.service.EmpServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/emp")
@Results({ @Result(name = "success", location = "/emp/query.action", type = "redirect") })
public class EmpAction extends BaseAction implements ModelDriven<Emp> {
	@Autowired
	private SqlSessionFactory factory;
	private Emp emp = new Emp();
	private Emp1 emp1 = new Emp1();
	private int pageNum;
	@Autowired
	private EmpService service;
	@Autowired
	private Emp1Service emp1Service;
	@Autowired
	private EmpDao dao;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Emp getModel() {

		return emp;
	}
	
	//@Action("insert")
	@Action(value="insert",results = { @Result(name = "success", location = "/emp/toSetAssign.action?empId=${emp.getEmpId()}", type = "redirect")})
	public String insert() {
		service.insert(emp);
		int empId=service.getPrimaryKey()-1;
		emp.setEmpId(empId);
		return "success";
	}
	
	@Action("update")
	public String update() {
		service.update(emp);
		return "success";
	}
	
	@Action("delete")
	public String delete() {
		int empId=emp.getEmpId();
		service.delete(empId);
		
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/systemMana/EmpDetails.jsp", type = "dispatcher")})
	public String toUpdate() {
		
		Emp empObj = service.queryById(emp.getEmpId());
		request.setAttribute("emp", empObj);
		
		return "success";
	}
	@Action(value="toSetAssign",results = { @Result(name = "success", location = "/pages/systemMana/Autho.jsp", type = "dispatcher")})
	public String toInsertAssign() {
		
		Emp empObj = service.queryById(emp.getEmpId());
		request.setAttribute("emp", empObj);
		List<Map<String,Object>> list =service.queryRole(emp.getEmpId());
		request.setAttribute("list", list);
		return "success";
	}
	@Action(value="query",results = { @Result(name = "success", location = "/pages/systemMana/QueryEmp.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Map<String,Object>> list = service.query2(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	
	
	@Action(value="insertUserRole", results = { @Result(name = "success", location = "toSetAssign.action?empId=${emp.empId}", type = "redirect") })
	public String insertUserRole() throws IOException {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		if(emp.getRoleId() == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('ÇëÑ¡Ôñ½ÇÉ«');history.back();</script>");
			return null;
		}
		int empId=emp.getEmpId();
		int roleId=emp.getRoleId();
		map.put("empId", empId);
		map.put("roleId",roleId);
		service.insertUserRole(map);
		return "success";
	}
	
//	@Action(value="queryRole",results = { @Result(name = "success", location = "/pages/systemMana/Autho.jsp", type = "dispatcher") })
//	public String queryRole() {	
//		List<Map<String,Object>> list =service.queryRole(emp.getEmpId());
//		request.setAttribute("list", list);
//		return "success";
//	}
	
	@Action(value="queryByOther",results = { @Result(name = "success", location = "/pages/systemMana/QueryOtherEmp.jsp", type = "dispatcher")})
	public String queryByOther() {
		List<Map<String,Object>> list =emp1Service.queryByOther(emp.getEmpName(),emp.getDeptId() ,emp.getJobId());
		request.setAttribute("list", list);
		return "success";
	}
	
	@Action(value="deleteRole", results = { @Result(name = "success", location = "toSetAssign.action?empId=${emp.empId}", type = "redirect") })
	public String deleteRole() {
		service.deleteRole(emp.getUr());
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/work/QueryEmpSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum, 6);
		List<Emp> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action("getEmpJson")
	public String getEmpJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Emp empObj = service.queryById(emp.getEmpId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empName", empObj.getEmpName());
		out.write(gson.toJson(map));
		return null;
	}
	
	
}