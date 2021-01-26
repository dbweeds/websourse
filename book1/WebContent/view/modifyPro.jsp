<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));
	
	BookDAO dao = new BookDAO();
	if(dao.update(code, price)>0){
		%>
		<script>
			alert("수정에 성공하셨습니다.");
			location.href = "selectPro.jsp";
		</script>
		<%
	}else{
		%>
		<script>
			alert("수정에 실패하셨습니다.");
			location.href = "../index.jsp?tab=modify";
		</script>
		<%
	}
%>