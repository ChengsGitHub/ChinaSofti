package com.icss.oa.bus.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.icss.oa.bus.pojo.Busorder;
import com.icss.oa.bus.service.BusorderService;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/busorder")
@Results({@Result(name = "success", location = "/busorder/query.action", type = "redirect")})
public class BusorderAction extends BaseAction implements ModelDriven<Busorder>{

	private Busorder busorder = new Busorder();


	private int pageNum;// 页码

	@Autowired
	private BusorderService service;

	
	
	public Busorder getBusorder() {
		return busorder;
	}

	public void setBusorder(Busorder busorder) {
		this.busorder = busorder;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	@Override
	public Busorder getModel(){
		return busorder;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		busorder.setEmpId(empId);
		service.insert(busorder); 
		return "success";
	}
	
	@Action("delete")
	public String delete() throws Exception{
		service.delete(busorder.getBorderId());
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		service.update(busorder);
		return "success";
	}
	
	@Action(value="toApproval",results = { @Result(name = "success", location = "/pages/bus/BusApproval.jsp", type = "dispatcher")})
	public String toApproval() throws Exception {
		Busorder busorderObj = service.queryById(busorder.getBorderId());
		request.setAttribute("busorder", busorderObj);
		return "success";
	}
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/bus/UpdateBusOrder.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Busorder busorderObj = service.queryById(busorder.getBorderId());
		request.setAttribute("busorder", busorderObj);
		return "success";
	}
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/bus/QueryBusOrder.jsp", type = "dispatcher") })
	public String query() throws Exception {
		
		
	Subject currentUser = SecurityUtils.getSubject(); 
		
		if (currentUser.hasRole("车队队长")||currentUser.hasRole("超级用户") ) {
			int empId=0;
			Pager pager = new Pager(service.getCount(empId), pageNum);
			
			List<Map> list = service.query(pager,empId);
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			return "success";
		}
		else {
			
			HttpSession session = request.getSession();
			Integer empId = (Integer) session.getAttribute("emp1Id");
			Pager pager = new Pager(service.getCount(empId), pageNum);
			List<Map> list = service.query(pager,empId);
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			return "success";
			
		}
	}
	
	@Action(value = "queryById" )
	public Busorder queryById(Integer borderId) throws Exception {
		service.queryById(borderId);
		return busorder;
	}
	
}
