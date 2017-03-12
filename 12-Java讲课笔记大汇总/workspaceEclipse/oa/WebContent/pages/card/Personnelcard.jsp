<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
	<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">名片夹分类</a><span class="divider">/</span></li>
		<li class="active">我的名片夹</li>    
	</ul>

	<div class="row">
	
		
	    	<!--左侧导航菜单-->
				<div class="span3">
					<ul class="left_nav_menu">
                          <li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                          <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
					</ul>
				</div>
	  
	    	    	    
	    <div class="span9" style="min-height: 400px;">
        	
            <table class="table table-striped">
              <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>部门</th>
                <th>职务</th>
                <th>具体操作</th>
              </tr>
              <tr>
                <td>${personnelcard.cardName }</td>
                <td>${personnelcard.sex }</td>
                <td>${personnelcard.deptname }</td>
                <td>${personnelcard.position }</td>
                <td>
                	<a href="../Personnelcard/toUpdate.action?cardId=${personnelcard.cardId }">查看详细</a> 
                </td>
              </tr>
              <tr>
                <th>移动电话</th>
                <th>固定电话</th>
                <th>邮箱地址</th>
                <th>住址</th>
              </tr>    
              <tr>
                <td>${personnelcard.mobilephone }</td>
                <td>${personnelcard.telephone }</td>
                <td>${personnelcard.mailaddr }</td>
                <td>${personnelcard.addr }</td>
              </tr>      
            </table>
        
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>					
			
      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>