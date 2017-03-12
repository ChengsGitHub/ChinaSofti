<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <li class="active">信息详情</li>
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
      <h3>留言内容</h3>
      	<table class="table table-striped" width="500" border="0">
          <tr>
            <th width="139" scope="row">收件人姓名</th>
            <td>${message.EMP_NAME }</td>
          </tr>
          <tr>
            <th scope="row">发件时间</th>
            <td>${message.SEND_TIME }</td>
          </tr>
          <tr>
            <th scope="row">留言内容</th>
            <td style="word-break:break-all">${message.MESSAGE_CONT }</td>
          </tr>
          <tr>
            <th width="139" colspan="2" scope="row">&nbsp;</th>
          </tr>
        </table>
    </div>
  </div>
  
  <!--网页底部-->
  <jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
  
</div>
</body>
</html>