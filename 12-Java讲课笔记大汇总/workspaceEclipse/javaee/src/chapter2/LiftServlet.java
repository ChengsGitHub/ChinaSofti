package chapter2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LiftServlet extends HttpServlet {
	
	private int i = 0;
	
	public LiftServlet() {
		System.out.println("创建Servlet对象");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init方法被调用");
		super.init();
	}
		
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service方法被调用");
		super.service(arg0, arg1);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		i ++;
		PrintWriter out = response.getWriter();
		out.println("i=" + i);
		
		System.out.println("doGet方法被调用");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("doPost方法被调用");
	}

	@Override
	public void destroy() {
		System.out.println("destory方法被调用，Servlet对象被销毁");
		super.destroy();
	}	

}