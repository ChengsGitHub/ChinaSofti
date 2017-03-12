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
	//删除确认
	function del(borderId) {
		var flag = window.confirm("确定要删除此车辆吗？");
		if (flag) {
			location.href = "<%=request.getContextPath()%>/busorder/delete.action?borderId=" + borderId;
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
		<li><a href="#">车辆管理</a><span class="divider">/</span></li>
		<li><a href="#">车辆预约</a><span class="divider">/</span></li>
		<li class="active">用车申请列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/BusMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    
        <h3>申请列表</h3>	
        <form name="formord" method="post" action="<%=request.getContextPath() %>/busorder/query.action">
            <table width="90%" border="0" class="table table-striped">
              <tr>
                <th width="">预约编号</th>
                <th width="">申请人</th>
                <th width="">车辆类型</th>
                <th width="">用车时间</th>
                <th width="">用车理由</th>
                <th width="">预约状态</th>
                <th width="">操作</th>
              </tr>
             <c:forEach items="${list }" var="busorder">
              <tr>
                <td>${busorder.BORDER_ID }</td>
                <td>${busorder.EMP_NAME }</td>
                <td>${busorder.BORDER_TYPE }</td>
                <td><fmt:formatDate value="${busorder.USE_DATE }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${busorder.USE_REASON }</td>
                <td>
                <c:if test="${busorder.APRO_STATE==0}">未审批</c:if>
                <c:if test="${busorder.APRO_STATE==1}">批准</c:if>
                <c:if test="${busorder.APRO_STATE==2}">否决</c:if>
                </td>
                <td>
                	
                	<div class="btn-group">
									<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">
										操作
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<shiro:hasAnyRoles name="车队队长,超级用户">
										<li>
											<a  href="<%=request.getContextPath()%>/busorder/toApproval.action?borderId=${busorder.BORDER_ID}">审批</a>
										</li>
										</shiro:hasAnyRoles>
										<shiro:hasAnyRoles name="普通用户,超级用户">
										<li>
											<a  href="<%=request.getContextPath()%>/busorder/toUpdate.action?borderId=${busorder.BORDER_ID }">修改</a>
										</li>
										
										<li>
											<a href="javascript:del(${busorder.BORDER_ID });">删除</a>
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
			<p align="center"><a href="<%=request.getContextPath() %>/pages/bus/AddBusOrder.jsp" class="btn btn-large btn-primary">新建用车申请</a></p>
      </div>
	</div>
	<hr>
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>