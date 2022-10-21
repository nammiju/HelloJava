package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

/**
 * Servlet implementation class AddMemberServ
 */
@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMemberServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// content 타입을 지정. html이라 지정해줘야지 태그가 오면 문자가 아니라 html의 태그라고 인식하고 처리해줌.
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("/addMemberServ 페이지입니다.");
//		String empId = request.getParameter("employee_id");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");

		System.out.println(fName + " "+lName + " " + email + " " + hireDate + " " + jobId);

		// DB 입력.
		EmpDAO dao = new EmpDAO();
		EmployeeVO emp = new EmployeeVO(0, fName, lName, email, hireDate, jobId);
		dao.insertEmp(emp);

		System.out.println("입력완료.");

		PrintWriter out = response.getWriter(); // 출력스트림. 사용자의 요청에 응답해서 결과를 보내주는 웹브라우저를 이용하여 어떤 정보를 보내주고 싶을 때 사용.
		out.print("<p>사원번호: " + emp.getEmployeeId() + "<br>"//
				+ "이름: " + emp.getFirstName() + "<br>"//
				+ "성: " + emp.getLastName() + "<br>"//
				+ "이메일: " + emp.getEmail() + "<br>"//
				+ "입사일: " + emp.getHireDate() + "<br>"//
				+ "직무: " + emp.getJobId() +"</p>"//
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
