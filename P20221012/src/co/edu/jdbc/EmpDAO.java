package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	public static void main(String[] args) {
		update();
	}

	public static void update() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			stmt = conn.createStatement();
			int r = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id= 500"); // insert, delete, update
			System.out.println(r + "건 업데이트됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상 처리 되더라도 반드시 실행할 구문 넣어줌.
			try {
//				rs.close();
				stmt.close();
				conn.close(); // connection 객체를 close 하지 않으면 oracle객체가 실행이 되더라도 접속이 안될 수 있음.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from empl where employee_id=700"); // insert, delete, update
			System.out.println(r + "건 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상 처리 되더라도 반드시 실행할 구문 넣어줌.
			try {
//				rs.close();
				stmt.close();
				conn.close(); // connection 객체를 close 하지 않으면 oracle객체가 실행이 되더라도 접속이 안될 수 있음.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void search() {
		// jdbc driver 로드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// url, 계정, 패스워스, connection 객체 생성

			stmt = conn.createStatement(); // connection 개체를 통해 실행할 쿼리문을 전송하고 결과과를 받아오도록하는 Statement 객체.
			rs = stmt.executeQuery("select * from empl order by employee_id"); // 쿼리문 결과를 ResultSet에 담음 employees테이블에서
			// Set 컬렉션

			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id"));
				System.out.println("이름: " + rs.getString("first_name"));
				System.out.println("급여: " + rs.getInt("salary"));
				System.out.println("========================================");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외 발생, 정상 처리 되더라도 반드시 실행할 구문 넣어줌.
			try {
				rs.close();
				stmt.close();
				conn.close(); // connection 객체를 close 하지 않으면 oracle객체가 실행이 되더라도 접속이 안될 수 있음.
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("프로그램 종료.");
	}
}
