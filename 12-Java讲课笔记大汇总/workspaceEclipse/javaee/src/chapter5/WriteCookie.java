package chapter5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//����Cookie����
		Cookie username = new Cookie("username","tom");
		Cookie password = new Cookie("password","123456");
		
		//����ʧЧʱ�䣨����Ϊ��λ��,�������Ϊ-1����Զ��ʧЧ
		username.setMaxAge(60 * 60 * 24);
		password.setMaxAge(60 * 60 * 24 * 2);
		
		//д��Cookie���ݵ��ͻ��������
		response.addCookie(username);
		response.addCookie(password);
	}

}