<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table border="1" width="100%">
    	<%for (int i = 1;i <= 20;i ++) { %>
    	<tr>
    		<td><%=i %></td>
    	</tr>
    	<%} %>
    </table>