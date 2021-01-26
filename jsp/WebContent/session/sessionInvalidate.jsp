<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현재 모든 세션 삭제 
	session.invalidate();
	
	response.sendRedirect("sessionTest1.jsp");
%>