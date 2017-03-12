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
            $('#form1').attr('action','../assigncom/insert.action');
			$('#form1').submit();
        });
		
		//修改数据
		$('#updateBtn').click(function(e) {
            $('#form1').attr('action','../assigncom/update.action');
			$('#form1').submit();
        });
		
		//删除数据
		$('#deleteBtn').click(function(e) {
			var flag = window.confirm("确定要删除此职务吗");
			if (flag) {
				$('#form1').attr('action','../assigncom/delete.action');
				$('#form1').submit();
			}           
        });
		
		//清空表单
		$('#clearBtn').click(function(e) {
            $('#assigncomId').val('');
		    $('#assigncomName').val('');
		    $('#assigncomCon').val('');
		    $('#assigncomJobcategory').val('');
		    $('#assigncomJobs').val('');
		    $('#assigncomSal').val('');
		    $('#assigncomRemarks').val('');
		    $('input[name="ids"]').prop('checked',false);
			
			$('#updateBtn').prop('disabled',true);
		    $('#deleteBtn').prop('disabled',true);
        });
		
		//选择单选设置表单数据
		$('input[name="ids"]').click(function(e) {
			
           var assigncomId = $(this).parent().parent().find('td').eq(1).text();
		   var assigncomName = $(this).parent().parent().find('td').eq(2).text();
		   var assigncomCon = $(this).parent().parent().find('td').eq(3).text();
		   var assigncomJobcategory = $(this).parent().parent().find('td').eq(4).text();
		   var assigncomJobs = $(this).parent().parent().find('td').eq(5).text();
		   var assigncomSal = $(this).parent().parent().find('td').eq(6).text();
		   var assigncomRemarks = $(this).parent().parent().find('td').eq(7).text();
		   
		   $('#assigncomId').val($.trim(assigncomId));
		   $('#assigncomName').val($.trim(assigncomName));
		   $('#assigncomCon').val($.trim(assigncomCon));
		   $('#assigncomJobcategory').val($.trim(assigncomJobcategory));
		   $('#assigncomJobs').val($.trim(assigncomJobs));
		   $('#assigncomSal').val($.trim(assigncomSal));
		   $('#assigncomRemarks').val($.trim(assigncomRemarks));
		   
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
		<li><a href="#">外派人才管理</a><span class="divider">/</span></li>
		<li class="active">外派人才公司管理</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
      		<li><a href="<%=request.getContextPath() %>/expinf/query.action">外派人才信息</a></li>
		      <li><a href="<%=request.getContextPath() %>/assigncom/query.action">外派公司信息</a></li>
		</ul>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    		    
			<table class="table table-bordered">
              <tr>
                <th>选择</th>
                <th>外派公司编号</th>
                <th>外派公司名称</th>
                <th>联系人信息</th>
                <th>需求职务类别</th>
                <th>需求职务工种</th>
                <th>需求职务人月单价</th>
                <th>备注信息</th>
              </tr>
              <c:forEach items="${list }" var="assigncom">
              <tr>
                <td><input type="radio" name="ids"></td>
                <td>${assigncom.assigncomId }</td>
                <td>${assigncom.assigncomName }</td>
                <td>${assigncom.assigncomCon }</td>
                <td>${assigncom.assigncomJobcategory }</td>
                <td>${assigncom.assigncomJobs }</td>
                <td>${assigncom.assigncomSal }</td>
                <td>${assigncom.assigncomRemarks }</td>
              </tr>
              </c:forEach>
            </table>
            
            <!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
            
            <form id="form1" name="form1" method="post" action="">
           	  <table class="table table-bordered">
            	  <tr>
            	    <td>外派公司编号</td>
            	    <td><input type="text" name="assigncomId" id="assigncomId" readonly></td>
            	    <td>外派公司名称</td>
            	    <td><input type="text" name="assigncomName" id="assigncomName" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	  <tr>
            	    <td>联系人信息</td>
            	    <td><input type="text" name="assigncomCon" id="assigncomCon" datatype="*" errormsg="不能为空！"></td>
            	    <td>需求职务类别</td>
            	    <td><input type="text" name="assigncomJobcategory" id="assigncomJobcategory" datatype="*" errormsg="不能为空！" ></td>
            	  </tr>
            	  <tr>
            	    <td>需求职务工种</td>
            	    <td><input type="text" name="assigncomJobs" id="assigncomJobs" datatype="*" errormsg="不能为空！"></td>
            	    <td>需求职务人月单价</td>
            	    <td><input type="text" name="assigncomSal" id="assigncomSal" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	  <tr> 
            	    <td>备注信息</td>
            	    <td><input type="text" name="assigncomRemarks" id="assigncomRemarks"></td>
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