package com.icss.hr.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;
import com.icss.hr.common.BaseAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends BaseAction implements ModelDriven<AdminVo> {

	private AdminVo vo = new AdminVo();

	private AdminService service;

	public AdminVo getVo() {
		return vo;
	}

	public void setVo(AdminVo vo) {
		this.vo = vo;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

	@Override
	public AdminVo getModel() {

		return vo;
	}

	public String login() throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ���ص�½��ʶ
		int flag = service.checkLogin(vo);

		if (flag == 1) {
			out.println("<script>alert('�û��������ڣ�');history.back();</script>");
			return null;
		} else if (flag == 2) {
			out.println("<script>alert('���벻��ȷ��');history.back();</script>");
			return null;
		} else if (flag == 3) {
			out.println("<script>alert('����ѡ�����');history.back();</script>");
			return null;
		} else {
			// ��session��Χ�洢��ֵ��
			HttpSession session = request.getSession();
			session.setAttribute("adminName", vo.getAdminName());
			session.setAttribute("adminLevel", vo.getAdminLevel());

			return Action.SUCCESS;
		}

	}

}