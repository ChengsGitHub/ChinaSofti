package chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 获得session对象
		HttpSession session = request.getSession();
		
		out.println("sessionID=" + session.getId());
		out.println("最后请求的时间：" + new Date(session.getLastAccessedTime()));
		out.println("第一次请求的时间：" + new Date(session.getCreationTime()));
		out.println("是否是新会话：" + session.isNew());
		
		//立即销毁当前session
		session.invalidate();
	}

}