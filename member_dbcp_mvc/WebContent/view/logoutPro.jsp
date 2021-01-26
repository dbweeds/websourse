<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("login");
	
	out.print("<script>alert('로그아웃되셨습니다.');</script>");
	out.print("<script>location.href='loginForm.jsp';</script>");
	//response.sendRedirect("loginForm.jsp");
%>