package chapter12;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义标签类
 * 
 */
public class ShowTxtTag extends TagSupport {

	private String txt;

	private String color = "#000000";

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();

		try {
			out.println("<h1 style=color:" + this.color + ">" + this.txt + "</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 执行标签后，继续向下执行JSP其他内容
		return EVAL_PAGE;
	}

}