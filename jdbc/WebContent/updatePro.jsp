<%@page import="persistence.UserDAO"%>
<%@page import="domain.UserVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	UserVO vo = new UserVO();
	vo.setNo(Integer.parseInt(request.getParameter("no")));
	vo.setAddr(request.getParameter("addr"));
	vo.setMobile(request.getParameter("mobile"));
	UserDAO dao = new UserDAO();

	if(dao.updateUser(vo)>0){
		%>
		<script >
			alert("수정에 성공하셨습니다");
			location.href="index.jsp";
			</script>
		<%		
		/* response.sendRedirect("index.jsp"); */
	}else{
		%>
		<script >
			alert("수정에 실패하셨습니다");
			location.href="add.jsp";
		</script>
		<%
		/* response.sendRedirect("add.jsp"); */
	}
%>