<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
    String op = request.getParameter("op");
    int value=0;
    switch(op){
	case "+":
    	value=num1+num2;
    	break;
    case "-":
    	value=num1-num2;
    	break;
    case "*":
    	value=num1*num2;
    	break;
    case "/":
    	value=num1/num2;
    	break;
    default:
    	break;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>계산결과</h2>
<h3><%=num1 %> <%=op %> <%=num2 %> = <%=value %>


</h3>
</body>
</html>