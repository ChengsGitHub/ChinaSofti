package com.icss.hr.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类
 * 其他的Action继承这个基类直接获得对象 
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware,
		ServletContextAware {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext context;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;		
	}
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;		
	}
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
}