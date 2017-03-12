package com.icss.oa.meeting.action;


import java.io.PrintWriter;
import java.util.HashMap;
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


import com.google.gson.Gson;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.meeting.pojo.Meetingorder;
import com.icss.oa.meeting.service.MeetingorderService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/meetingorder")
@Results({@Result(name = "success", location = "/meetingorder/query.action", type = "redirect")})
public class MeetingorderAction extends BaseAction implements ModelDriven<Meetingorder>{

	private Meetingorder meetingorder = new Meetingorder();

	private int pageNum;// 页码

	@Autowired
	private MeetingorderService service;
	public Meetingorder getMeetingorder(){
		return meetingorder;
	}
	
	public void setMeetingorder(Meetingorder meetingorder){
		this.meetingorder = meetingorder;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	@Override
	public Meetingorder getModel(){
		return meetingorder;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		meetingorder.setEmpId(empId);
		service.insert(meetingorder);

		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		service.update(meetingorder);
		return "success";
	}
	@Action("delete")
	public String delete() throws Exception{
		service.delete(meetingorder.getOrderId());
		return "success";
	}
	@Action(value="toApproval",results = { @Result(name = "success", location = "/pages/meeting/MeetingApproval.jsp", type = "dispatcher")})
	public String toApproval() throws Exception {
		Meetingorder meetingorderObj = service.queryById(meetingorder.getOrderId());
		request.setAttribute("meetingorder", meetingorderObj);
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/meeting/UpdateMeetingOrder.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Meetingorder meetingorderObj = service.queryById(meetingorder.getOrderId());
		request.setAttribute("meetingorder", meetingorderObj);
		return "success";
	}
	
	
	
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/meeting/QueryMeetingOrd.jsp", type = "dispatcher") })
	public String query() throws Exception {
		
		
		Subject currentUser = SecurityUtils.getSubject(); 
		
		if (currentUser.hasRole("行政负责人")||currentUser.hasRole("超级用户") ) {
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
	
	@Action(value = "querymeeting", results = { @Result(name = "success", location = "/pages/meeting/QueryMeeting.jsp", type = "dispatcher") })
	public String querymeeting() throws Exception {
		Subject currentUser = SecurityUtils.getSubject(); 
		if (currentUser.hasRole("行政负责人")||currentUser.hasRole("超级用户") ) {
			int empId=0;
			Pager pager = new Pager(service.getMeetingCount(empId), pageNum);
			
			List<Map> list = service.querymeeting(pager,empId);
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			return "success";
		}
		else {
			HttpSession session = request.getSession();
			Integer empId = (Integer) session.getAttribute("emp1Id");
			Pager pager = new Pager(service.getMeetingCount(empId), pageNum);
			List<Map> list = service.querymeeting(pager,empId);
			request.setAttribute("list", list);
			request.setAttribute("pager", pager);
			return "success";
		}
	}
	
	@Action(value = "queryById" )
	public Meetingorder queryById(Integer orderId) throws Exception {
		service.queryById(orderId);
		return meetingorder;
	}
	
	@Action("getMeetingorderJson")
	public String getMeetingorderJson() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Meetingorder meetingorderObj = service.queryById(meetingorder.getOrderId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", meetingorderObj.getStartTime());
		map.put("endTime", meetingorderObj.getEndTime());
		out.write(gson.toJson(map));
		return null;
	}
	
}
