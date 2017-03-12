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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
			
	$(document).ready(function(e) {
		
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		//增加数据
		$('#insertBtn').click(function(e) {
            $('#form1').attr('action','../job/insert.action');
			$('#form1').submit();
        });
		
		//修改数据
		$('#updateBtn').click(function(e) {
            $('#form1').attr('action','../job/update.action');
			$('#form1').submit();
        });
		
		//删除数据
		$('#deleteBtn').click(function(e) {
			var flag = window.confirm("确定要删除此职务吗");
			if (flag) {
				$('#form1').attr('action','../job/delete.action');
				$('#form1').submit();
			}           
        });
		
		//清空表单
		$('#clearBtn').click(function(e) {
            $('#jobId').val('');
		    $('#jobName').val('');
		    $('input[name="ids"]').prop('checked',false);
			$('#updateBtn').prop('disabled',true);
		    $('#deleteBtn').prop('disabled',true);
        });
		
		//选择单选设置表单数据
		$('input[name="ids"]').click(function(e) {
			
           var jobId = $(this).parent().parent().find('td').eq(1).text();
		   var jobName = $(this).parent().parent().find('td').eq(2).text();
		   
		   $('#jobId').val($.trim(jobId));
		   $('#jobName').val($.trim(jobName));
		   
		   $('#updateBtn').prop('disabled',false);
		   $('#deleteBtn').prop('disabled',false);
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
		<li><a href="#">职务管理</a><span class="divider">/</span></li>
		<li class="active">职务列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/SystemMenu.jsp"></jsp:include>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    		    
			<table class="table table-bordered">
              <tr>
                <th>选择</th>
                <th>职务编号</th>
                <th>职务名称</th>
              </tr>
              <c:forEach items="${list }" var="job">
              <tr>
                <td><input type="radio" name="ids"></td>
                <td>${job.jobId }</td>
                <td>${job.jobName }</td>
              </tr>
              </c:forEach>
            </table>
            
            <!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
            
            <form id="form1" name="form1" method="post" action="">
           	  <table class="table table-bordered">
            	  <tr>
            	    <td>职务编号</td>
            	    <td><input type="text" name="jobId" id="jobId" readonly></td>
            	    <td>职务名称</td>
            	    <td><input type="text" name="jobName" id="jobName" datatype="*" errormsg="不能为空"></td>
          	    </tr>
            	  <tr>
            	    <td colspan="4" style="text-align: center">
                    	<input type="button" name="button" id="insertBtn" value="增加" class="btn btn-primary">
                        <input type="button" name="button2" id="updateBtn" value="修改" class="btn btn-primary" disabled>
                        <input type="button" name="button3" id="deleteBtn" value="删除" class="btn btn-primary" disabled>
                        <input type="button" name="button4" id="clearBtn" value="清空" class="btn btn-primary">
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