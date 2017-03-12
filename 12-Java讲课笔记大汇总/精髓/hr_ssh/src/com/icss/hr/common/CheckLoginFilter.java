package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��֤�����Ƿ��½�� 
 */
public class CheckLoginFilter implements Filter {

	@Override
	public void destroy() {
				
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
				
		
		//��õ�ǰ�����ַ
		String uri = request.getRequestURI();
		System.out.println("����uri=" + uri);
		String path = request.getContextPath();
			
		//��½��֤
		if (!uri.equals(path + "/") 
				&& !uri.equals(path + "/login.jsp")
				&& !uri.startsWith(path + "/css")
				&& !uri.startsWith(path + "/img")
				&& !uri.startsWith(path + "/js") 
				&& !uri.equals(path + "/error.jsp")
				&& !uri.equals(path + "/admin/login.action")) {
			
			HttpSession session = request.getSession();
			
			if (session.getAttribute("adminName") == null) {
				response.sendRedirect(path + "/login.jsp");
				return;
			} else {
				Integer adminLevel = (Integer) session.getAttribute("adminLevel");
				
				if (uri.toLowerCase().indexOf("add") != -1 
						|| uri.toLowerCase().indexOf("update") != -1
						|| uri.toLowerCase().indexOf("delete") != -1) {
					
					if (adminLevel != 1) {
						response.sendRedirect(path + "/LoginMsg.jsp");
						return;
					}
					
				}
			}
		}
				
		//��������ִ��
		arg2.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
				
	}

}