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
<script type="text/javascript">
	$(document).ready(function(e) {
		
		//设置职务名称
		$.getJSON('../job/getJobJson.action',{jobId: $('#jobId').val() },function(data){
			$('#jobName').val(data.jobName);
		});
		
		//设置部门名称
		$.getJSON('../dept/getDeptJson.action',{deptId: $('#deptId').val() },function(data){
			$('#deptName').val(data.deptName);
		});			
		//设置角色Id
		$.getJSON('../role/getRoleJson.action',{roleId: $('#roleId').val() },function(data){
			$('#roleId').val(data.roleId);
		});			
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		
		//日历框
		$('#empBirthdate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		
		//选择部门模态窗口
		$('#deptBtn').click(function(){			
			popWin.showWin("600","500","选择部门","../dept/querySmall.action");				
		});

		//选择职务模态窗口
		$('#jobBtn').click(function(){			
			popWin.showWin("600","500","选择职务","../job/querySmall.action");		
		});
		//选择角色模态窗口
		$('#roleBtn').click(function(){			
			popWin.showWin("600","500","选择角色","../role/queryRoleSmall.action");	
			
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
		<li><a href="#">员工管理</a><span class="divider">/</span></li>
		<li class="active">员工详细信息</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>员工信息</h3>
              <form name="form1" id="form1" method="post" action="../emp/update.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工编号</td>
                    <td width="76%"><input type="text" name="empId" id="empId" readonly value="${emp.empId }"></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="empName" id="empName" value="${emp.empName }" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆用户名</td>
                    <td><input type="text" name="username" id="username" placeholder="员工登陆账号" value="${emp.username }" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆密码</td>
                    <td><input type="password" name="password" id="password" value="${emp.password }"  datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>性别</td>
                    <td>
                    	<select name="empSex">
                    		<option value="男" ${emp.empSex=='男'?'selected':'' }>男</option>
                    		<option value="女" ${emp.empSex=='女'?'selected':'' }>女</option>
                    	</select>
                    </td>
                  </tr>
                  <tr>
                    <td>出生日期</td>
                    <td><input type="text" name="empBirthdate" id="empBirthdate" value="<fmt:formatDate value="${emp.empBirthdate }"/>"></td>
                  </tr>
                  <tr>
                    <td>电子邮件</td>
                    <td><input type="text" name="empEmail" id="empEmail" value="${emp.empEmail }" datatype="e" errormsg="请正确填写email地址"></td>
                  </tr>
                  <tr>
                    <td>办公电话</td>
                    <td><input type="text" name="empPhone" id="empPhone" value="${emp.empPhone}"></td>
                  </tr>
                  <tr>
                    <td>移动电话</td>
                    <td><input type="text" name="empMobile" id="empMobile" value="${emp.empMobile }" datatype="m" errormsg="请正确填写移动电话"></td>
                  </tr>
                  <tr>
                    <td>住址</td>
                    <td><input type="text" name="empAddress" id="empAddress" placeholder="目前家庭详细住址" value="${emp.empAddress }"></td>
                  </tr>
                  <tr>
                    <td>个人介绍</td>
                    <td><textarea name="empInfo" rows="7" id="empInfo" style="width:100%;">${emp.empInfo }</textarea></td>
                  </tr>
                  <tr>
                    <td>所属部门</td>
                    <td><input type="text" name="deptName" id="deptName" datatype="*" errormsg="不能为空！">
                      <input type="hidden" name="deptId" id="deptId" value="${emp.deptId }">
                      <input type="button" name="button" id="deptBtn" value="选择部门" class="btn btn-primary"></td>
                  </tr>
                  <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName" datatype="*" errormsg="不能为空！">
                    <input type="hidden" name="jobId" id="jobId" value="${emp.jobId }">
                    <input type="button" name="button2" id="jobBtn" value="选择职务" class="btn btn-primary"></td>
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