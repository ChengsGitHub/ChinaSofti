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

		//获得ServletContext对象
		ServletContext context = this.getServletContext();
		
		//读取初始化参数
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		
		//设置键值对
		context.setAttribute("ip", "192.168.2.1");
		
		//传入相对路径，返回物理路径
		String url = context.getRealPath("/123/456.html");
		System.out.println(url);
	}

}