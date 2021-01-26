<%@page import="domain.UserVO"%>
<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	UserDAO dao = new UserDAO();
	UserVO vo = dao.getUser(request.getParameter("no"));
%>
<%@include file="header.jsp" %>
<div class="container">
	<form action="updatePro.jsp" method="post">
	  <div class="form-group">
	    <label for="username">번호</label>
	    <input type="text" class="form-control" name="no" id="no" readonly value="<%=vo.getNo() %>" >
	  </div>
	  <div class="form-group">
	    <label for="username">이름</label>
	    <input type="text" class="form-control" name="username" id="username" readonly value="<%=vo.getUsername() %>">
	  </div>
	  <div class="form-group">
	    <label for="birthyear">태어난 해</label>
	    <input type="text" class="form-control" name="birthyear" id="birthyear" readonly value="<%=vo.getBirthyear() %>">
	  </div>
	  <div class="form-group">
	    <label for="addr">주소</label>
	    <input type="text" class="form-control" name="addr" id="addr" placeholder="변경주소를 입력하세요" required autofocus>
	  </div>
	  <div class="form-group">
	    <label for="mobile">전화번호</label>
	    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="변경 휴대폰 번호를 입력하세요" required autofocus>
	  </div>
	  <div class="form-group">
	  	<button type="submit" class="btn btn-primary">수정</button>
		<button type="button" class="btn btn-secondary">취소</button>
	  </div>
	</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".btn btn-secondary").click(function(){
			$("form").attr("action","index.jsp");
			$("form").submit();			
		})
	});
</script>
</body>
</html>