package com.icss.hr.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//获得表单数据 
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		int adminLevel = Integer.parseInt(request.getParameter("adminLevel"));
		
		//封装为VO对象
		AdminVo vo = new AdminVo(adminName,adminPwd,adminLevel);
		
		//创建service对象
		AdminServiceImpl service = new AdminServiceImpl();
		
		//调用验证登陆的业务方法，返回值做判断
		try {
			int flag = service.checkLogin(vo);
			
			if (flag == 1) {
				//用户名不存在
				out.println("<script>alert('用户名不存在');history.back();</script>");
			} else if (flag == 2) {
				//密码错误
				out.println("<script>alert('密码输入错误');history.back();</script>");
			} else if (flag == 3) {
				//级别选择错误
				out.println("<script>alert('级别选择错误');history.back();</script>");
			} else {
				//登陆成功，保存登陆数据到会话中，跳转到默认主页
				HttpSession session = request.getSession();
				session.setAttribute("admin", vo);
				response.sendRedirect("Main.jsp");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

}