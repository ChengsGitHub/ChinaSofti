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

import com.icss.hr.admin.vo.AdminVo;

public class CheckLoginFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		//���������������URL��ַ�������ǵ�½����
		if ( !uri.equals(contextPath + "/") 
				&& !uri.equals(contextPath + "/error.jsp")
				&& !uri.equals(contextPath + "/Login.jsp")
				&& !uri.equals(contextPath + "/LoginServlet")
				&& !uri.startsWith(contextPath + "/css")
				&& !uri.startsWith(contextPath + "/js")
				&& !uri.startsWith(contextPath + "/img") ) {
			
			HttpSession session = request.getSession();
			AdminVo vo = (AdminVo) session.getAttribute("adminVo");
			
			//�ж��Ƿ��½��
			if (vo == null) {
				response.sendRedirect(contextPath + "/Login.jsp");
				return;
			} else {				
				//�ж��Ƿ��ǹ���Ա����ɾ��
				if (uri.toLowerCase().indexOf("insert") != -1 
						|| uri.toLowerCase().indexOf("update") != -1
						|| uri.toLowerCase().indexOf("delete") != -1) {
					
					if (vo.getAdminLevel() != 1) {
						response.sendRedirect(contextPath + "/LevelError.jsp");
						return;
					}					
				}
			}
			
		}
		
		//��������ִ��
		arg2.doFilter(request, arg1);		
		
	}
}