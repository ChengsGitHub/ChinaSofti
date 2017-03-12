<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		
	});
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
		<li><a href="#">系统管理</a><span class="divider">/</span></li>
		<li><a href="#">部门管理</a><span class="divider">/</span></li>
		<li class="active">修改部门</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h4>修改部门</h4>
	        <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/dept/update.action">
			  <table class="table">			     
			    <tr>
			      <td height="24" align="center">部门名称</td>
			      <td height="24"><input type="text" name="deptName" value="${dept.deptName }" datatype="*" errormsg="不能为空！"></td>
			    </tr>
			    <tr>
			      <td height="24" align="center">部门地址</td>
			      <td height="24"><input type="text" name="deptLoc" value="${dept.deptLoc }"  datatype="*" errormsg="不能为空！"></td>
			    </tr>
			    <tr>
			      <td height="24" colspan="2" align="center">
			      	<input type="submit" name="button" id="button" value="提交" class="btn btn-primary">
	                <input type="button" name="button2" id="button2" value="取消" onclick="history.back();" class="btn btn-success">
			      	<input type="hidden" name="deptId" value="${dept.deptId }">  	
			      </td>
			    </tr>
			  </table>
			</form>
	    </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>