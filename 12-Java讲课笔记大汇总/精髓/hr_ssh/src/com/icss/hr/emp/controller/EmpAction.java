package com.icss.hr.emp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.BaseAction;
import com.icss.hr.common.Pager;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.po.Job;
import com.icss.hr.job.service.JobService;
import com.icss.hr.photo.po.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class EmpAction extends BaseAction implements ModelDriven<EmpVo> {

	private int pageNum;// 页码

	private EmpVo vo = new EmpVo();

	private JobService jobService;

	private DeptService deptService;

	private EmpService empService;

	private PhotoService photoService;

	public EmpVo getVo() {
		return vo;
	}

	public void setVo(EmpVo vo) {
		this.vo = vo;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	@Override
	public EmpVo getModel() {

		return vo;
	}

	public String toAdd() {

		List<Job> jobList = jobService.query();
		List<Dept> deptList = deptService.query();

		request.setAttribute("deptList", deptList);
		request.setAttribute("jobList", jobList);

		return Action.SUCCESS;
	}

	public String add() {
		
		empService.add(vo);

		return Action.SUCCESS;
	}

	public String delete() {
				
		//删除员工对应的照片文件
		List<Photo> photoList = photoService.query(vo.getEmpId());
		
		for (Photo photo : photoList ) {
			File file = new File(context.getRealPath("/upload/" + photo.getPhotoPath()));
			file.delete();
		}
				
		empService.delete(vo.getEmpId());

		return Action.SUCCESS;
	}

	public String toUpdate() {

		List<Job> jobList = jobService.query();
		List<Dept> deptList = deptService.query();
		Emp emp = empService.queryById(vo.getEmpId());

		request.setAttribute("deptList", deptList);
		request.setAttribute("jobList", jobList);
		request.setAttribute("emp", emp);

		return Action.SUCCESS;
	}

	public String update() {

		empService.update(vo);

		return Action.SUCCESS;
	}

	public String query() {

		Pager pager = new Pager(empService.getCount(), this.pageNum);

		List<Emp> list = empService.query(pager);

		request.setAttribute("list", list);
		request.setAttribute("pager", pager);

		return Action.SUCCESS;
	}

}