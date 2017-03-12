package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.icss.hr.common.BaseAction;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.JobVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class JobAction extends BaseAction implements ModelDriven<JobVo> {

	private JobVo vo = new JobVo();

	private JobService service;

	public JobVo getVo() {
		return vo;
	}

	public void setVo(JobVo vo) {
		this.vo = vo;
	}

	public void setService(JobService service) {
		this.service = service;
	}

	@Override
	public JobVo getModel() {

		return vo;
	}

	public String add() throws IOException {
		if (service.queryById(vo.getJobId()) != null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('部门编号已存在');history.back();</script>");
			return null;
		}
		service.add(vo);
		return Action.SUCCESS;
	}

	public String delete() {
		service.delete(vo.getJobId());
		return Action.SUCCESS;
	}

	public String toUpdate() {
		Job job = service.queryById(vo.getJobId());
		request.setAttribute("job", job);
		return Action.SUCCESS;
	}

	public String update() {
		service.update(vo);
		return Action.SUCCESS;
	}

	public String query() {
		List<Job> list = service.query();
		request.setAttribute("list", list);
		return Action.SUCCESS;
	}
}