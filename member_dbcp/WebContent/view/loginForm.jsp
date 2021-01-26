<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%
	MemberVO vo = (MemberVO)session.getAttribute("login");
	if(vo == null){
%>
<form class="form-signin" name="loginform" action="loginPro.jsp" method="post">
  <div class="form-label-group">
    <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
    <label for="userid">아이디</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="current_password" name="current_password" class="form-control" placeholder="Password" required>
    <label for="pass">비밀번호</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
</form>
<% }else{//로그인 성공%>
	<script>
		var name = '<%=vo.getName()%>';
	</script>
	<script src="../js/menu.js"></script>
<% 	
	}
%>
<script src="../js/command.js"></script>
<%@ include file="../layout/footer.jsp" %>