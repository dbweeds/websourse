<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//특적 세션 삭제 => removeAttribute()
	session.removeAttribute("name");
	
	response.sendRedirect("sessionTest1.jsp");
%>