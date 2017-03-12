package com.icss.oa.common;

import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义标签
 * @author Administrator
 *
 */
public class MyEncodeTag extends TagSupport {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doEndTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			//在JSP中输出转码之后的数据
			out.write(URLEncoder.encode(value, "utf-8"));
		} catch (Exception e) {			
			e.printStackTrace();
		}

		// 返回值执行标签之后继续执行JSP
		return EVAL_PAGE;
	}

}