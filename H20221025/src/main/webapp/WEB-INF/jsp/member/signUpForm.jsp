<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="./signUp.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		이메일: <input type="email" name="email"><br>
		
		<input type="submit" value="회원가입"><br>
		<input type="reset" value="초기화"><br>
	</form>
</body>
</html>