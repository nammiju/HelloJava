package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {
	// 삭제.
	public void delete(int empId) {
		String sql = "delete from empl \r\n"//
				+ "where employee_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 업데이트.
	public void update(Employee emp) {
		String sql = "update empl \r\n"//
				+ "set email = ?, "//
				+ "    hire_date = ?, "//
				+ "    job_id = ? "//
				+ "where employee_id = ?"; // ?: 지금말고 나중에 값을 채워주겠다는 의미.
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql); // statement 객체와 달리 객체를 만들어줄때 이미 sql을 넣어서 쿼리를 실행시켜줌.
			psmt.setString(1, emp.getEmail());
			psmt.setString(2, emp.getHireDate());
			psmt.setString(3, emp.getJobId());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 입력.
	public void insert(Employee emp) {
		String sql = "insert into empl (employee_id, last_name, email, hire_date, job_id)\r\n" //
				+ "values ( " + emp.getEmployeeId() //
				+ " , '" + emp.getLastName() //
				+ "', '" + emp.getEmail() //
				+ "', '" + emp.getHireDate() //
				+ "', '" + emp.getJobId() + "')";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 조회.
	public List<Employee> search() {
		conn = getConnect();
		List<Employee> list = new ArrayList<>(); // 반환하기 위한 값의 형태.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empl");
			while (rs.next()) {
				list.add(new Employee(rs.getInt("employee_id") //
						, rs.getString("last_name") //
						, rs.getString("email") //
						, rs.getString("hire_date") //
						, rs.getString("job_id") //
				));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 한건만 반환.
	public Employee getEmp(int empId) {
		conn = getConnect();
		Employee emp = null;
		String sql = "select * from empl where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getInt("employee_id") //
						, rs.getString("last_name") //
						, rs.getString("email") //
						, rs.getString("hire_date") //
						, rs.getString("job_id") //
				);
			}

			System.out.println(empId + " 조회됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

}
