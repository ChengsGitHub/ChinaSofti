<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<ul class="left_nav_menu">
	<shiro:hasAnyRoles name="系统管理员,超级用户">
      <li><a href="<%=request.getContextPath()%>/dept/query.action">部门管理</a></li>
      <li><a href="<%=request.getContextPath()%>/job/query.action">职务管理</a></li>
      <li><a href="<%=request.getContextPath()%>/emp/query.action">员工管理</a></li>
      <li><a href="<%=request.getContextPath()%>/bbs/queryByTime1.action">公告管理</a></li>      
    </shiro:hasAnyRoles>
</ul>