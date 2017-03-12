<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/popwin.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
	    
		//一行代码搞定，提交表单的时候会自动触发验证程序
		$('#form1').Validform({
			tiptype:3
		});

		//选择会议室模态窗口
		$('#orderRoomBtn').click(function(){			
			popWin.showWin("600","500","选择会议室","<%=request.getContextPath()%>/meetingroom/querySmall.action");				
		});
		
		$('#startTime').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d H:i:s'
		});
		
		$('#endTime').datetimepicker({		
			lang:'ch',
			timepicker:false,
			format:'Y-m-d H:i:s'
		});
		
		
		
	});	
</script>
</head>
<body>

<!-- 网页头部
  $.getJSON('<%=request.getContextPath()%>/meetingorder/getMeetingorderJson.action',{orderId:${meetingorder.orderId}},function(data){
			$('#startTime').val(data.startTime);
			$('#endTime').val(data.endTime);
		}); 
-->
<jsp:include page="/pages/inc/Header.jsp"></jsp:include>

<div class="container">

	<!--导航路径-->
	<ul class="breadcrumb">
		<li><a href="#">当前位置</a><span class="divider">：</span></li>
		<li><a href="#">中软OA系统</a><span class="divider">/</span></li>
		<li><a href="#">会议管理</a><span class="divider">/</span></li>
		<li><a href="#">会议预约</a><span class="divider">/</span></li>
		<li class="active">增加会议预约</li>    
	</ul>

	<div class="row">
	
		<div class="span4">
	    	<!-- 左侧导航菜单 -->
	    	<jsp:include page="/pages/inc/MeetingMenu.jsp"></jsp:include>
	    </div>
	    
	    <div class="span8" style="min-height: 400px;">
	    	<h3>请填写预约信息</h3>
              <form name="form1" id="form1" method="post" action="<%=request.getContextPath()%>/meetingorder/insert.action">
                <table width="100%" border="0" class="table table-striped">
                  <tr>
                    <td width="24%">预约编号</td>
                    <td width="76%"><input type="text" name="orderId" id="orderId" readonly ></td>
                  </tr>
                  <tr>
                    <td>会议名称</td>
                    <td><input type="text" name="mettingName" id="mettingName" placeholder="请输入会议名称" datatype="s3-18" errormsg="名称是3-18位字符！"></td>
                    
                  </tr>
                  <tr>
                    <td>预约人</td>
                    <td>
                    	<input type="text" name="emp1Name" id="emp1Name" value="${emp1Name }" readonly>
<!--                     	<input type="text" name="emp1Name" id="emp1Name" datatype="*" errormsg="不能为空！"> -->
<!--                     	<input type="hidden" name="empId" id="emp1Id"> -->
<!--                     	<input type="button" name="button" id="orderEmpBtn" value="查询" class="btn"> -->
                    </td>
                  </tr>
                  <tr>
                    <td>预约会议室</td>
                    <td>
                    	<input type="text" name="roomName" id="roomName" readonly datatype="*" errormsg="不能为空！">
                    	<input type="hidden" name="roomId" id="roomId">
                    	<input type="button" name="button" id="orderRoomBtn" value="查询" class="btn">
                    </td>
                  </tr>
                  <tr>
                    <td>出席人员</td>
                    <td>
                    	<input type="text" name="attendPeople" id="attendPeople" datatype="s" errormsg="必须输入字符！">
                    </td>
                  </tr>
                  <tr>
                    <td>出席人数</td>
                    <td>
                    	<input type="text" name="attendAmount" id="attendAmount" datatype="n" errormsg="必须输入数字！">
                    </td>
                  </tr>
                  <tr>
                    <td>开始时间</td>
                    <td><input type="text" name="startTime" id="startTime"  datatype="*" errormsg="请输入字符串！"></td>
                  </tr>
                  <tr>
                    <td>结束时间</td>
                    <td><input type="text" name="endTime" id="endTime"  datatype="*" errormsg="请输入字符串！"></td>
                  </tr>
                  <tr>
                    <td>预约设备</td>
                    <td>
                    	<textarea name="devName" rows="2" id="devName" style="width:100%;" placeholder="请填写要预约的设备和数量，格式：设备1*数量 ，设备2*数量" datatype="*" errormsg="必须输入内容！"></textarea>
                    </td>
                  </tr>
                  <tr>
                    <td>预约状态</td>
                    <td>
                    	<input type="text" name="aproState" id="aproState" value="未审批" readonly>
                    </td>
                  </tr>
               </table>
                <p align="center">
                <input type="submit" value="提交" class="btn btn-primary">
                <input type="button" value="取消" class="btn btn-primary" onclick="history.back();">
                </p>
          </form>

      </div>
	</div>
	
	<!-- 网页底部 -->
	<jsp:include page="/pages/inc/Footer.jsp"></jsp:include>
	
</div>

</body>
</html>