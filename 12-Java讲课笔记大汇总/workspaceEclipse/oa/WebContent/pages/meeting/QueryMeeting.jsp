<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript">
	
	
	//下载文件
	function download(orderId) {
		window.open("<%=request.getContextPath()%>/pages/meeting/new.html");
		location.href="<%=request.getContextPath()%>/meetingrecord/download.action?orderId=" + orderId;
	}

</script>
</head>
<body>

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
	<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">会议管理</a><span class="divider">/</span></li>
		<li class="active">会议记录</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    	
      
        <form name="formord" method="post" action="<%=request.getContextPath() %>/meetingorder/querymeeting.action">
            <table width="90%" border="0" class="table table-striped">
              <tr>
                <th width="">编号</th>
                <th width="">会议主题</th>
                <th width="">发起人</th>
                <th width="">会议室</th>
                <th width="">开始时间</th>
                <th width="">操作</th>
              </tr>
             <c:forEach items="${list }" var="meetingorder">
              <tr>
                <td>${meetingorder.ORDER_ID }</td>
                <td>${meetingorder.METTING_NAME }</td>
                <td>${meetingorder.EMP_NAME }</td>
                <td>${meetingorder.ROOM_NAME }</td>
                <td><fmt:formatDate value="${meetingorder.START_TIME }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                	<div class="btn-group">
									<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">
										操作
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
									<shiro:hasAnyRoles name="部门领导,行政负责人,超级用户">
										<li>
											<a  href="<%=request.getContextPath() %>/pages/meeting/UploadRecord.jsp?orderId=${meetingorder.ORDER_ID }">上传记录</a>
										</li>
									</shiro:hasAnyRoles>
									
									<shiro:hasAnyRoles name="部门领导,行政负责人,超级用户">
										<li>
											<a  href="javascript:download(${meetingorder.ORDER_ID });">查看记录</a>
										</li>
									</shiro:hasAnyRoles>
									</ul>
								</div>
                	
                	
                </td>
              </tr>
              </c:forEach>
            </table>
        </form>
        
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>					
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>