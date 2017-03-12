<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片夹分类</title>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../css/myInfo.css" rel="stylesheet" type="text/css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
	
<script type="text/javascript">
	//删除确认
	function del(groupId) {
		var flag = window.confirm("确定要删除此分类吗");
		if (flag) {
			location.href = "delete.action?groupId=" + groupId;
		}
	}
</script>
</head>
<body >
	
	
	<!--网页内容-->
	<jsp:include page="/pages/inc/Header.jsp"></jsp:include>
	<div class="container">
	
	  <!--导航路径-->
	  <ul class="breadcrumb">
	    <li><a href="#">当前位置</a><span class="divider">：</span></li>
	    <li><a href="#">中软OA系统</a><span class="divider">/</span></li>
	    <li><a href="#">名片夹</a><span class="divider">/</span></li>
	    <li class="active">名片夹分类</li>
	  </ul>
	  
	  <!--网页主体内容-->
		<div class="row" style="min-height:400px;"> 
				<!--左侧导航菜单-->
				<div class="span3">
					<br>
					<ul class="left_nav_menu">
						<li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                        <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
					
					</ul>
				</div>
		<!--右侧内容-->
		<div class="span9" style="min-height: 400px;">
		
			<form name="form1" id="form1" action="<%=request.getContextPath() %>/Personnelcard/queryByCondition.action" method="post">
	        	<input type="text" name="cardName" id="cardName" placeholder="请输入员工姓名关键字" value="${Personnelcard.cardName }">
	        	<input type="submit" value="检索好友" class="btn btn-primary">
	        	<input type="hidden" name="pageNum" id="pageNum" value="${pager.pageNum }">
	        </form> 
	    
        	<p align="right"><a href="<%=request.getContextPath() %>/pages/card/AddCard.jsp" class="btn btn-large btn-primary">增加新的分类</a></p>
        	
            <table class="table table-striped">
              <tr>
                <th>组号</th>
                <th>分类名称</th>
                <th>操作</th>
              </tr>
              <c:forEach items="${list }" var="Card">
              <tr>
                <td>${Card.groupId }</td>
                <td>${Card.grouName }</td>
                <td>               	
                	<div class="btn-group">	                		
                		<a href="#" class="btn dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></a>                	
				        <ul class="dropdown-menu">
				            <li><a href="../Personnelcard/query.action?groupId=${Card.groupId }">查看好友</a></li>
				            <li><a href="../Card/toUpdate.action?groupId=${Card.groupId }">修改</a></li>
				            <li><a href="javascript:del(${Card.groupId });">删除</a></li>
				        </ul>
			        </div>      	
                </td>
              </tr>
              </c:forEach>
            </table>
        	<!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>					
	
		</div>
	  </div>
	  
	  <!--网页底部-->
		<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
</div>

</body>
</html>