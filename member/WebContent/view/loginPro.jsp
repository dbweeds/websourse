<%@page import="persistence.MemberDAO"%>
<%@page import="domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String userid=request.getParameter("userid");
	String password=request.getParameter("current_password");
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.isLogin(userid, password);
	if(vo !=null){//로그인 작업 => 현재 정보를 session에 담기
		session.setAttribute("login", vo);
	}else{
		out.print("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");
	}
	//response.sendRedirect("loginForm.jsp");
	out.print("<script>location.href='loginForm.jsp';</script>");

%>