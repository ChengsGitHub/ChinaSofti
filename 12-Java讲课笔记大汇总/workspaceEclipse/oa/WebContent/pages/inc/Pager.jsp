<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<div class="pagination" style="text-align: center;">
	<ul>
		<li><a href="#">共${pager.recordCount }条数据，每页${pager.pageSize }条，共${pager.pageCount }页，当前是第${pager.pageNum }页</a></li>	
	</ul>
</div>
    
<div class="pagination pagination-centered">
	<ul>
		<li ${pager.pageNum==1?'class="disabled"':''}><a href="?pageNum=1">首页</a></li>
		<li ${pager.pageNum==1?'class="disabled"':''}><a href="?pageNum=${pager.pageNum-1 }">上页</a></li>
		<c:forEach begin="1" end="${pager.pageCount }" var="i">		  			
		  	<li ${pager.pageNum==i?'class="disabled"':''}><a href="?pageNum=${i}">${i}</a></li> 		  			
		</c:forEach>		
		<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?pageNum=${pager.pageNum+1 }">下页</a></li>
		<li ${pager.pageNum==pager.pageCount?'class="disabled"':''}><a href="?pageNum=${pager.pageCount }">末页</a></li>		
	</ul>
</div>
