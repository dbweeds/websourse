<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String[] dinner = request.getParameterValues("dinner");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 저녁</title>
</head>
<body>
	<h3>오늘 먹을저녁</h3>
	<ul>
	<%
	for(String s:dinner){
		out.print("<li>"+s+"</li>");
	}
	%>
	</ul>
</body>
</html>