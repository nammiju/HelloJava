<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>๐ L O G I N ๐</h3>
	<form action="./signIn.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		
		
		<input id="submit" type="submit" value="๋ก๊ทธ์ธ" class="button">
		<input type="reset" value="์ด๊ธฐํ" class="button"><br>
	</form>
	
	<a href="passwdReConfirmForm.do">๋น๋ฐ๋ฒํธ ์ฐพ๊ธฐ</a>
	<!-- passwdReConfirmForm.jsp : ์์ด๋๋ฅผ ์๋ ฅํ๊ณ  ์ฌ์ ์ก๋ฒํผ์ ๋๋ฅด๋ฉด ๋ฑ๋ก๋ ๋ฉ์ผ ์ฃผ์๋ก ๋ณ๊ฒฝ๋ ๋น๋ฐ๋ฒํธ๊ฐ ์ ์ก๋จ 
		 passwdReConfirmForm.do  : ์์ด๋๋ฅผ ๋ฐ์์ ์ด๋ฉ์ผ ์ ๋ณด๋ก ๋ฉ์ผ์ ๋ฐ์ก.
	-->
</body>
</html>