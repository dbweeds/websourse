
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");
	String age = request.getParameter("age");
	
	if(!id.isEmpty() && !age.isEmpty()){
		out.print("true");
	}else{
		out.print("false");
	}
%>