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
		
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3	
		});
		//设置部门名称
		$.getJSON('../assigncom/getAssigncomJson.action',{assigncomId: $('#assigncomId').val() },function(data){
			$('#assigncomName').val(data.assigncomName);
		});	
		
		//选择部门模态窗口
		$('#assigncomBtn').click(function(){			
			popWin.showWin("600","500","选择部门","../assigncom/querySmall.action");				
		});
		
		//日历框
		$('#exphistoryBedate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
		$('#exphistoryEndate').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d'
		});
        
		//增加数据
		$('#insertBtn').click(function(e) {
            $('#form1').attr('action','../exphistory/insert.action');
			$('#form1').submit();
        });
		
		//修改数据
		$('#updateBtn').click(function(e) {
            $('#form1').attr('action','../exphistory/update.action');
			$('#form1').submit();
        });
		
		//删除数据
		$('#deleteBtn').click(function(e) {
			var flag = window.confirm("确定要删除这条记录吗");
			if (flag) {
				$('#form1').attr('action','../exphistory/delete.action');
				$('#form1').submit();
			}           
        });
		
		//清空表单
		$('#clearBtn').click(function(e) {
            $('#exphistoryId1').val('');
		    $('#exphistoryId2').val('');
		    $('#exphistoryCon').val('');
		    $('#exphistoryCom').val('');
		    $('#exphistoryBedate').val('');
		    $('#exphistoryEndate').val('');
		    $('#exphistorySal').val('');
		    $('#exphistoryRem').val('');
		    
		    $('input[name="ids"]').prop('checked',false);
			
			$('#updateBtn').prop('disabled',true);
		    $('#deleteBtn').prop('disabled',true);
        });
		
		//选择单选设置表单数据
		$('input[name="ids"]').click(function(e) {
			
           var exphistoryId1 = $(this).parent().parent().find('td').eq(1).text();
		   var exphistoryId2 = $(this).parent().parent().find('td').eq(2).text();
		   var exphistoryCon = $(this).parent().parent().find('td').eq(3).text();
		   var exphistoryCom = $(this).parent().parent().find('td').eq(4).text();
		   var exphistoryBedate = $(this).parent().parent().find('td').eq(5).text();
		   var exphistoryEndate = $(this).parent().parent().find('td').eq(6).text();
		   var exphistorySal = $(this).parent().parent().find('td').eq(7).text();
		   var exphistoryRem = $(this).parent().parent().find('td').eq(8).text();
		   
		   $('#exphistoryId1').val($.trim(exphistoryId1));
		   $('#exphistoryId2').val($.trim(exphistoryId2));
		   $('#exphistoryCon').val($.trim(exphistoryCon));
		   $('#exphistoryCom').val($.trim(exphistoryCom));
		   $('#exphistoryBedate').val($.trim(exphistoryBedate));
		   $('#exphistoryEndate').val($.trim(exphistoryEndate));
		   $('#exphistorySal').val($.trim(exphistorySal));
		   $('#exphistoryRem').val($.trim(exphistoryRem));
		   
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
		<li><a href="#">外派人才记录</a><span class="divider">/</span></li>
		<li class="active">外派人才记录</li>   
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
                <th>外派人才编号</th>
                <th>外派人才所去公司编号</th>
                <th>派遣状态</th>
                <th>外派人才所去公司</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>外派人才薪金</th>
                <th>备注</th>
              </tr>
              <c:forEach items="${list }" var="exphistory">
              <tr>
                <td><input type="radio" name="ids"></td>
                <td>${exphistory.exphistoryId1 }</td>
                <td>${exphistory.exphistoryId2 }</td>
                <td>${exphistory.exphistoryCon }</td>
                <td>${exphistory.exphistoryCom }</td>
                <td><fmt:formatDate value="${exphistory.exphistoryBedate }"/></td>
                <td><fmt:formatDate value="${exphistory.exphistoryEndate }"/></td>
                <td>${exphistory.exphistorySal }</td>
                <td>${exphistory.exphistoryRem }</td>
              </tr>
              </c:forEach>
            </table>
            
            <!-- 分页条 -->
			<jsp:include page="/pages/inc/Pager.jsp"></jsp:include>
            
            <form id="form1" name="form1" method="post" action="../exphistory/toUpdate.action">
           	  <table class="table table-bordered">
            	  <tr>
            	    <td>外派人才编号</td>
            	    <td><input type="text" name="exphistoryId1" id="exphistoryId1" readonly value="${exphistory.exphistoryId1 }"></td>
            	    <td>派遣状态</td>
            	    <td><!-- <input type="text" name="exphistoryCon" id="exphistoryCon"> -->
            	    <select  name="exphistoryCon" id="exphistoryCon" >
                    		
                    		<option>派遣中</option>
                    		<option>结束派遣</option>
                    		</select></td>
            	  </tr>
            	  <tr>
            	    <td>外派人才所去公司</td>
            	    <td><input type="text" name="exphistoryCom" id="exphistoryCom" datatype="*" errormsg="不能为空！"></td>
            	    <td><input type="hidden" name="exphistoryId2" id="exphistoryId2" value="${exphistory.exphistoryId2 }">
                      <input type="button" name="button" id="assigncomBtn" value="选择公司" class="btn btn-primary"></td>
            	    <!-- <td>外派人才所去公司</td>
            	    <td><input type="text" name="exphistoryCom" id="exphistoryCom"></td> -->
            	  </tr>
            	  <tr>
            	    <td>开始时间</td>
            	    <td><input type="text" name="exphistoryBedate" id="exphistoryBedate" value="<fmt:formatDate value="${exphistory.exphistoryBedate }"/>"></td>
            	    <td>结束时间</td>
            	    <td><input type="text" name="exphistoryEndate" id="exphistoryEndate" value="<fmt:formatDate value="${exphistory.exphistoryEndate }"/>"></td>
            	  </tr>
            	  <tr>
            	  	<td>外派人才薪金</td>
            	    <td><input type="text" name="exphistorySal" id="exphistorySal" datatype="*" errormsg="不能为空！"></td> 
            	    <td>备注</td>
            	    <td><input type="text" name="exphistoryRem" id="exphistoryRem"></td>
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