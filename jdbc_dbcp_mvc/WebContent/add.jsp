<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<div class="container">
	<form action="insert.do" method="post">
		<div class="form-group">
			<label for="username">이름</label> <input type="text"
				class="form-control" name="username" id="username"
				placeholder="이름을 입력하세요" autofocus required>
		</div>
		<div class="form-group">
			<label for="birthyear">태어난 해</label> <input type="text"
				class="form-control" name="birthyear" id="birthyear"
				placeholder="태어난 년도를 입력하세요" required>
		</div>
		<div class="form-group">
			<label for="addr">주소</label> <input type="text" class="form-control"
				name="addr" id="addr" placeholder="주소를 입력하세요" required>
		</div>
		<div class="form-group">
			<label for="mobile">전화번호</label> <input type="text"
				class="form-control" name="mobile" id="mobile"
				placeholder="휴대폰 번호를 입력하세요" required>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">입력</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</div>
	</form>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$(".btn.btn-primary").click(function() {
			let regName = /^[가-힣]{2,4}$/;
			let regBirthyear = /^\d{4}$/;
			let regAddr = /^[가-힣A-Za-z]{2}$/;
			let regMobile = /^\d{2,3}-\d{3,4}-\d{4}$/;
			
			if (!regName.test($("#username").val())) {
				alert("이름을 확인해주세요");
				$("#username").focus();
				return false;
			}
			if (!regBirthyear.test($("#birthyear").val())) {
				$("#birthyear").focus();
				alert("생년월일을 확인해주세요");
				return false;
			}
			if (!regAddr.test($("#addr").val())) {
				$("#addr").focus();
				alert("주소을 확인해주세요");
				return false;
			}
			if (!regMobile.test($("#mobile").val())) {
				$("#mobile").focus();
				alert("전화번호를 확인해주세요");
				return false;
			}
		});
	});
</script>
</body>
</html>