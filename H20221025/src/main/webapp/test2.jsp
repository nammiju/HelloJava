<%@page import="java.util.List"%>
<%@page import="co.edu.board.BoardVO"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language (EL) JSP Standard Tag Library(JSTL)</title>
</head>
<body>
	<%
		String info = (String) application.getAttribute("info");
		System.out.println(info);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = (List<BoardVO>) dao.pageList(1);
		
		request.setAttribute("bList", list);
	%>
	
	<!-- 간단한 표현식 -->
	<p>${info }</p>
	<p>${"HongKildong" eq "Hong"}</p> <!-- 문자열비교, true/false 반환 -->
	<p>${3>2}</p>
	<p>${55+22 }</p> <!-- 간단한 계산도 가능 -->
	<p>${param.page }</p> <!-- 파라메터 값도 읽어옴 -->
	<!-- <p>app: ${applicationScope }</p>  -->
	<p>app: ${sessionScope }</p>
	<p>app: ${sessionScope.mysession }</p>
	<p>app: ${sessionScope.mysession eq sessionScope.yoursession}</p> <!-- false -->
	<p>app: ${sessionScope.mysession eq null}</p> <!-- false -->
	<p>app: ${sessionScope.hissession eq null}</p> <!-- true -->

	<c:set var="myName" value="홍길동"></c:set> <!-- 변수명과 변수의 내용을 담아줌 -->
	<p>${myName }</p>
	<c:out value="${myName }"></c:out>

	<c:if test="${info eq 'hong' }"> <!-- 조건문 -->
		<p>같습니다</p>
	</c:if>
	
	<c:if test="${!info2 }"> <!-- info2의 값이 null이 아니라면 -->
		<p> 값이 없습니다. </p>
	</c:if> 
	
	<c:set var="score" value="75"></c:set>
	
	<c:choose> 
		<c:when test="${score > 90 }"><p>A학점</p></c:when> <!-- if -->
		<c:when test="${score > 80 }"><p>B학점</p></c:when> <!-- else if -->
		<c:when test="${score > 70 }"><p>C학점</p></c:when>
		<c:otherwise><p>불합격</p></c:otherwise> <!-- else -->
	</c:choose>

	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${i }</p>
	</c:forEach>
	
	<c:forEach var="board" items="${bList }">
		<p>글번호: ${board.boardNo }, 제목: ${board.title }, 작성자: ${board.writer }</p>
	</c:forEach>
	
	
</body>
</html>