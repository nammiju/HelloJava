package co.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

// 서블릿이 되려면 HttpServlet을 상속받아야 함.
// init() -> service() 구현.
// 제어의 흐름을 개발자가 아니라 서블릿컨테이너가 흐름을 제어: 제어의 역전(IOC)
public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 인스턴스가 생성될 떄 한번만 실행.
		System.out.println("init() 호출.");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// FirstServlet 호출될때마다 실행
		System.out.println("service() 호출.");
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter(); // resp.getWriter(); 이거 쓰기 길어서 변수 선언ㅎ

		// 사용자 paramet 처리.
		String job = req.getParameter("job");
		EmpDAO dao = new EmpDAO();

		if (req.getMethod().equals("GET")) {
			// GET: 조회 시 사용.
			List<EmployeeVO> list = dao.emplist(new EmployeeVO(job));
			out.print("<table border='1'>"); // 출력스트림에는 태그를 작성해요~
			out.print("<tr><th>사원번호</th><th>이름</th><th>이메일</th><th>직무</th></tr>");
			for (EmployeeVO emp : list) {
				out.print("<tr><td>" + emp.getEmployeeId() + "</td>" //
						+ "<td>" + emp.getLastName() + "</td>" //
						+ "<td>" + emp.getEmail() + "</td>"//
						+ "<td>" + emp.getJobId() + "</td></tr>");
			}
			out.print("</table>");

		} else if (req.getMethod().equals("POST")) {
			// POST: 입력 시 사용.
			String empId = req.getParameter("emp_id");
			String lName = req.getParameter("Last_name");
			String email = req.getParameter("email");
			String hDate = req.getParameter("hire_date");

			dao.insertEmp(new EmployeeVO(Integer.parseInt(empId) // 사원번호가 int타입이라 형변환해줌
					, null // first_name
					, lName // last_name
					, email // email
					, hDate // hire_date
					, job // job_id
			));
			
			out.print("<script>alert('입력완료');</script>");
		}
	}
	
	

	@Override
	public void destroy() {
		System.out.println("destroy() 호출.");
	}
}
