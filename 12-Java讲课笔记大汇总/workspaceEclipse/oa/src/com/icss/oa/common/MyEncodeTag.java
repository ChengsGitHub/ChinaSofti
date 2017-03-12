package com.icss.oa.common;

import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * �Զ����ǩ
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
			//��JSP�����ת��֮�������
			out.write(URLEncoder.encode(value, "utf-8"));
		} catch (Exception e) {			
			e.printStackTrace();
		}

		// ����ִֵ�б�ǩ֮�����ִ��JSP
		return EVAL_PAGE;
	}

}