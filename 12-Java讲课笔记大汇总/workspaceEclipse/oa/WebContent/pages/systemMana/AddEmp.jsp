<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
	    
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
			popWin.showWin("600","500","选择部门","../../dept/querySmall.action");				
		});

		//选择职务模态窗口
		$('#jobBtn').click(function(){			
			popWin.showWin("600","500","选择职务","../../job/querySmall.action");										
		});
		//选择角色模态窗口
		$('#roleBtn').click(function(){			
			popWin.showWin("600","500","选择角色","../../role/queryRoleSmall.action");				
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
		<li class="active">增加新员工</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>请填写新员工信息</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath() %>/emp/insert.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">员工编号</td>
                    <td width="76%"><input type="text" name="empId" id="empId" readonly></td>
                  </tr>
                  <tr>
                    <td>姓名</td>
                    <td><input type="text" name="empName" id="empName" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆用户名</td>
                    <td><input type="text" name="username" id="username" placeholder="员工登陆账号" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>登陆密码</td>
                    <td><input type="password" name="password" id="password" datatype="*" errormsg="不能为空！"></td>
                  </tr>
                  <tr>
                    <td>性别</td>
                    <td>
                    	<select name="empSex">
                    		<option value="男">男</option>
                    		<option value="女">女</option>
                    	</select>
                    </td>
                  </tr>
                  <tr>
                    <td>出生日期</td>
                    <td><input type="text" name="empBirthdate" id="empBirthdate"></td>
                  </tr>
                  <tr>
                    <td>电子邮件</td>
                    <td><input type="text" name="empEmail" id="empEmail" datatype="e" errormsg="请正确填写email地址"></td>
                  </tr>
                  <tr>
                    <td>办公电话</td>
                    <td><input type="text" name="empPhone" id="empPhone"></td>
                  </tr>
                  <tr>
                    <td>移动电话</td>
                    <td><input type="text" name="empMobile" id="empMobile" datatype="m" errormsg="请正确填写移动电话"></td>
                  </tr>
                  <tr>
                    <td>住址</td>
                    <td><input type="text" name="empAddress" id="empAddress" placeholder="目前家庭详细住址"></td>
                  </tr>
                  <tr>
                    <td>个人介绍</td>
                    <td><textarea name="empInfo" rows="7" id="empInfo" style="width:100%;"></textarea></td>
                  </tr>
                  <tr>
                    <td>所属部门</td>
                    <td><input type="text" name="deptName" id="deptName" datatype="*" errormsg="不能为空！">
                      <input type="hidden" name="deptId" id="deptId">
                      <input type="button" name="button" id="deptBtn" value="选择部门" class="btn btn-primary"></td>
                  </tr>
                  <tr>
                    <td>职务</td>
                    <td><input type="text" name="jobName" id="jobName" datatype="*" errormsg="不能为空！">
                    <input type="hidden" name="jobId" id="jobId">
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