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

@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// ����������ֵ
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		
		// ��װΪVO����
		DeptVo vo = new DeptVo(Integer.parseInt(deptId), deptName, deptLoc);

		// ����Service����
		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
						
			//��������
			service.update(vo);
			out.println("<script>alert('���Ÿ��³ɹ�');location.href='QueryDeptServlet';</script>");
			
		} catch (Exception e) {		
			e.printStackTrace();
			//�洢���� ��Ϣ��ת��������ҳ 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}