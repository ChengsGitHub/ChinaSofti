<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
正常内容1
<jsp:include page="/include4.jsp">
	<jsp:param name="width" value="300"/>
	<jsp:param name="color" value="pink"/>
</jsp:include>
正常内容2
<jsp:include page="/include4.jsp">
	<jsp:param name="width" value="600"/>
	<jsp:param name="color" value="orange"/>
</jsp:include>