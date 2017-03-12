package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.service.impl.JobServiceImpl;
import com.icss.hr.job.vo.JobVo;

@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// �����������Ӧ�ı���
		request.setCharacterEncoding("utf-8");// ����utf-8
		response.setContentType("text/html;charset=utf-8");// ��Ӧ����

		PrintWriter out = response.getWriter();// ���

		// ����������
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMinSalary = request.getParameter("jobMinSalary");
		String jobMaxSalary = request.getParameter("jobMaxSalary");

		// ��װΪVO����
		JobVo vo = new JobVo(jobId, jobName, Integer.parseInt(jobMinSalary),
				Integer.parseInt(jobMaxSalary));

		// ����servlet����
		JobServiceImpl service = new JobServiceImpl();
		
		try {
			//�жϲ��ű���Ѵ���
			if(service.queryById(jobId) != null){
				out.println("<script>alert('��ְ���Ѵ���');history.back();</script>");
				return;
			}
			
			//��������
			service.insert(vo);
			out.println("<script>alert('ְ�����ӳɹ�');location.href='QueryJobServlet'</script>");
		} catch (Exception e) {			
			e.printStackTrace();
			//�洢���� ��Ϣ��ת��������ҳ 
			request.setAttribute("errmsg", e.getMessage());						
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

}