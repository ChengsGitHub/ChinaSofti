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

		//创建Cookie对象
		Cookie username = new Cookie("username","tom");
		Cookie password = new Cookie("password","123456");
		
		//设置失效时间（以秒为单位）,如果设置为-1，永远不失效
		username.setMaxAge(60 * 60 * 24);
		password.setMaxAge(60 * 60 * 24 * 2);
		
		//写入Cookie数据到客户端浏览器
		response.addCookie(username);
		response.addCookie(password);
	}

}