<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	//删除确认
	function del(orderId) {
		var flag = window.confirm("确定要删除此会议吗");
		if (flag) {
			location.href = "delete.action?orderId=" + orderId;
		}
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
		<li><a href="#">会议预约</a><span class="divider">/</span></li>
		<li class="active">预约会议列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    
        <h3>预约列表</h3>	
        <form name="formord" method="post" action="<%=request.getContextPath() %>/meetingorder/query.action">
            <table width="90%" border="0" class="table table-striped">
              <tr>
                <th width="">预约编号</th>
                <th width="">会议名称</th>
                <th width="">预约人</th>
                <th width="">预约会议室</th>
                <th width="">预约状态</th>
                <th width="">操作</th>
              </tr>
             <c:forEach items="${list }" var="meetingorder">
              <tr>
                <td>${meetingorder.ORDER_ID }</td>
                <td>${meetingorder.METTING_NAME }</td>
                <td>${meetingorder.EMP_NAME }</td>
                <td>${meetingorder.ROOM_NAME }</td>
                <td>${meetingorder.APRO_STATE }</td>
                <td>
                	
                	<div class="btn-group">
									<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">
										操作
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
									<shiro:hasAnyRoles name="行政负责人,超级用户">
										<li>
											<a  href="<%=request.getContextPath()%>/meetingorder/toApproval.action?orderId=${meetingorder.ORDER_ID }">审批</a>
										</li>
									</shiro:hasAnyRoles>
									<shiro:hasAnyRoles name="部门领导,超级用户">
										<li>
											<a  href="<%=request.getContextPath()%>/meetingorder/toUpdate.action?orderId=${meetingorder.ORDER_ID }">修改</a>
										</li>
										
										<li>
											<a href="javascript:del(${meetingorder.ORDER_ID });">删除</a>
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
			<p align="center"><a href="<%=request.getContextPath() %>/pages/meeting/AddMeetingOrder.jsp" class="btn btn-large btn-primary">预约新会议</a></p>
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>