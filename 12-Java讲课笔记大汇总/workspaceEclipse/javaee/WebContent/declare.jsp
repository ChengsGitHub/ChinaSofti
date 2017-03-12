<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--以下程序是声明代码   --%>
    
<%!
	//声明属性
	private int i = 10;

	/*
		声明方法 
	*/
	public int m1(int a,int b) {
		return a + b;
	}
%>

i的值是：<%=i%>
5+3的结果是：<%=m1(5,3)%>

<%
	int i = 10 / 0;
%>	