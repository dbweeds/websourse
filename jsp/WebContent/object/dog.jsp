<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String[] dogs=request.getParameterValues("dog");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선호도</title>
</head>
<body>
	<h3>사용자가 고른 강아지</h3>
	<ul>
		<%
		for (String s:dogs){	
		out.print("<li>"+s+"</li>");
		}
		%>
	</ul>
</body>
</html>