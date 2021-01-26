<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int code = Integer.parseInt(request.getParameter("code"));
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	int price = Integer.parseInt(request.getParameter("price"));
	
	BookDAO dao = new BookDAO();
	if(dao.insert(code, title, writer, price)>0){
		%>
		<script >
			alert("추가에 성공하셨습니다");
			location.href="selectPro.jsp";
		</script>
		<%
		/* response.sendRedirect("index.jsp"); */
	}else{
		%>
		<script >
			alert("추가에 실패하셨습니다");
			location.href="../index.jsp?tab=insert";
		</script>
		<%
	}
%>