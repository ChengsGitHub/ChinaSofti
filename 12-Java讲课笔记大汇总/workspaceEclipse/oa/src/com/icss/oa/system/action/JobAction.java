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
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.JobService;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/job")
@Results({ @Result(name = "success", location = "/job/query.action", type = "redirect") })
public class JobAction extends BaseAction implements ModelDriven<Job> {

	private Job job = new Job();

	private int pageNum;// Ò³Âë

	@Autowired
	private JobService service;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public Job getModel() {

		return job;
	}

	@Action("insert")
	public String insert() {
		service.insert(job);
		return "success";
	}

	@Action("update")
	public String update() {
		service.update(job);
		return "success";
	}

	@Action("delete")
	public String delete() {
		service.delete(job.getJobId());
		return "success";
	}

	@Action(value = "query", results = { @Result(name = "success", location = "/pages/systemMana/Job.jsp", type = "dispatcher") })
	public String query() {
		Pager pager = new Pager(service.getCount(), pageNum, 10);
		List<Job> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action(value = "querySmall", results = { @Result(name = "success", location = "/pages/QueryJobSmall.jsp", type = "dispatcher") })
	public String querySmall() {
		Pager pager = new Pager(service.getCount(), pageNum, 6);
		List<Job> list = service.query(pager);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		return "success";
	}

	@Action("getJobJson")
	public String getJobJson() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		Job jobObj = service.queryById(job.getJobId());
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("jobName", jobObj.getJobName());
		out.write(gson.toJson(map));
		
		return null;
	}
}