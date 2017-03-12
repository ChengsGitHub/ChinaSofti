<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片夹分类</title>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
<link href="../css/myInfo.css" rel="stylesheet" type="text/css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1" />
	<STYLE type=text/css> 
	*{
		FONT-SIZE: 12px; COLOR: white
	}
	#logo {
		COLOR: red
	}
	#logo A {
		COLOR: white
	}
	FORM {
		MARGIN: 0px
	}
	body,td,th {
		font-size: 16px;
	}
	</STYLE>
<script type="text/javascript">
	//删除确认
	function del(cardId) {
		var flag = window.confirm("确定要删除此分类吗");
		if (flag) {
			location.href = "delete.action?cardId=" + cardId;
		}
	}
</script>
</head>
<body style="BACKGROUND-IMAGE: url(../images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
		<form id="form1">
	
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
					<ul class="left_nav_menu">
                          <li><a href="<%=request.getContextPath()%>/Personnelcard/queryByEmpId.action">我的名片夹</a></li>
                          <li><a href="<%=request.getContextPath()%>/Card/query.action">名片的分类</a></li>  
					</ul>
				</div>
		<!--右侧内容-->
		<div class="span9" style="min-height: 400px;">
	    
        	<p align="right"><a href="<%=request.getContextPath() %>/pages/card/AddCard.jsp" class="btn btn-large btn-primary">增加新员工</a></p>
        	
            <table class="table table-striped">
              <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>所属部门</th>
                <th>职务</th>
                <th>联系方式</th>
              </tr>
             <c:forEach items="${list }" var="Card">
              <tr>
                <td>${card.Group_ID }</td>
                <td>${card.Grou_NAME }</td>
                <td>
                	<a href="../Card/toUpdate.action?cardId=${card.Group_ID }">查看详细</a> 
                	<a href="javascript:del(${card.Group_ID });">删除</a>
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
</form>
</body>
</html>