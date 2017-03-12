<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/popwin.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(e) {
		//部门名称
		$.getJSON('<%=request.getContextPath()%>/dept/getDeptJson.action',{deptId:${emp1.deptId}},function(data){
			$('#deptName').val(data.deptName);			
		});
		//职务名称
		$.getJSON('<%=request.getContextPath()%>/job/getJobJson.action',{jobId:${emp1.jobId}},function(data){
			$('#jobName').val(data.jobName);			
		});
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		//日历框
		$('#emp1Birthdate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
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
		<li class="active">个人信息</li>    
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
	    	
              <form name="form1" id="form1" method="post" action="../emp1/update.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工编号</td>
                    <td width="76%"><input type="text" name="emp1Id" id="emp1Id" readonly value="${emp1.emp1Id }"></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="emp1Name" id="emp1Name" value="${emp1.emp1Name }" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆用户名</td>
                    <td><input type="text" name="username" id="username" placeholder="员工登陆账号" value="${emp1.username }" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆密码</td>
                    <td><input type="password" name="password" id="password" value="${emp1.password }" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>性别</td>
                    <td><input type="emp1Sex" name="emp1Sex" id="emp1Sex" readonly value="${emp1.emp1Sex }"></td>
                  </tr>
                  <tr>
                    <td>出生日期</td>
                    <td><input type="text" name="emp1Birthdate" id="emp1Birthdate" value="<fmt:formatDate value="${emp1.emp1Birthdate }"/>"></td>
                  </tr>
                  <tr>
                    <td>电子邮件</td>
                    <td><input type="text" name="emp1Email" id="emp1Email" value="${emp1.emp1Email }" datatype="e" errormsg="请正确填写email地址"></td>
                  </tr>
                  <tr>
                    <td>办公电话</td>
                    <td><input type="text" name="emp1Phone" id="emp1Phone" value="${emp1.emp1Phone}"></td>
                  </tr>
                  <tr>
                    <td>移动电话</td>
                    <td><input type="text" name="emp1Mobile" id="emp1Mobile" value="${emp1.emp1Mobile }" datatype="m" errormsg="请正确填写移动电话" ></td>
                  </tr>
                  <tr>
                    <td>住址</td>
                    <td><input type="text" name="emp1Address" id="emp1Address" placeholder="目前家庭详细住址" value="${emp1.emp1Address }"></td>
                  </tr>
                  <tr>
                    <td>个人介绍</td>
                    <td><textarea name="emp1Info" rows="7" id="emp1Info" style="width:100%;">${emp1.emp1Info }</textarea></td>
                  </tr>
                  <tr>
                    <td>所属部门</td>
                    <td><input type="text" name="deptName" id="deptName" readonly value="">                    	
                    	<input type="hidden" name="deptId" id="deptId"  value="${emp1.deptId }">
                    	</td>
                  </tr>
                  <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName" readonly value="">
                     	<input type="hidden" name="jobId" id="jobId" value="${emp1.jobId }"></td>
                  </tr>
                </table>
                <input type="submit" value="保存个人信息" class="btn btn-primary btn-large">
          </form>


      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>