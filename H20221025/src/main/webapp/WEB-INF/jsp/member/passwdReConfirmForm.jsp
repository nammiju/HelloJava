<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>비밀번호 재발급</h3>
	<form action="./passwdReConfirm.do" method="post">
		ID: <input type="text" name="id"><br>
		
		<input id="submit" type="submit" value="임시비밀번호 전송">
		<input type="reset" value="초기화" class="button"><br>
	</form>
	
</body>
</html>