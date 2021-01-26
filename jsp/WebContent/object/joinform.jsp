<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String passwordcheck = request.getParameter("passwordcheck");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>가입하신 유저의 정보</h2>
<ul>
<li>아이디 : <%=id %></li>
<li>비밀번호 : <%=password %></li>
<li>비밀번호확인 : <%=passwordcheck %></li>
<li>이름 : <%=name %></li>
<li>성별 : <%=gender %></li>
<li>이메일 :<%=email %></li>
</ul>
</body>
</html>