<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	UserDAO dao = new UserDAO();		
	if(dao.deleteUser(request.getParameter("no"))>0){
		%>
		<script >
			alert("삭제에 성공하셨습니다");
			location.href="index.jsp";
			</script>
		<%		
		/* response.sendRedirect("index.jsp"); */
	}else{
		%>
		<script >
			alert("삭제에 실패하셨습니다");
			location.href="add.jsp";
		</script>
		<%
		/* response.sendRedirect("add.jsp"); */
	}
	
%>