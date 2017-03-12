package chapter4;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获得ServletContext对象
		ServletContext context = this.getServletContext();
		
		String ip = (String) context.getAttribute("ip");
		System.out.println("ip=" + ip);

	}

}