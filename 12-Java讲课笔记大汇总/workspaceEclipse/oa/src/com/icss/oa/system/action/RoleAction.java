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
import com.icss.oa.system.pojo.Role;
import com.icss.oa.system.service.DeptService;
import com.icss.oa.system.service.DeptServiceImpl;
import com.icss.oa.system.service.RoleService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/role")
@Results({@Result(name = "success", location = "/role/queryRole.action", type = "redirect")})
public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private Role role = new Role();

	private int pageNum;// Ò³Âë

	@Autowired
	private RoleService service;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Role getModel() {
		return role;
	}

		
	@Action(value = "queryRoleSmall", results = { @Result(name = "success", location = "/pages/systemMana/QueryRoleSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Role> list = service.queryRole(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

//	@Action("getRoleJson")
//	public String getRoleJson() throws IOException {
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//				
//		Role roleObj = service.queryRoleId(role.getRoleId());
//		Gson gson = new Gson();
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		System.out.println(roleObj.getRoleId()+"..........................................");
//		map.put("roleId", roleObj.getRoleId());
//		out.write(gson.toJson(map));
//		
//		return null;
//	}
}