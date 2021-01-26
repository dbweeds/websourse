<%@page import="domain.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp"%><!-- 합쳐서 컴파일하는것 -->
<%
//List<UserVO> list = (List<UserVO>)request.getAttribute("list");
%>
<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">이름</th>
				<th scope="col">태어난 해</th>
				<th scope="col">주소</th>
				<th scope="col">모바일</th>
			</tr>
		</thead>
		<tbody>
			<%
			//for (UserVO vo : list) {
			%>
			<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.no }</td>
				<td><a href="select.do?no=${vo.no }">${vo.username }</a></td>
				<td>${vo.birthyear }</td>
				<td>${vo.addr}</td>
				<td>${vo.mobile }</td>
			</tr>
			</c:forEach>
			<%
				//}
			%>
		</tbody>
	</table>
</div>
</body>
</html>