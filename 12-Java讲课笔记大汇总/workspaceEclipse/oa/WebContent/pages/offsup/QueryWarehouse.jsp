<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.asserts.pojo.*" %>
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
			
            $('#form1').attr('action','../warehouse/insert.action');
			$('#form1').submit();
        });
		
			
		//修改数据
		$('#updateBtn').click(function(e) {
            $('#form1').attr('action','../warehouse/update.action');
			$('#form1').submit();
        });
		
		//删除数据
		$('#deleteBtn').click(function(e) {
			var flag = window.confirm("确定要删除此记录吗");
			if (flag) {
				$('#form1').attr('action','../warehouse/delete.action');
				$('#form1').submit();
			}           
        });
		
		//清空表单
		$('#clearBtn').click(function(e) {
            $('#warehouseId').val('');
		    $('#warehouseName').val('');
		    $('#warehouseType').val('');
		    $('#warehouseAmount').val('');
		    $('input[name="ids"]').prop('checked',false);
			
			$('#updateBtn').prop('disabled',true);
		    $('#deleteBtn').prop('disabled',true);
        });
		
		//选择单选设置表单数据
		$('input[name="ids"]').click(function(e) {
			
           var warehouseId = $(this).parent().parent().find('td').eq(1).text();
		   var warehouseName = $(this).parent().parent().find('td').eq(2).text();
		   var warehouseType = $(this).parent().parent().find('td').eq(3).text(); 
		   var warehouseAmount = $(this).parent().parent().find('td').eq(4).text(); 
		  
		  
		 
		   $('#warehouseId').val($.trim(warehouseId));
		   $('#warehouseName').val($.trim(warehouseName));
		   $('#warehouseType').val($.trim(warehouseType));
		   $('#warehouseAmount').val($.trim(warehouseAmount));
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
		<li><a href="#">资产管理</a><span class="divider">/</span></li>
		<li class="active">办公室用品列表</li>    
	</ul>

	<div class="row">
	
		<div class="span3">
	    	<!-- 左侧导航菜单 -->
	    	<ul class="left_nav_menu">
			      <li><a href="<%=request.getContextPath()%>/offsup/query.action">资产管理</a></li>
			      <li><a href="<%=request.getContextPath()%>/warehouse/query.action">库存管理</a></li>
			</ul>
	    </div>
	    	    	    
	    <div class="span9" style="min-height: 400px;">
	    		    
			<table class="table table-bordered table-striped">
              <tr>
                <th>选择</th>
                <th>库存编号</th>
                <th>库存名称</th>
                <th>库存类别</th>  
                <th>库存数量</th>         
              </tr>
              <c:forEach items="${list }" var="warehouse">
              <tr>
                <td><input type="radio" name="ids"></td>
                <td>${warehouse.warehouseId }</td>
                <td>${warehouse.warehouseName }</td>
                <td>${warehouse.warehouseType}</td>
                <td>${warehouse.warehouseAmount}</td>
              </tr>
              </c:forEach>
            </table>
            
            <!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
            
            <form id="form1" name="form1" method="post" action="">
           	  <table class="table table-bordered table-striped">
            	  <tr>
            	    <td>库存编号</td>
            	    <td><input type="text" name="warehouseId" id="warehouseId" readonly></td>
            	    <td>库存名称</td>
            	    <td><input type="text" name="warehouseName" id="warehouseName" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	  <tr>
            	    <td>库存类别</td>
            	    <td><input type="text" name="warehouseType" id="warehouseType" datatype="*" errormsg="不能为空！"></td>
            	    <td>库存数量</td>
            	    <td><input type="text" name="warehouseAmount" id="warehouseAmount" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	
            	  <tr>
            	    <td colspan="4" style="text-align: center">
                    	<input type="button" name="button" id="insertBtn" value="增加" class="btn btn-primary" >
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