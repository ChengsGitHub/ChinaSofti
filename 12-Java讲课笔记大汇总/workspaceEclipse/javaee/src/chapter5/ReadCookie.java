package chapter5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			
			for (Cookie c : cookies) {
				System.out.println(c.getName() + "=" + c.getValue());
			}
			
		}
		
	}

}