<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자가 보낸 데이터 가져오기
	String userid = request.getParameter("userid");
	System.out.print(userid);
	MemberDAO dao = new MemberDAO();
	
	System.out.print(dao.checkId(userid));
	if(dao.checkId(userid)){
		out.print("true");
	}else{
		out.print("false");
	}
%>