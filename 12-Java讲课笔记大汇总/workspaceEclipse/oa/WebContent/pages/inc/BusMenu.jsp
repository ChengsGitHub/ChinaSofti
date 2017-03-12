<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<ul class="left_nav_menu">
		<shiro:hasAnyRoles name="车队队长,超级用户">
	      <li><a href="<%=request.getContextPath()%>/bus/query.action">车辆管理</a></li>
	     </shiro:hasAnyRoles>  
	      <li><a href="<%=request.getContextPath()%>/busorder/query.action">车辆预约</a></li>
	    <shiro:hasAnyRoles name="车队队长,超级用户">
	      <li><a href="<%=request.getContextPath()%>/busrecord/query.action">用车记录</a></li>
        </shiro:hasAnyRoles>         
</ul>