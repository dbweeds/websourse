<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<form action="four.jsp" method="get">
		<div>
	
			<input type="text" name = "num1" id="num1" />
			<select name="op" id="">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			<input type="text" name = "num2" id="num2" />
			<input type="submit" value="결과보기"/>
		</div>
	</form>
</body>
</html>