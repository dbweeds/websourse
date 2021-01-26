
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3><%=application.getAttribute("name") %>님의 정보(영역과 속성테스트)</h3>
<h4>Application 영역에 저장한 내용</h4>
<%--유효기간 : 컨테이너의 주기와 동일(컨테이너 종료시 소멸) --%>
<ul>
	<li>아이디 : <%=application.getAttribute("id") %></li>
	<li>이름 : <%=application.getAttribute("name") %></li>
	</ul>
	<h4>Session 영역에 저장한 내용</h4>
	<%--유효기간 : 브라우저가 연결을 하고 있는 동안 --%>
	<ul>
	<li>이메일 : <%=session.getAttribute("email") %></li>
	<li>주소 : <%=session.getAttribute("address") %></li>
	<li>전화번호 : <%=session.getAttribute("tel") %></li>
</ul>
</body>
</html>