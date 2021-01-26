<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	int birthyear= Integer.parseInt(request.getParameter("birthyear"));
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	//UserDAO 객체 생성 = db작업시키기
	UserDAO dao = new UserDAO();
	//7 결과에 따라 페이지 이동
	if(dao.insert(username, birthyear,addr,mobile)>0){	
		%>
		<script >
			alert("추가에 성공하셨습니다");
			location.href="index.jsp";
			</script>
		<%		
		/* response.sendRedirect("index.jsp"); */
	}else{
		%>
		<script >
			alert("추가에 실패하셨습니다");
			location.href="add.jsp";
		</script>
		<%
		/* response.sendRedirect("add.jsp"); */
	}
%>