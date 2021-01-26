<%@page import="persistence.MemberDAO"%>
<%@page import="domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String current_password = request.getParameter("current_password");
	MemberDAO dao = new MemberDAO();
	if(dao.isLogin(userid, current_password) != null){	
		if(dao.leave(userid, current_password) > 0){//로그인 작업 => 현재 정보를 session에 담기
			out.print("<script>alert('삭제가 완료되셨습니다.');</script>");
			session.removeAttribute("login");
			out.print("<script>location.href='../index.jsp';</script>");
		}else{
			out.print("<script>alert('삭제에 실패하셨습니다.');</script>");
			out.print("<script>location.href='leaveForm.jsp';</script>");
		}
	}else{
		out.print("<script>alert('비밀번호가 틀리셨습니다.');</script>");
		out.print("<script>location.href='leaveForm.jsp';</script>");
	}
%>