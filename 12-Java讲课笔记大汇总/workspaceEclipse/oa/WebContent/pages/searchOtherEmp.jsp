<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form2').Validform({
			tiptype:3	
		});

		//选择部门模态窗口
		$('#deptBtn').click(function(){			
			popWin.showWin("600","500","选择部门","../dept/querySmall.action");				
		});

		//选择职务模态窗口
		$('#jobBtn').click(function(){			
			popWin.showWin("600","500","选择职务","../job/querySmall.action");										
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
	    <li><a href="/oa/pages/index.jsp">中软OA系统</a><span class="divider">/</span></li>
	    <li><a href="#">个人信息</a><span class="divider">/</span></li>
	    <li class="active">查找员工</li>
	  </ul>

	<div class="row">
		    <!--左侧导航菜单-->
		    <div class="span4">
		      <ul class="left_nav_menu">
		        <li><a href="<%=request.getContextPath()%>/emp1/read.action">维护个人信息</a></li>
		        <li><a href="<%=request.getContextPath()%>/pages/searchOtherEmp.jsp">查找员工</a></li>
		      </ul>
		    </div>
	    
	    <div class="span8" style="min-height: 400px;">
              <form name="form2" method="post" action="../emp1/queryByOther.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
        
                    <td><input type="text" name="deptName" id="deptName">
                      <input type="hidden" name="deptId" id="deptId">
                      <input type="button" name="button" id="deptBtn" value="选择部门" class="btn btn-primary"></td>
                  </tr>
                  <tr>
               
                    <td><input type="text" name="jobName" id="jobName">
                    <input type="hidden" name="jobId" id="jobId">
                    <input type="button" name="button2" id="jobBtn" value="选择职务" class="btn btn-primary"></td>
                  </tr>
                  <tr>
   
                    <td><input type="text" name="emp1Name" id="emp1Name" width="50%" placeholder="请输入员工姓名"></td>
                  </tr>
                </table>
                <input type="submit" value="搜索员工" class="btn btn-primary btn-large">
          </form>
      </div>
 </div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>