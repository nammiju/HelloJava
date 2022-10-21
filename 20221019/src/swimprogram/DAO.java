package swimprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	// Connection 객체 반환하는 getConnect 메소드
	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.93:1521:xe", "hr", "hr");

		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return conn;
	}

	// Resource 해체하는 disconnect 메소드
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
