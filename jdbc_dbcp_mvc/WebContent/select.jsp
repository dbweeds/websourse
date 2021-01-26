<%@page import="domain.UserVO"%>
<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
//UserVO vo = (UserVO)request.getAttribute("user");
%>
<%@include file="header.jsp" %>
	<div class="container">
		<form action="" method="post">
			<div class="form-group">
				<label for="username">번호</label> <input type="text"
					class="form-control" name="no" id="no" readonly
					value="${user.no }">
			</div>
			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" name="username" id="username" readonly
					value="${user.username }">
			</div>

			<div class="form-group">
				<button type="button" class="btn btn-primary" id="update">수정</button>
				<button type="button" class="btn btn-danger" id="delete">삭제</button>
			</div>
		</form>
	</div>
	<%
		
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(function() {
			//수정 버튼을 클릭하면 update.jsp로 이동
			$("#update").click(function() {
				$("form").attr("action", "update.do");
				$("form").submit();
			});
			//삭제버튼을 클릭하면 deletePro.jsp
			$("#delete").click(function() {
				$("form").attr("action", "delete.do");
				$("form").submit();
			});
		});
	</script>
</body>
</html>