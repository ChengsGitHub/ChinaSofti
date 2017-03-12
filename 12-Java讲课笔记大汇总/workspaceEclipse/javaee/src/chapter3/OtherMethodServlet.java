package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherMethodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
			
		// ���WEBӦ��·�����ص㣩
		out.println("WEBӦ��·����" + request.getContextPath());
		out.println("<br>");
		//������󷽷�
		out.println("���󷽷���" + request.getMethod());
		out.println("<br>");
		//���Э����
		out.println("Э������" + request.getProtocol());
		out.println("<br>");
		//��ò����ַ������ص㣩
		out.println("�����ַ�����" + request.getQueryString());
		out.println("<br>");
		//�������URI���ص㣩
		out.println("����URI��" + request.getRequestURI());
		out.println("<br>");
		//�������URL���ص㣩
		out.println("����URL��" + request.getRequestURL());
		out.println("<br>");
		//����û�IP��ַ
		out.println("�ͻ���IP��" + request.getRemoteAddr());
		out.println("<br>");
		//��÷�����IP���ص㣩
		out.println("��������IP��" + request.getLocalAddr());
		out.println("<br>");
		//��÷�����������
		out.println("��������������" + request.getLocalName());
		out.println("<br>");
		//��÷������˿�
		out.println("�������˿ڣ�" + request.getLocalPort());
		out.println("<br>");
		
	}

}