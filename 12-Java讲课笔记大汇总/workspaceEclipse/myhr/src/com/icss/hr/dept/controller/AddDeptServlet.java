package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;

@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		
		//获得请求参数值
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		//封装为VO对象
		DeptVo vo = new DeptVo(Integer.parseInt(deptId), deptName, deptLoc);
		
		//创建Service对象
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {	
			//判断部门编号已存在
			if (service.queryById(Integer.parseInt(deptId)) != null) {
				out.println("<script>alert('此部门编号已存在');history.back();</script>");
				return;
			}
			
			//插入数据
			service.insert(vo);
			out.println("<script>alert('部门增加成功');location.href='QueryDeptServlet';</script>");
			
		} catch (Exception e) {		
			e.printStackTrace();
			//存储错误 消息，转发到错误页 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}