<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>🔒 L O G I N 🔒</h3>
	<form action="./signIn.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		
		
		<input id="submit" type="submit" value="로그인" class="button">
		<input type="reset" value="초기화" class="button"><br>
	
	</form>
</body>
</html>