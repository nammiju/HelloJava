package swimprogram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimClassDAO extends DAO {
// 강좌등록(강좌코드, 강좌명, 강사명, 인원)
	public void insert(SwimClass sc) {
		conn = getConnect();
		String sql = "insert into swimclass (class_code, class_name, teacher_code) \r\n"//
				+ "values (cla_seq.nextval, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sc.getClassName());
			psmt.setInt(2, sc.getTeacherCode());

			psmt.executeUpdate();
			System.out.println("<" + sc.getClassName() + ">" + "강좌가 개설되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 강좌수정
	public void update(SwimClass sc) {
		conn = getConnect();
		String sql = "update swimclass \r\n"//
				+ "set teacher_code = ? "//

				+ ", class_name = ? " //
				+ "where class_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sc.getTeacherCode());

			psmt.setString(2, sc.getClassName());
			psmt.setInt(3, sc.getClassCode());

			psmt.executeUpdate();
			System.out.println("<" + sc.getClassCode() + ">" + " 강좌가 " + sc.getTeacherCode() + " 강사로 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//강좌목록조회, 검색
	public List<SwimClass> list(SwimClass sc) {
		conn = getConnect();
		List<SwimClass> swimList = new ArrayList<>();
		String sql = "select * from swimclass" //
				+ " where 	class_code = decode(?, 0, class_code, ?) "// ?값이 0이면 전체 출력하고 0이 아니면 ?값만 출력
				+ " and		class_name like '%'||?||'%' "//
				+ " and 	nvl(teacher_code, 0) = decode(?, 0, nvl(teacher_code, 0), ?)" + " order by class_code";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sc.getClassCode());
			psmt.setInt(2, sc.getClassCode());
			psmt.setString(3, sc.getClassName());
			psmt.setInt(4, sc.getTeacherCode());
			psmt.setInt(5, sc.getTeacherCode());

			rs = psmt.executeQuery(); // rs에 쿼리 실행결과를 담아줌

			while (rs.next()) { // rs의 값이 있으면 true, 없으면 false
				int classCode = rs.getInt("class_code"); // 컬럼명을 적어주기
				String className = rs.getNString("class_name");
				int teachercode = rs.getInt("teacher_code");
				int memberNum = rs.getInt("member_num");

				SwimClass scInfo = new SwimClass(classCode, className, teachercode, memberNum);
				swimList.add(scInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return swimList;
	}
}
