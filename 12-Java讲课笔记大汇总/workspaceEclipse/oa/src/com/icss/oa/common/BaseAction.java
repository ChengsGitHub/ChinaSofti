package com.icss.oa.common;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * Action»ùÀà
 * @author Administrator
 *
 */
public class BaseAction implements ServletRequestAware, ServletResponseAware,
		ServletContextAware{
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
		
	protected ServletContext context;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}	
	
}