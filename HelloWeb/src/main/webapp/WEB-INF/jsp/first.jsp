<%@page import="co.edu.emp.EmpDAO"%>
<%@page import="co.edu.emp.EmployeeVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>입사일자</th>
			<th>직무</th>
		</tr>
		<%
		String name = "홍길동";
		EmployeeVO emp = new EmployeeVO("IT_PROG"); // 컨트롤+스페이스 누르면 임포트해줌
		EmpDAO dao = new EmpDAO();

		List<EmployeeVO> list = dao.emplist(emp);
		for (EmployeeVO vo : list) {
		%>
		<tr>
			<td><%=vo.getEmployeeId()%></td>
			<td><%=vo.getLastName()%></td>
			<td><%=vo.getEmail()%></td>
			<td><%=vo.getHireDate()%></td>
			<td><%=vo.getJobId()%></td>
		</tr>
		
		<%
		}
		%>
	</table>
</body>
</html>