<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	    
		//日历框
		$('#scheduleBedate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		$('#scheduleEndate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3,
			ajaxPost:true,
			callback:function(data){
				
				$.Showmsg("提交成功");
				
				setTimeout(function(){
						$.Hidemsg();
				},2000);				
			}		
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
		<li><a href="<%=request.getContextPath() %>/pages/work/index.jsp">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${empId}">工作安排</a><span class="divider">/</span></li>
		<li><a href="<%=request.getContextPath() %>/schedule/query.action?scheduleEmpid=${empId}">自己已安排工作</a><span class="divider">/</span></li>
		<li class="active">工作的详细信息</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		  <li><a href="<%=request.getContextPath() %>/readsch/query.action">读者设置</a></li>
		      <li><a href="<%=request.getContextPath() %>/readsch/query2.action">查看别人工作安排</a></li>
			</ul>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>个人工作安排详细信息</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath() %>/schedule/update.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">工作安排编号</td>
                    <td width="76%"><input type="text" name="scheduleId" id="scheduleId" readonly value="${schedule.scheduleId }"></td>
                 
                    <td width="76%"><input type="hidden" name="scheduleEmpid" id="scheduleEmpid" readonly value="${schedule.scheduleEmpid }"></td>
                  </tr>
                  <tr>
                    <td>工作安排发起人</td>
                    <td><input type="text" name="scheduleEmpname" id="scheduleEmpname" readonly value="${schedule.scheduleEmpname }" datatype="s1-20" errormsg="姓名必须是1到20个字符！"></td>
                  </tr>
                  <tr>
                    <td>工作安排</td>
                    <td><input type="text" name="scheduleSch" id="scheduleSch" value="${schedule.scheduleSch }" datatype="s1-20" errormsg="姓名必须是1到20个字符！"></td>
                  </tr>
                  <tr>
                    <td>所安排工作的起始时间</td>
                    <td><input type="text" name="scheduleBedate" id="scheduleBedate" value="<fmt:formatDate value="${schedule.scheduleBedate }"/>"></td>
                  </tr>
                  <tr>
                    <td>所安排工作的截止时间</td>
                    <td><input type="text" name="scheduleEndate" id="scheduleEndate" value="<fmt:formatDate value="${schedule.scheduleEndate }"/>"></td>
                  </tr>
                  <tr>
                    <td>安排工作备注</td>
                    <td><textarea name="scheduleRem" rows="7" id="scheduleRem" style="width:100%;">${schedule.scheduleRem }</textarea></td>
                  </tr>
                  </table>
                                             
                <input type="submit" value="保存工作安排信息" class="btn btn-primary btn-large">
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>