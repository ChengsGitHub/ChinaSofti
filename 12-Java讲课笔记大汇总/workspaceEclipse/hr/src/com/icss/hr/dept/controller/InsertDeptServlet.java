package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.service.impl.DeptServiceImpl;
import com.icss.hr.dept.vo.DeptVo;

public class InsertDeptServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获得表单数据
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
				
		//封装VO
		DeptVo vo = new DeptVo(Integer.parseInt(deptId),deptName,deptLoc);
		
		//调用Service
		DeptService service = new DeptServiceImpl();
		
		try {
			
			if (service.queryById(Integer.parseInt(deptId)) != null) {
				out.println("<script>alert('部门编号已存在！');history.back();</script>");
				return;
			}			
			
			service.insert(vo);
			
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errmsg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		out.println("<script>alert('增加部门成功！');location.href='QueryDeptServlet';</script>");
	}

}