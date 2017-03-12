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

		// 设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();// 获得请求URI
		System.out.println("请求URI：" + uri);
		String root = request.getContextPath();// 获得当前的WEB应用名称

		// 如果请求的不是以下URL地址，那么必须是登陆状态
		if (!uri.startsWith(root + "/css") && !uri.startsWith(root + "/img")
				&& !uri.startsWith(root + "/js")
				&& !uri.equals(root + "/error.jsp")
				&& !uri.equals(root + "/Login.html")
				&& !uri.equals(root + "/LoginServlet")
				&& !uri.equals(root + "/")) {

			// 如果session范围数据为空，表示没有登陆过，重定向到登陆页
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

		// 继续向下执行
		chain.doFilter(arg0, arg1);
	}

}