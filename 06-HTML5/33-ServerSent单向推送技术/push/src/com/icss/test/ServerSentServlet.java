package com.icss.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerSentServlet
 */
@WebServlet("/ServerSentServlet")
public class ServerSentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		//������Ӧ���ͺͱ���
		response.setContentType("text/event-stream;charset=utf-8");
		
		//���ý�ֹ����
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//��������
		PrintWriter out = response.getWriter();
		
		while (true) {
//			ע�⣺��Ӧ�����ݱ�����data:xxxxx��ʽ�ģ�����ͻ��˻�ȡ����
			out.write("data:�������Է������˵���Ϣ��" + new Date() + "\n\n");
			out.flush();
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}