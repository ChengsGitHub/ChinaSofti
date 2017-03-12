package chapter9;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter1 implements Filter {
	
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		System.out.println("过滤器1：请求的URI是：" + request.getRequestURI());	
		
		//继续向下执行，否则请求就会终止！！！
		arg2.doFilter(arg0, arg1);
	}

}