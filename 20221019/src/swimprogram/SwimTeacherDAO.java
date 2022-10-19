package swimprogram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimTeacherDAO extends DAO {
// 강사등록(강사코드, 강사명, 강좌코드, 메모)
	public void insert(SwimTeacher st) {
		conn = getConnect();
		String sql = "insert into swimteacher(teacher_code, teacher_name, class_code, memo) \r\n"
				+ "values (tea_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, st.getTeacherName());
			psmt.setInt(2, st.getClassCode());
			psmt.setString(3, st.getMemo());

			psmt.executeUpdate();
			System.out.println(st.getTeacherCode() + " 강사가 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//강사목록조회
	public List<SwimTeacher> list() {
		conn = getConnect();
		List<SwimTeacher> teacherList = new ArrayList<>();
		String sql = "select * from swimteacher;";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // rs에 쿼리 실행결과를 담아줌
			while (rs.next()) { // rs의 값이 있으면 true, 없으면 false
				teacherList.add(new SwimTeacher(rs.getInt("teacher_code")//
						, rs.getString("teacher_name")//
						, rs.getInt("class_code")//
						, rs.getString("memo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherList;
	}
}
