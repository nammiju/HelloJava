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
	
	<a href="passwdReConfirmForm.do">비밀번호 찾기</a>
	<!-- passwdReConfirmForm.jsp : 아이디를 입력하고 재전송버튼을 누르면 등록된 메일 주소로 변경된 비밀번호가 전송됨 
		 passwdReConfirmForm.do  : 아이디를 받아서 이메일 정보로 메일을 발송.
	-->
</body>
</html>