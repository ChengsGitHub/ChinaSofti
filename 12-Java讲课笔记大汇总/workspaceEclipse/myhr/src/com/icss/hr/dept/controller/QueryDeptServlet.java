package com.icss.hr.dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.impl.DeptServiceImpl;

@WebServlet("/QueryDeptServlet")
public class QueryDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DeptServiceImpl service = new DeptServiceImpl();
		
		try {
			//����service��ѯ���ܷ������ݼ���
			ArrayList<Dept> list = service.query();
			
			//��request��Χ�洢���ݣ�����ת����JSP��ͼ
			request.setAttribute("list", list);
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
			
		} catch (Exception e) {			
			e.printStackTrace();
			//�洢���� ��Ϣ��ת��������ҳ 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}