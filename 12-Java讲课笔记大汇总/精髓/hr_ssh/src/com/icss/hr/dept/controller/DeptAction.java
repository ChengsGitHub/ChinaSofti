package com.icss.hr.dept.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.icss.hr.common.BaseAction;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.vo.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction extends BaseAction implements ModelDriven<DeptVo> {

	private DeptVo vo = new DeptVo();

	private DeptService service;

	public DeptVo getVo() {
		return vo;
	}

	public void setVo(DeptVo vo) {
		this.vo = vo;
	}

	public void setService(DeptService service) {
		this.service = service;
	}

	@Override
	public DeptVo getModel() {
		return vo;
	}

	public String add() {

		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			System.out.println("deptId=" + service.queryById(vo.getDeptId()));

			if (service.queryById(vo.getDeptId()) != null) {
				out.println("<script>alert('部门编号已存在！');history.back();</script>");
				return null;
			}

			service.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	public String delete() {

		try {						
			service.delete(vo.getDeptId());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	public String toUpdate() {

		try {
			Dept dept = service.queryById(vo.getDeptId());
			request.setAttribute("dept", dept);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	public String update() {

		try {
			service.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	public String query() {

		try {
			List<Dept> list = service.query();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

}