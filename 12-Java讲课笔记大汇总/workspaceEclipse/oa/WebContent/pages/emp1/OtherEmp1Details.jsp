<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="../js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/popwin.js"></script>
</head>

<script type="text/javascript">
	function OtherSharingDic() {
		location.href="<%=request.getContextPath()%>/pages/folderMana/QueryOthersSharingDir.jsp?emp1Id=${param.emp1Id}" ;
	}

	$(document).ready(function(){
		
		$.getJSON('<%=request.getContextPath()%>/dept/getDeptJson.action',{deptId:${emp1.deptId}},function(data){
			$('#deptName').val(data.deptName);
		});
		
		$.getJSON('<%=request.getContextPath()%>/job/getJobJson.action',{jobId:${emp1.jobId}},function(data){
			$('#jobName').val(data.jobName);
		});
	});
</script>


<body>

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
		<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="/oa/pages/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li class="active">其他员工信息</li>    
		</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
	      <li><a href="<%=request.getContextPath()%>/emp1/read.action">维护个人信息</a></li>
	      <li><a href="<%=request.getContextPath()%>/pages/searchOtherEmp.jsp">查找员工</a></li>
	     	</ul>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>员工信息</h3>
              <form name="form1" method="post" action="">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工编号</td>
                    <td width="76%"><input type="text" name="emp1Id" id="emp1Id" readonly value="${emp1.emp1Id }"></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="emp1Name" id="emp1Name" readonly value="${emp1.emp1Name }"></td>
                  </tr>
                  <tr>
                    <td>性别</td>
                    	<td><input type="text" name="emp1Sex" id="emp1Sex" readonly value="${emp1.emp1Sex }"></td>           
                  </tr>
                  <tr>
                    <td>出生日期</td>
                    <td><input type="text" name="emp1Birthdate" id="emp1Birthdate" readonly value="<fmt:formatDate value="${emp1.emp1Birthdate }"/>"></td>
                  </tr>
                  <tr>
                    <td>电子邮件</td>
                    <td><input type="text" name="emp1Email" id="emp1Email" readonly value="${emp1.emp1Email }"></td>
                  </tr>
                  <tr>
                    <td>办公电话</td>
                    <td><input type="text" name="emp1Phone" id="emp1Phone" readonly value="${emp1.emp1Phone}"></td>
                  </tr>
                  <tr>
                    <td>移动电话</td>
                    <td><input type="text" name="emp1Mobile" id="emp1Mobile" readonly value="${emp1.emp1Mobile }"></td>
                  </tr>
                  <tr>
                    <td>住址</td>
                    <td><input type="text" name="emp1Address" id="emp1Address" readonly value="${emp1.emp1Address }"></td>
                  </tr>
                 <tr>
                    <td>个人介绍</td>
                    <td><textarea name="emp1Info" rows="7" id="emp1Info" style="width:100%;">${emp1.emp1Info }</textarea></td>
           
                  </tr>
                  <tr>
                    <td>所属部门</td>
                    <td><input type="text" name="deptName" id="deptName" readonly value=""></td>
                  </tr>
                  <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName" readonly value=""></td>
                    
                  </tr>
 
                </table>  
                <input type="button" value="查看共享目录" class="btn btn-primary btn-large" onclick="OtherSharingDic();">
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>