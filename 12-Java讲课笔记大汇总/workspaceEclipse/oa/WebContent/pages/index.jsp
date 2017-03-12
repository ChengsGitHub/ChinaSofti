<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE HTML>
<html>
<head>
<title>中软OA首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
 <meta name="description" content="">
 <meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/normalize.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sunburst.css" type="text/css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css" media="all" />

<!--slider-->
<script src="../js/modernizr.js"></script>
<!-- jQuery -->
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.js"></script>


<script src="../js/jquery.scrollToTop.min.js"></script>
      <script type="text/javascript">
	    $(function() {
	        $("#toTop").scrollToTop(1000);
	    });		
	  </script>
	  
	  
<script>
	window.jQuery || document.write('<script src="../js/libs/jquery-1.7.min.js">\x3C/script>')
</script>
<!-- FlexSlider -->
<script defer src="../js/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(function() {
		SyntaxHighlighter.all();
	});
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			start : function(slider) {
				$('body').removeClass('loading');
			}
		});
	});
</script>
</head>
<body>
<a href="#top" id="toTop"></a>
	<div class="wrap">
		<div class="top-hader">
			<div class="top-header-left">
				<p>ICSS中软OA	 &nbsp;&nbsp;&nbsp;电话:(86-411)84755574</p>
			</div>
			<div class="top-header-right">
				<p>
					<a href="#">用户名：<shiro:principal/></a> &nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/login.jsp">切换用户</a>&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath() %>/logout">退出登录</a>&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/emp1/read.action" >查看个人信息</a>
                        
				</p>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header">
			<div class="logo">
				<a href="index.jsp"><img src="../images/1.bmp" alt=""
					title="logo"></a>
			</div>
		</div>
	</div>
	<div class="menu-bg">
		<div class="wrap">
			<ul class="nav ">
				<li class="active"><a href="index.jsp">首页</a></li>
				<li><a href="<%=request.getContextPath()%>/schedule/query.action?scheduleEmpid=${emp1Id}">工作安排</a></li>
				<li><a href="<%=request.getContextPath()%>/Card/query.action">名片夹</a></li>
				<li><a href="<%=request.getContextPath()%>/pages/message/AddMessage.jsp">在线信息</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">个人文件夹<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<%=request.getContextPath()%>/pages/folderMana/QueryFolder.jsp">文件夹列表</a></li>
						<li><a href="<%=request.getContextPath()%>/pages/folderMana/QuerySharingDir.jsp">共享目录&nbsp;&nbsp;</a></li>
					</ul>
				</li>
				
				 <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
				<shiro:hasAnyRoles name="部门领导,行政负责人,超级用户">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">会议管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
	                    		
	                              <li><a href="<%=request.getContextPath()%>/meetingroom/query.action">会议室管理</a></li>
	                             	  
							      <li><a href="<%=request.getContextPath()%>/meetingorder/query.action">会议预约&nbsp;&nbsp;</a></li>
							      <li><a href="<%=request.getContextPath()%>/meetingorder/querymeeting.action">会议记录&nbsp;&nbsp;</a></li>
							      <shiro:hasAnyRoles name="行政负责人,超级用户">
							     	 <li><a href="<%=request.getContextPath()%>/device/query.action">设备管理&nbsp;&nbsp;</a></li>  
							      </shiro:hasAnyRoles>                      
	            	</ul>
				</li>
					
				</shiro:hasAnyRoles>
                    <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
					<shiro:hasAnyRoles name="系统管理员,超级用户">
						   <li class="dropdown">
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理<span class="caret"></span></a>
		                    	<ul class="dropdown-menu">
		                              <li><a href="<%=request.getContextPath()%>/dept/query.action">部门管理</a></li>
								      <li><a href="<%=request.getContextPath()%>/job/query.action">职务管理</a></li>
								      <li><a href="<%=request.getContextPath()%>/emp/query.action">员工管理</a></li>
								      <li><a href="<%=request.getContextPath()%>/bbs/queryByTime1.action">公告管理</a></li>                         
		                    	</ul>
		                    </li>
						
					</shiro:hasAnyRoles>
					  
                   
                    <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
						<shiro:hasAnyRoles name="行政负责人,超级用户">
							 <li class="dropdown">
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">资产管理<span class="caret"></span></a>
		                    	<ul class="dropdown-menu">
		                            <li><a href="<%=request.getContextPath()%>/offsup/query.action">资产管理</a></li>
		                            <li><a href="<%=request.getContextPath()%>/warehouse/query.action">库存管理</a></li>                        
		                    	</ul>
		                    </li>
						</shiro:hasAnyRoles>
                    
                    <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
						<shiro:hasAnyRoles name="外派专员,超级用户">
							<li class="dropdown">
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">外派人才<span class="caret"></span></a>
		                    	<ul class="dropdown-menu">
		                              <li><a href="<%=request.getContextPath()%>/expinf/query.action">外派人才信息管理</a></li>
								      <li><a href="<%=request.getContextPath()%>/assigncom/query.action">外派人才公司管理</a></li>                   
		                    	</ul>
		                    </li>
						
						</shiro:hasAnyRoles>
                  	 
                    
					  <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
						
							  <li class="dropdown">
			                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">车辆管理<span class="caret"></span></a>
			                    	<ul class="dropdown-menu">
			                    		
			                    		  <li><a href="<%=request.getContextPath()%>/busorder/query.action">车辆预约</a></li>
			                    		<shiro:hasAnyRoles name="车队队长,超级用户">  
			                              <li><a href="<%=request.getContextPath()%>/bus/query.action">车辆管理</a></li>                           
										  <li><a href="<%=request.getContextPath()%>/busrecord/query.action">用车记录</a></li>                         
			                    		</shiro:hasAnyRoles>
			                    	</ul>
		                   	  </li>
							  
						    
                    
				<li><a href="<%=request.getContextPath()%>/bbs/queryByTime1.action?source=1">公司公告</a></li>
				
				<li><a href="icssoa_android.apk">手机客户端</a></li>
			</ul>

			<div class="clear"></div>
		</div>
	</div>
	<div class="wrap">
		<div class="flexslider">
			<div class="flex-viewport"
				style="overflow: hidden; position: relative;">
				<ul class="slides"
					style="width: 100%; -webkit-transition: 0.6s; transition: 0.6s; -webkit-transform: translate3d(-5032px, 0, 0);">
					<li class="clone" style="width: 100%; float: left; display: block;">
						<img src="../images/slider1.jpg" alt="" />
					</li>
					<li style="width: 100%; float: left; display: block;" class="">
						<img src="../images/slider2.jpg" alt="" />
					</li>
					<li class="" style="width: 100%; float: left; display: block;">
						<img src="../images/slider3.jpg" alt="" />
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!--content-->
	<div class="content-bg">
		<div class="wrap">
			<div class="content">
				<div class="main">
					<h2 class="">welcome</h2>
					<div class="btn">
						<a href="<%=request.getContextPath()%>/emp1/read.action"><img src="../images/btn.png" alt="" />进入中软国际</a>
					</div>
				</div>
				<div class="section group">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/emp1/read.action"><img src="../images/pic1.jpg" alt="" /></a>
							<h4>个人信息</h4>
						</div>
						<p>查看、编辑你的个人信息，查看其他员工的信息。员工利用该功能可以维护系统允许个人维护的信息。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/emp1/read.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/schedule/query.action?scheduleEmpid=${emp1Id}"><img src="../images/pic3.jpg" alt="" /></a>
							<h4>工作安排</h4>
						</div>
						<p>为员工提供日程安排维护和查询功能，系统根据提示内容发布到该员工的日程安排中。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/schedule/query.action?scheduleEmpid=${emp1Id}"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/Card/query.action"><img src="../images/pic2.jpg" alt="" /></a>
							<h4>名片夹</h4>
						</div>
						<p>员工对自己的通讯录进行管理。可设置私有或共享。可直接点击发邮件。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/Card/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/pages/message/AddMessage.jsp"><img src="../images/pic4.jpg" alt="" /></a>
							<h4>在线信息</h4>
						</div>
						<p>利用系统短消息功能发送的通知。用户点击在线信息后，弹出新窗口显示该信息的详细内容。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/pages/message/AddMessage.jsp"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
				</div>
				<div class="section group">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/pages/folderMana/QueryFolder.jsp"><img src="../images/ser-pic6.jpg" alt="" /></a>
							<h4>个人文件夹</h4>
						</div>
						<p>在服务器上提供个人文件夹；文件夹大小由系统管理员设定；个人可将文件上传至个人文件夹中；个人文件夹可由使用者设置共享功能</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/pages/folderMana/QueryFolder.jsp"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					
					
					 <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
					<shiro:hasAnyRoles name="部门领导,行政负责人,超级用户">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/meetingorder/query.action"><img src="../images/ser-pic1.jpg" alt="" /></a>
							<h4>会议管理</h4>
						</div>
						<p>会议发起人能够查询到别的系统的会议室的安排情况，以便发起会议。由管理员对会议室进行管理，员工使用会议室时进行预约，由管理员统一安排。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/meetingorder/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					</shiro:hasAnyRoles>
				
				 <!-- 拥有以下任意一种角色的用户可以看到的内容 -->
					<shiro:hasAnyRoles name="系统管理员,超级用户">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/emp/query.action"><img src="../images/ser-pic4.jpg" alt="" /></a>
							<h4>系统管理</h4>
						</div>
						<p>系统管理员进行后台管理的模块，包括组织管理、安全控制。维护的是企业、公司的组织结构、角色划分、人员信息的功能。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/emp/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					
					</shiro:hasAnyRoles>
					
					<!-- 拥有以下任意一种角色的用户可以看到的内容 -->
						<shiro:hasAnyRoles name="行政负责人,超级用户">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/offsup/query.action"><img src="../images/ser-pic2.jpg" alt="" /></a>
							<h4>资产管理</h4>
						</div>
						<p>办公用品管理人员通过系统维护办公用品列表，库存管理，办公用品分配情况，生成办公用品消耗月报表</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/offsup/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
						</shiro:hasAnyRoles>
						
				</div>		
				<div class="section group">
				<!-- 拥有以下任意一种角色的用户可以看到的内容 -->
				<shiro:hasAnyRoles name="行政负责人,超级用户">
				
				
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/expinf/query.action"><img src="../images/ser-pic7.jpg" alt="" /></a>
							<h4>外派人才</h4>
						</div>
						<p>下属信息技术公司对外派人员和外派公司进行管理，需要建立人才库，外派合作企业库，管理外派人才详细信息。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/expinf/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					
					</shiro:hasAnyRoles>
					
			
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/busorder/query.action"><img src="../images/ser-pic5.jpg" alt="" /></a>
							<h4>车辆管理</h4>
						</div>
						<p>员工申请外出用车，行政部批准后，由车队主管安排车辆。</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/busorder/query.action"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<div class="grid box">
							<a href="<%=request.getContextPath()%>/bbs/queryByTime1.action?source=1"><img src="../images/ser-pic3.jpg" alt="" /></a>
							<h4>公司公告</h4>
						</div>
						<p>管理员发布系统公告，按时间顺序排列，可设置置顶公告，并给与手机客户端端提供数据访问接口</p>
						<div class="btn">
							<a href="<%=request.getContextPath()%>/bbs/queryByTime1.action?source=1"><img src="../images/btn.png" alt="" />read
								more</a>
						</div>
					</div>
					

				</div>
			</div>
		</div>
	</div>
	<!--end-content-->
	<div class="footer-bg">
		<div class="wrap">
			<div class="footer">
			    	<p><a href="http://www.dletc.com.cn/" style="color:#990; font-size:16px; line-height: 2.4em;">网站首页</a> | <a href="http://www.chinasofti.com/" target="_blank" style="color:#990; font-size:16px; line-height: 2.4em;">中软国际</a> | <a href="http://www.chinasofti.com/" target="_blank" style="color:#990; font-size:16px; line-height: 2.4em;">教育集团</a> | <a href="http://www.dletc.com.cn/ContactUs.html" style="color:#990; font-size:16px; line-height: 2.4em;">联系我们</a></p>
			  	    <p>大连中心：(86-411)84755574  沈阳中心：(86-24)22512500  公司传真：(86-411)84755568</p>
			  	    <p>地址：辽宁省大连市高新园区宏川东路20号黄泥川天地软件园金枫楼三层</p>
			</div>
		</div>
	</div>
	<div class="footer1-bg">
		<div class="wrap">
			<div class="footer1">
				<p class="w3-link">
					Copyright 2009-2014 <a href="http://dletc.com.cn">dletc.com.cn</a> all rights reserved
				</p>
				<p class="w3-link">
					 网站备案号 : 辽ICP备09019147号-1
				</p>
			</div>
		</div>
	</div>
	
	

</body>
</html>