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
		
		//设置请求编码（仅对POST请求有效）
		request.setCharacterEncoding("utf-8");
			
		//获得请求参数的值
		String username = request.getParameter("username");
		//GET请求中文转码
		//username = new String(username.getBytes("iso-8859-1"),"utf-8");
		
		String userpwd = request.getParameter("userpwd");
		String myinfo = request.getParameter("myinfo");
		String sex = request.getParameter("sex");
		
		//获得多个同名参数的值，返回一个数组
		String[] skill = request.getParameterValues("skill");
		
		String city = request.getParameter("city");
		String userId = request.getParameter("userId");
		
		//输出表单数据
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		System.out.println("myinfo=" + myinfo);
		System.out.println("sex=" + sex);
		System.out.println("skill=" + Arrays.toString(skill));
		System.out.println("city=" + city);
		System.out.println("userId=" + userId);
		
		System.out.println("-------------------------------");
		
		//输出所有的请求参数名称
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
	}

}