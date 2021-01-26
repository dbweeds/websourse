<%@page import="member.MemberDAO"%>
<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String current_password = request.getParameter("current_password");
	String new_password = request.getParameter("new_password");
	MemberVO vo = (MemberVO)session.getAttribute("login");
	MemberDAO dao = new MemberDAO();
	if(dao.isLogin(vo.getUserid(), current_password) != null){
		if(dao.modifyPw(vo.getUserid(), current_password, new_password) > 0){//로그인 작업 => 현재 정보를 session에 담기
			out.print("<script>alert('비밀번호가 변경 되었습니다.');</script>");
			session.removeAttribute("login");
			out.print("<script>location.href='loginForm.jsp';</script>");
		}else{
			out.print("<script>alert('비밀번호가 변경 실패하셨습니다.');</script>");
			out.print("<script>location.href='modifyForm.jsp';</script>");
		}
	}else{
		out.print("<script>alert('비밀번호가 틀리셨습니다.');</script>");
		out.print("<script>location.href='modifyForm.jsp';</script>");
	}
	//response.sendRedirect("loginForm.jsp");
	
%>