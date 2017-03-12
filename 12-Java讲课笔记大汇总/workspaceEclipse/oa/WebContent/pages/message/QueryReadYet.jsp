<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.icss.oa.system.pojo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>中软OA系统-在线信息</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/myInfo.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/popwin.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
        
    });
	
	function del(mesId) {
		var bool = window.confirm("确定要删除此留言吗");
		if (bool) {
			
			location.href= "<%=request.getContextPath() %>/message/delete.action?messageId="+mesId+"&flag=4"
		}
	}
</script>

</head>
<body >

    

<!-- 网页头部 -->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>
<div class="container">
  <!--导航路径-->
  <ul class="breadcrumb">
    <li><a href="#"><font color="#000000">当前位置</font></a><span class="divider">：</span></li>
    <li><a href="#"><font color="#000000">在线信息</font></a><span class="divider">/</span></li>
    <li><a href="#"><font color="#000000">已收留言</font></a><span class="divider">/</span></li>
    <li class="active">已阅留言</li>
  </ul>
  
  <!--网页主体内容-->
  <div class="row" style="min-height:400px;"> 
    <!--左侧导航菜单-->
    <!--左侧导航菜单-->
    <div class="span4">
    	<ul class="left_nav_menu">
        	<li><a href="<%=request.getContextPath() %>/pages/message/AddMessage.jsp">新建留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryRead.action">收件箱</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryNoRead.action">未阅留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryReadYet.action">已阅留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/querySendYet.action">已发留言</a></li>
            <li><a href="<%=request.getContextPath() %>/message/queryNoSend.action">草稿箱</a></li>
        </ul>
    </div>
    <!--右侧内容-->
    <div class="span8">
      <h3>已阅留言</h3>
      <table class="table table-striped">
              <tr>
                <th><a href="<%=request.getContextPath() %>/message/queryReadYet.action?flag2=1">留言编号</a></th>
                <th><a href="<%=request.getContextPath() %>/message/queryReadYet.action?flag2=3">发件人id</a></th>
                <th><a href="<%=request.getContextPath() %>/message/queryReadYet.action?flag2=3">发件人姓名</a></th>
                <th><a href="<%=request.getContextPath() %>/message/queryReadYet.action">收件时间</a></th>
                <th>操作</th>
              </tr>
             <c:forEach items="${list }" var="message">
              <tr>
                <td>${message.MESSAGE_ID }</td>
                <td>${message.SEND_ID }</td>
                <td>${message.EMP_NAME }</td>
                <td>${message.SEND_TIME }</td>
                <td>               	
                	<div class="btn-group">	                		
                		<a href="#" class="btn dropdown-toggle" data-toggle="dropdown"><font color="#000000">操作</font><span class="caret"></span></a>                	
				        <ul class="dropdown-menu">
				            <li><a href="<%=request.getContextPath() %>/message/read.action?messageId=${message.MESSAGE_ID }"><font color="#000000">查看详细</font></a></li>
				            <li><a href="javascript:del(${message.MESSAGE_ID });"><font color="#000000">删除</font></a></li>
				        </ul>
			        </div>      	
                </td>
              </tr>
              </c:forEach>
            </table>
        
        	<!-- 分页条 -->
        	<div class="pagination" style="text-align: center;">
				<ul>
					<li><a href="#"><font color=#000>共${pager.recordCount }条数据，每页${pager.pageSize }条，共${pager.pageCount }页，当前是第${pager.pageNum }页</font></a></li>	
				</ul>
			</div>
			    
			<div class="pagination pagination-centered">
				<ul>
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="?pageNum=1&flag2=${param.flag2} ">首页</a></li>
					<li ${pager.pageNum==1?'class="disabled"':''}><a href="?pageNum=${pager.pageNum-1 }&flag2=${param.flag2}">上页</a></li>
					<c:forEach begin="1" end="${pager.pageCount }" var="i">		  			
					  	<li ${pager.pageNum==i?'class="disabled"':''}><a href="?pageNum=${i}&flag2=${param.flag2}">${i}</a></li> 		  			
					</c:forEach>		
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?pageNum=${pager.pageNum+1 }&flag2=${param.flag2}">下页</a></li>
					<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?pageNum=${pager.pageCount }&flag2=${param.flag2}">末页</a></li>		
				</ul>
			</div>						
			
    </div>
  </div>
  
  <!--网页底部-->
  <jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
  
</div>
</body>
</html>