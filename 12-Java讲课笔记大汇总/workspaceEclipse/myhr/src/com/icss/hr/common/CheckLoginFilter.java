package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.admin.vo.AdminVo;

@WebFilter("/*")
public class CheckLoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// �����������Ӧ�ı���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();// �������URI
		System.out.println("����URI��" + uri);
		String root = request.getContextPath();// ��õ�ǰ��WEBӦ������

		// �������Ĳ�������URL��ַ����ô�����ǵ�½״̬
		if (!uri.startsWith(root + "/css") && !uri.startsWith(root + "/img")
				&& !uri.startsWith(root + "/js")
				&& !uri.equals(root + "/error.jsp")
				&& !uri.equals(root + "/Login.html")
				&& !uri.equals(root + "/LoginServlet")
				&& !uri.equals(root + "/")) {

			// ���session��Χ����Ϊ�գ���ʾû�е�½�����ض��򵽵�½ҳ
			HttpSession session = request.getSession();
			AdminVo vo = (AdminVo) session.getAttribute("admin");
			if (vo == null) {
				response.sendRedirect(root + "/Login.html");
				return;
			} else {
				if (uri.toLowerCase().indexOf("add") != -1
						|| uri.toLowerCase().indexOf("update") != -1
						|| uri.toLowerCase().indexOf("delete") != -1) {
					
					int level = vo.getAdminLevel();
					if (level != 1) {
						response.sendRedirect(root + "/LevelError.jsp");
						return;
					}					
				}

			}

		}

		// ��������ִ��
		chain.doFilter(arg0, arg1);
	}

}