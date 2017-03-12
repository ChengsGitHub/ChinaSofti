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
			
            $('#form1').attr('action','../offsup/insert.action');
			$('#form1').submit();
        });
		
		//导出Excel
		$('#exportBtn').click(function(e){
			$('#form2').attr('action','../offsup/exportExcel.action');
			$('#form2').submit();			
		});

		
		//修改数据
		$('#updateBtn').click(function(e) {
			
			$('#loss').val(${offsup.count});
            $('#form1').attr('action','../offsup/update.action');
			$('#form1').submit();
        });
		
		//删除数据
		$('#deleteBtn').click(function(e) {
			var flag = window.confirm("确定要删除此记录吗");
			if (flag) {
				$('#form1').attr('action','../offsup/delete.action');
				$('#form1').submit();
			}           
        });
		
		//清空表单
		$('#clearBtn').click(function(e) {
            $('#id').val('');
		    $('#name').val('');
		    $('#category').val('');
			$('#spec').val('');
			$('#price').val('');
			$('#count').val('');
			$('#loss').val('');
			$('#newcount').val('');
			$('#oldcount').val('');
		    $('input[name="ids"]').prop('checked',false);		
			$('#updateBtn').prop('disabled',true);
		    $('#deleteBtn').prop('disabled',true);
        });
		
		//选择单选设置表单数据
		$('input[name="ids"]').click(function(e) {
			
           var id = $(this).parent().parent().find('td').eq(1).text();
		   var name = $(this).parent().parent().find('td').eq(2).text();
		   var category = $(this).parent().parent().find('td').eq(3).text();
		   var spec = $(this).parent().parent().find('td').eq(4).text();
		   var price = $(this).parent().parent().find('td').eq(5).text();
		   var count = $(this).parent().parent().find('td').eq(6).text();
		   var loss = $(this).parent().parent().find('td').eq(7).text();
		   
		   $('#id').val($.trim(id));
		   $('#name').val($.trim(name));
		   $('#category').val($.trim(category));
		   $('#spec').val($.trim(spec));
		   $('#price').val($.trim(price));
		   $('#oldcount').val($.trim(count));
		   $('#newcount').val($.trim(count));
		   $('#loss').val($.trim(loss));
		   
		   $('#updateBtn').prop('disabled',false);
		   $('#deleteBtn').prop('disabled',false);
        });
		
		
		$('#newcount').blur(function(){
			
			var qty = parseInt($('#oldcount').val())-parseInt($('#newcount').val());
			
			qty =  parseInt($('#loss').val())+(qty>0?qty:0);
			
			$('#loss').val(qty);
			
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
                <th>资产编号</th>
                <th>资产名称</th>
                <th>资产类别</th>
                <th>资产规格</th>
                <th>资产单价</th>
                <th>资产数量</th>
                <th>资产消耗</th>
              </tr>
              <c:forEach items="${list }" var="offsup">
              <tr>
                <td><input type="radio" name="ids"></td>
                <td>${offsup.id }</td>
                <td>${offsup.name }</td>
                <td>${offsup.category}</td>
                <td>${offsup.spec}</td>
                <td>${offsup.price}</td>
                <td>${offsup.count}</td>
                <td>${offsup.loss}</td>
              </tr>
              </c:forEach>
            </table>
            
            <!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
            
            <form id="form1" name="form1" method="post" action="">
           	  <table class="table table-bordered table-striped">
            	  <tr>
            	    <td>资产编号</td>
            	    <td><input type="text" name="id" id="id" readonly></td>
            	    <td>资产名称</td>
            	    <td><input type="text" name="name" id="name" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	  <tr>
            	    <td>资产类别</td>
            	    <td><input type="text" name="category" id="category" datatype="*" errormsg="不能为空！"></td>
            	    <td>资产规格</td>
            	    <td><input type="text" name="spec" id="spec" datatype="*" errormsg="不能为空！"></td>
            	  </tr>
            	  <tr>
            	  	<td>资产单价</td>
            	  	<td><input type="text" name="price" id="price"></td>
            	  	<td>资产数量</td>
            	  	<td><input type="text" name="oldcount" id="oldcount" readonly ></td>
            	  </tr>
            	  <tr>
            	  	<td>资产消耗</td>
            	  	<td><input type="text" name="loss" id="loss" readonly ></td>
            	  	<td>资产新数量</td>
            	  	<td><input type="text" name="count" id="newcount" datatype="*" errormsg="不能为空！"></td>
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
			<form id="form2" name="form2" method="post" action="">
				<tr>	
					<td>
                        <input type="button" name="button4" id="exportBtn" value="导出报表" class="btn btn-primary">
                    </td>
                 </tr>
			 </form>      
	    </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>

</div>

</body>
</html>