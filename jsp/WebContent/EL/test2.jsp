<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request 에 담아 놓은 값 가져오기</h3>
	<div><%=request.getAttribute("name") %></div>
	<div>${name}</div>
	<h3>request 에 담아 놓은 값 가져오기 - LoginDTO</h3>
	<%
		LoginDTO dto = (LoginDTO)request.getAttribute("login");
	%>
	<div>id : <%=dto.getUserid() %></div>
	<div>pwd : <%=dto.getUserpwd() %></div>
	<hr />
	<div>id : ${login.userid}</div>
	<div>pwd : ${login.userpwd}</div>
	<hr />
	<h3>Session 에 담아 놓은 값 가져오기</h3>
	<div><%=session.getAttribute("age") %></div>
	<div>${age}</div>
	<hr />
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		<c:forEach var = "vo" items="${list}">
			<tr>
				<td>${vo.userid}</td>
				<td>${vo.userpwd}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>