package com.icss.hr.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		String adminLevel = request.getParameter("adminLevel");
		
		AdminVo vo = new AdminVo(adminName,adminPwd,Integer.parseInt(adminLevel));
		
		AdminService service = new AdminServiceImpl();
		
		try {
			int result = service.checkLogin(vo);
			
			if (result == 1) {
				out.println("<script>alert('用户名不存在！');history.back();</script>");
				return;
			} else if (result == 2) {
				out.println("<script>alert('密码不正确！');history.back();</script>");
				return;
			} else if (result == 3) {
				out.println("<script>alert('登陆级别选择错误！');history.back();</script>");
				return;
			} else if (result == 4) {
				HttpSession session = request.getSession();
				session.setAttribute("adminVo", vo);
				response.sendRedirect(request.getContextPath() + "/Main.jsp");
				return;
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
	}

}
