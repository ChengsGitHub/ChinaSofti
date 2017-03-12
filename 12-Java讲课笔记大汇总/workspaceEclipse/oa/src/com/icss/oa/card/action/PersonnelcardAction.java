package com.icss.oa.card.action;

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
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.card.pojo.Personnelcard;
import com.icss.oa.card.service.PersonnelcardService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/Personnelcard")
@Results({@Result(name = "success", location = "/Personnelcard/query.action?groupId=${Personnelcard.groupId}", type = "redirect")})
public class PersonnelcardAction extends BaseAction implements ModelDriven<Personnelcard> {

	
	private Personnelcard Personnelcard = new Personnelcard();
	private Emp1 emp1 = new Emp1();
	private int pageNum;// Ò³Âë
	
	@Autowired
	private PersonnelcardService service;
	
	@Autowired
	private Emp1Service emp1Service;

	public Personnelcard getPersonnelcard() {
		return Personnelcard;
	}

	public void setPersonnelcard(Personnelcard Personnelcard) {
		this.Personnelcard = Personnelcard;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Personnelcard getModel() {
		return Personnelcard;
	}

	@Action("insert")
	public String insert() {
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		Personnelcard.setEmpId(empId);
		service.insert(Personnelcard);
		return "success";
	}
	
	@Action(value="delete", results = { @Result(name = "success", location = "/Personnelcard/query.action?groupId=${Personnelcard.groupId}", type = "redirect") })
	public String delete() {
		service.delete(Personnelcard.getCardId());
		request.setAttribute("groupId", Personnelcard.getGroupId());
		return "success";
	}
	
	@Action(value="toUpdate", results = { @Result(name = "success", location = "/pages/card/PersonnelcardDetails.jsp", type = "dispatcher") })
	public String toUpdate() {
		Personnelcard PersonnelcardObj = service.queryById(Personnelcard.getCardId());
		request.setAttribute("Personnelcard", PersonnelcardObj);
		return "success";
	}
	
	@Action(value="update", results = { @Result(name = "success", location = "/Personnelcard/query.action?groupId=${Personnelcard.groupId}", type = "redirect") })
	public String update() {
//		int groupId = Personnelcard.getGroupId();
		service.update(Personnelcard);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/card/QueryPersonnelcard.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(Personnelcard.getGroupId()), pageNum);
		List<Map<String,Object>> list = service.query(pager,Personnelcard.getGroupId());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "queryByEmpId",results = { @Result(name = "success", location = "/pages/card/QueryMyCard.jsp", type = "dispatcher")})
	public String queryByEmpId() {
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		emp1.setEmp1Id(empId);
		Emp1 emp1Obj = emp1Service.queryById(emp1.getEmp1Id());
		request.setAttribute("emp1", emp1Obj);
		return "success";
	}
	
	@Action("getPersonnelcardJson")
	public String getPersonnelcardJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Personnelcard PersonnelcardObj = service.queryById(Personnelcard.getCardId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("PersonnelcardName", PersonnelcardObj.getCardName());
		out.write(gson.toJson(map));
		
		return null;
	}
	
	@Action(value = "queryByCondition", results = { @Result(name = "success", location = "/pages/card/QueryConditionPersonnelcard.jsp", type = "dispatcher") })
	public String queryByCondition() {
		HttpSession session = request.getSession();
		int empId = (Integer)session.getAttribute("emp1Id");
		Pager pager = new Pager(service.getConditionCount(Personnelcard.getCardName(),empId),
				pageNum, 6);
		List<Personnelcard> list = service.querByCondition(pager, Personnelcard.getCardName(),empId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
}