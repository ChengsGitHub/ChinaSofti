<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<script src="<%=request.getContextPath()%>/js/modernizr.js"></script>
<script>
	window.jQuery || document.write('<script src="../js/libs/jquery-1.7.min.js">\x3C/script>')
</script>

<!--网页内容-->

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
				<a><img src="<%=request.getContextPath() %>/images/1.bmp" alt=""
					title="logo"></a>
			</div>
		</div>
	</div>
	<div class="menu-bg">
		<div class="wrap">
			<ul class="nav ">
				<li class="active"><a href="<%=request.getContextPath()%>/pages/index.jsp">首页</a></li>
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
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">会议管理<span class="caret"></span></a>
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
				<li><a href="../pages/icssoa_android.apk">手机客户端</a></li>
			</ul>

			<div class="clear"></div>
		</div>
	</div>
