package chapter3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//����������루����POST������Ч��
		request.setCharacterEncoding("utf-8");
			
		//������������ֵ
		String username = request.getParameter("username");
		//GET��������ת��
		//username = new String(username.getBytes("iso-8859-1"),"utf-8");
		
		String userpwd = request.getParameter("userpwd");
		String myinfo = request.getParameter("myinfo");
		String sex = request.getParameter("sex");
		
		//��ö��ͬ��������ֵ������һ������
		String[] skill = request.getParameterValues("skill");
		
		String city = request.getParameter("city");
		String userId = request.getParameter("userId");
		
		//���������
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		System.out.println("myinfo=" + myinfo);
		System.out.println("sex=" + sex);
		System.out.println("skill=" + Arrays.toString(skill));
		System.out.println("city=" + city);
		System.out.println("userId=" + userId);
		
		System.out.println("-------------------------------");
		
		//������е������������
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
	}

}