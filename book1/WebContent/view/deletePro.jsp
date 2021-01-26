<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	BookDAO dao = new BookDAO();
	if(dao.delete(code)>0){
		%>
		<script>
			alert("삭제에 성공하셨습니다.");
			location.href = "selectPro.jsp";
		</script>
		<%
	}else{
		%>
		<script>
			alert("삭제에 실패하셨습니다.");
			location.href = "../index.jsp?tab=delete";
		</script>
		<%
	}
%>