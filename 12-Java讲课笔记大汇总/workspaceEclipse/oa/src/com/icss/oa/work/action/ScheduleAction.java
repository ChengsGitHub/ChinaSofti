package com.icss.oa.work.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.google.gson.GsonBuilder;
import com.icss.oa.common.BaseAction;
import com.icss.oa.common.Pager;
import com.icss.oa.work.index.ScheduleQueryResult;
import com.icss.oa.work.pojo.Schedule;
import com.icss.oa.work.service.ScheduleService;
//import com.icss.oa.system.service.ImageService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/schedule")
@Results({ @Result(name = "success", location = "/schedule/query.action", type = "redirect") })
public class ScheduleAction extends BaseAction implements ModelDriven<Schedule> {

	private Schedule schedule = new Schedule();

	private int pageNum;

	private String queryStr;// 全文检索字符串

	@Autowired
	private ScheduleService service;

//	@Autowired
//	private ImageService imageService;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	@Override
	public Schedule getModel() {

		return schedule;
	}

	@Action("insert")
	public String insert() throws IOException {
				
		service.insert(schedule);
		return null;
	}

	@Action("update")
	public String update() throws IOException {
//		HttpSession session = request.getSession();
//		Integer empId = (Integer) session.getAttribute("emp1Id");
//		System.out.println(empId+".....");
//		schedule.setScheduleEmpid(empId);
		service.update(schedule);
		return "success";
	}
	@Action(value = "delete", results = { @Result(name = "success", location =  "/schedule/query.action?scheduleEmpid=${schedule.getScheduleEmpid()}", type = "redirect") })
	public String delete() throws IOException {
		service.delete(schedule.getScheduleId());
		return "success";
	}

	@Action(value = "toUpdate", results = { @Result(name = "success", location = "/pages/work/ScheduleDetails.jsp", type = "dispatcher") })
	public String toUpdate() {
		Schedule scheduleObj = service.queryById(schedule.getScheduleId());
		request.setAttribute("schedule", scheduleObj);
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/work/QuerySchedule.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(schedule.getScheduleEmpid()), pageNum);
		List<Schedule> list = service.query(pager, schedule.getScheduleEmpid());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}
	@Action(value = "queryOther", results = { @Result(name = "success", location = "/pages/work/QuerySchedule.jsp", type = "dispatcher") })
	public String queryOther() {
		
		Pager pager = new Pager(service.getCount(schedule.getScheduleEmpid()), pageNum);
		List<Schedule> list = service.query(pager, schedule.getScheduleEmpid());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	/**
	 * 带条件查询
	 * 
	 * @return
	 */
	@Action(value = "queryByCondition", results = { @Result(name = "success", location = "/pages/work/QueryConditionSchedule.jsp", type = "dispatcher") })
	public String queryByCondition() throws IOException {
		
		//get请求传递中文需要手动转码
		String scheduleSch = new String(schedule.getScheduleSch().getBytes("iso-8859-1"),"utf-8");
		schedule.setScheduleSch(scheduleSch);
		
		System.out.println("scheduleSch=" + schedule.getScheduleSch());
				
		Pager pager = new Pager(service.getConditionCount(schedule.getScheduleSch()),
				pageNum, 6);
		List<Schedule> list = service.querByCondition(pager, schedule.getScheduleSch());
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	/**
	 * 全文检索员工
	 * 
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 */
	@Action(value = "queryByIndex", results = { @Result(name = "success", location = "/pages/work/QueryScheduleByIndex.jsp", type = "dispatcher") })
	public String queryByIndex() throws Exception {

		Pager pager = new Pager(pageNum);
		ScheduleQueryResult queryResult = service.queryByIndex(queryStr, pager);
		request.setAttribute("queryResult", queryResult);
		request.setAttribute("pager", pager);
		return "success";
	}
	
	/**
	 * 提供手机端数据访问接口，返回员工JSON数据
	 * @throws IOException 
	 */
	@Action(value = "androidQuery", results = { @Result(name = "success", location = "/pages/work/QuerySchedule.jsp", type = "dispatcher") })
	public String androidQuery() throws IOException {
		
		HttpSession session = request.getSession();
		Integer empId = (Integer) session.getAttribute("emp1Id");
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Pager pager = new Pager(service.getCount(empId), pageNum);
		List<Schedule> list = service.query(pager, empId);
		
		List<Map> list2 = new ArrayList<Map>();
		
		for (Schedule s : list) {
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("scheduleId", s.getScheduleId());
			map.put("scheduleEmpname", s.getScheduleEmpname());
			map.put("scheduleSch", s.getScheduleSch());
			map.put("scheduleBedate", s.getScheduleBedate());
			map.put("scheduleEndate", s.getScheduleEndate());
			map.put("scheduleRem", s.getScheduleRem());
			list2.add(map);
		}
		
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create();  
		
		HashMap jsonMap = new HashMap();
		jsonMap.put("pageCount", pager.getPageCount());
		jsonMap.put("list", list2);
		
		String jsonStr = gson.toJson(jsonMap);
		
		
		System.out.println(jsonStr);
		out.write(jsonStr);
		
		
		
		return null;
	}
}