<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<ul class="left_nav_menu">
      <shiro:hasAnyRoles name="部门领导,行政负责人,超级用户">
      <li><a href="<%=request.getContextPath()%>/meetingorder/query.action">会议预约</a></li>
      <li><a href="<%=request.getContextPath()%>/meetingorder/querymeeting.action">会议记录</a></li>
      </shiro:hasAnyRoles>
  
      <li><a href="<%=request.getContextPath()%>/meetingroom/query.action">会议室管理</a></li>
      <shiro:hasAnyRoles name="行政负责人,超级用户">
      <li><a href="<%=request.getContextPath()%>/device/query.action">设备管理</a></li>
       </shiro:hasAnyRoles>     
</ul>