package com.icss.oa.meeting.action;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


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
import com.icss.oa.meeting.pojo.Meetingroom;
import com.icss.oa.meeting.service.MeetingroomService;
import com.icss.oa.meeting.service.MeetingroomServiceImpl;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/meetingroom")
@Results({@Result(name = "success", location = "/meetingroom/query.action", type = "redirect")})
public class MeetingroomAction extends BaseAction implements ModelDriven<Meetingroom>{

	private Meetingroom meetingroom = new Meetingroom();

	private int pageNum;// 页码

	@Autowired
	private MeetingroomService service;
	
	public Meetingroom getMeetingroom(){
		return meetingroom;
	}
	
	public void setMeetingroom(Meetingroom meetingroom){
		this.meetingroom = meetingroom;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	@Override
	public Meetingroom getModel(){
		return meetingroom;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		service.insert(meetingroom);
		return "success";
	}
	
	@Action("delete")
	public String delete() throws Exception{
		service.delete(meetingroom.getRoomId());
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		service.update(meetingroom);
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/meeting/Meetingroom.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Meetingroom meetingroomObj = service.queryById(meetingroom.getRoomId());
		request.setAttribute("meetingroom", meetingroomObj);
		return "success";
	}
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/meeting/Meetingroom.jsp", type = "dispatcher") })
	public String query() throws Exception {
		
		System.out.println("service=" + service.getClass().getName());
		
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Meetingroom> list = service.query(pager);
		
//		for (Meetingroom  room : list) {
//			System.out.println(list);
//		}
		
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	/**
	 * 带条件查询
	 * 
	 * @return
	 * @throws Exception 
	 */
	@Action(value = "queryByCondition", results = { @Result(name = "success", location = "/pages/meeting/QueryConditionRoom.jsp", type = "dispatcher") })
	public String queryByCondition() throws Exception {
		
		//get请求传递中文需要手动转码
		String roomName = new String(meetingroom.getRoomName().getBytes("iso-8859-1"),"utf-8");
		meetingroom.setRoomName(roomName);
		
		System.out.println("roomName=" + meetingroom.getRoomName());
				
		Pager pager = new Pager(service.getConditionCount(meetingroom.getRoomName()),
				pageNum, 6);
		List<Meetingroom> list = service.querByCondition(pager, meetingroom.getRoomName());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/meeting/QueryRoomSmall.jsp", type = "dispatcher") })
	public String querySmall() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum,6);
		List<Meetingroom> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	@Action("getMeetingroomJson")
	public String getMeetingroomJson() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Meetingroom meetingroomObj = service.queryById(meetingroom.getRoomId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("meetingroomName", meetingroomObj.getRoomName());
		out.write(gson.toJson(map));
		
		return null;
	}
}
