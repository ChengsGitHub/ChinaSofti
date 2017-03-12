package chapter4;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//���ServletContext����
		ServletContext context = this.getServletContext();
		
		//��ȡ��ʼ������
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		
		//���ü�ֵ��
		context.setAttribute("ip", "192.168.2.1");
		
		//�������·������������·��
		String url = context.getRealPath("/123/456.html");
		System.out.println(url);
	}

}