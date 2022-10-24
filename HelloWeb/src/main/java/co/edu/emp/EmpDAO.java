package co.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO { // DAO붙으면 데이터베이스를 처리하는 클래스라고 생각할 수 있다.

	// 입력
	public EmployeeVO insertEmp(EmployeeVO vo) {
		getConnect();
		
		// 만들어진 시퀀스 값을 알 수 있는 쿼리
		String seq = "select employees_seq.nextval from dual";
		
		String sql = "insert into empl(employee_id, first_name, last_name, email, hire_date, job_id)"
				+ "values (?, ?, ?, ?, ?, ?)";

		try {
			// 시퀀스를 가지고 올 쿼리 실행
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seqInt = rs.getInt(1); //첫번째 컬럼을 가지고 오겠습니다.
			}
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			// 쿼리를 완성시킴
			int r = psmt.executeUpdate(); // 쿼리실행.
			System.out.println(r + "건 입력됨.");
			
			// 새롭게 입력하게 된 사원번호.
			vo.setEmployeeId(seqInt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect();
		String sql = "delete from empl where employee_id = ?"; // employee_id 기준으로 한건만 삭제.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			int r = psmt.executeUpdate(); // 쿼리실행.
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update empl set first_name = ? , last_name =?, email=?, hire_date=?, job_id=? where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 목록
//	public List<EmployeeVO> empList() {
//		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
//		getConnect();
//		String sql = "select * from empl order by employee_id";
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery(); // rs에 쿼리 실행결과를 담아줌
//			while (rs.next()) { // rs의 값이 있으면 true, 없으면 false
//				int empId = rs.getInt("employee_id"); // 컬럼명을 적어주기
//				String fName = rs.getNString("first_name");
//				String lName = rs.getNString("last_name");
//				String email = rs.getNString("email");
//				String hDate = rs.getNString("hire_date");
//				String jobId = rs.getNString("job_id");
//
//				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
//				empList.add(emp);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return empList;
//	}

	// 상세조회
	public List<EmployeeVO> emplist(EmployeeVO vo) {
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl" //
				+" where nvl(employee_id, 0) = decode(?, 0, nvl(employee_id, 0), ?) "// ?값이 0이면 전체 출력하고 0이 아니면 ?값만 출력
				+" and	first_name like '%'||?||'%' "//
				+" and 	last_name like '%'||?||'%' "//
				+" and 	email like '%'||?||'%' "//
				+" and 	to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' "//
				+" and 	job_id = nvl(?, job_id) "//
				+"order by employee_id";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			
			rs = psmt.executeQuery(); // rs에 쿼리 실행결과를 담아줌
			while (rs.next()) { // rs의 값이 있으면 true, 없으면 false
				int empId = rs.getInt("employee_id"); // 컬럼명을 적어주기
				String fName = rs.getNString("first_name");
				String lName = rs.getNString("last_name");
				String email = rs.getNString("email");
				String hDate = rs.getNString("hire_date");
				String jobId = rs.getNString("job_id");

				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
