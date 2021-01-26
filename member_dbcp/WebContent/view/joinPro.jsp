<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	MemberDAO dao = new MemberDAO();
	if(dao.join(userid, password, name, gender, email)>0){
		out.print("<script>alert('회원가입이 완료되셨습니다.');</script>");
		out.print("<script>location.href='loginForm.jsp';</script>");
	}else{
		out.print("<script>alert('회원가입이 실패하셨습니다');</script>");
		out.print("<script>location.href='joinForm.jsp';</script>");
	}
%>