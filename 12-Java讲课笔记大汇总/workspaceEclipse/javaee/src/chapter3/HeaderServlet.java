package chapter3;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//读取消息报头
		String language = request.getHeader("Accept-Language");
		System.out.println("客户端语言=" + language);
		
		//获得所有的报头信息
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + "=" + value);
		}
	}

}