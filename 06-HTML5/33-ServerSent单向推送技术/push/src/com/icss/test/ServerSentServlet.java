package com.icss.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerSentServlet
 */
@WebServlet("/ServerSentServlet")
public class ServerSentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		//设置响应类型和编码
		response.setContentType("text/event-stream;charset=utf-8");
		
		//设置禁止缓存
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		while (true) {
//			注意：响应的数据必须是data:xxxxx格式的，否则客户端获取不到
			out.write("data:这是来自服务器端的消息：" + new Date() + "\n\n");
			out.flush();
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}