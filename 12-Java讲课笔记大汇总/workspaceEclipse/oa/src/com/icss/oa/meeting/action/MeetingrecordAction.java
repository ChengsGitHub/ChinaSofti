package com.icss.oa.meeting.action;


import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
import org.springframework.util.FileCopyUtils;

import com.google.gson.Gson;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingrecord;
import com.icss.oa.meeting.service.MeetingrecordService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/meetingrecord")
@Results({@Result(name = "success", location = "/meetingorder/querymeeting.action", type = "redirect")})
public class MeetingrecordAction extends BaseAction implements ModelDriven<Meetingrecord>{

	private Meetingrecord meetingrecord = new Meetingrecord();
	private File fileData;
	private int pageNum;// 页码

	@Autowired
	private MeetingrecordService service;
	
	public Meetingrecord getMeetingrecord(){
		return meetingrecord;
	}
	
	public void setMeetingrecord(Meetingrecord meetingrecord){
		this.meetingrecord = meetingrecord;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public File getFileData() {
		return fileData;
	}

	public void setFileData(File fileData) {
		this.fileData = fileData;
	}

	@Override
	public Meetingrecord getModel(){
		return meetingrecord;
	}
	
	@Action("insert")
	public String insert() throws Exception{
		if(fileData == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('请选择记录');history.back();</script>");
			return null;
		}
		byte[] fileData = FileCopyUtils.copyToByteArray(this.fileData);

		meetingrecord.setMeetingInfo(fileData);
		service.insert(meetingrecord);
		return "success";
	}
	
	@Action("update")
	public String update() throws Exception{
		service.update(meetingrecord);
		return "success";
	}
	
	@Action(value="toUpdate",results = { @Result(name = "success", location = "/pages/meeting/MeetingApproval.jsp", type = "dispatcher")})
	public String toUpdate() throws Exception {
		Meetingrecord meetingrecordObj = service.queryById(meetingrecord.getRecordId());
		request.setAttribute("meetingrecord", meetingrecordObj);
		return "success";
	}
	
	@Action(value = "query", results = { @Result(name = "success", location = "/pages/meeting/QueryMeeting.jsp", type = "dispatcher") })
	public String query() throws Exception {
		Pager pager = new Pager(service.getCount(), pageNum);
		List<Meetingrecord> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	
	@Action(value = "queryById")
	public Meetingrecord queryById(Integer orderId) throws Exception {
		service.queryById(orderId);
		return meetingrecord;
	}
	
	@Action("getMeetingorderJson")
	public String getMeetingorderJson() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		Meetingrecord meetingrecordObj = service.queryById(meetingrecord.getRecordId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", meetingrecordObj.getOrderId());
		out.write(gson.toJson(map));
		
		return null;
	}
	
	

	@Action("download")
	public String download() throws Exception {
		
		
		
		Meetingrecord meetingrecordObj = service.download(meetingrecord.getOrderId());
		
		if(meetingrecordObj == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<script>alert('未找到会议记录');history.back();</script>");
			return null;
		}
		
		String filename = URLEncoder.encode("MeetingRecord.html", "utf-8");
		
		response.setHeader("content-disposition", "attachment;filename="+filename);
						
		byte[] fileData = meetingrecordObj.getMeetingInfo();
				
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fileData, out);
		
		return null;
		
	}
}
