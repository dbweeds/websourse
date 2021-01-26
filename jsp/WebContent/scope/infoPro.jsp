<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>infoPro.jsp</h1>
	<h2>username = <%=request.getParameter("username") %></h2>
	<h2>age = <%=request.getParameter("age") %>세</h2>
	<a href="infoResult.jsp">페이지 이동</a>
</body>
</html>