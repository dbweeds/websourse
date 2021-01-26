<%@page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--User user = new User(); --%>
<%--id >클래스 변수명 , --%>
	<jsp:useBean id="user" class="exam.User"/>
<h1>
<%-- user.getName() --%>
<%-- name > 클래스변수명, property >클래스 안의 변수명--%>
	<jsp:setProperty property="name" name="user" value="홍길동"/>
	<jsp:getProperty property="name" name="user"/>
</h1>
</body>
</html>