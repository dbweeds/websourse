
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");	
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String error="내용을 입력하세요";
		//if
		//name.isEmpty()
		if(name!=null&&id!=null){
			//setAttribute("키",value)
			application.setAttribute("name", name);
			application.setAttribute("id", id);
		}else{
			out.print("내용을 입력하세요");
		}
	%>
	<h3><%=name %>님 반갑습니다<br/>
		<%=name %>님의 아이디는 <%=id %>입니다.
	</h3>
	<form action="attributeTest2.jsp" method="post">
		<ul>
			<li>Session 영역에 저장할 내용들</li>
		</ul>
		<div>
			<label for="">email주소</label>
			<input type="text" name="email" id="" />
		</div>
		<div>
			<label for="">집 주소</label>
			<input type="text" name="address" id="" />
		</div>
		<div>
			<label for="">전화번호</label>
			<input type="text" name="tel" id="" />
		</div>
		<div>
			<input type="submit" value="보내기" />
		</div>
	</form>

</body>
</html>