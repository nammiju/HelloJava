package management;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//강좌 기능
public class swimClassDAO extends DAO {
// 1.강좌등록(강좌코드classCode, 강좌명className, 강사명classTeacher 입력해서 강좌를 등록함, 강좌 정원은 자동으로 계산?)
	public void insert(SwimClass sc) {
		String sql = "insert into classes (class_code, class_name, class_t, class_mem) \r\n"//
				+ "values (?, ?, ? ,?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sc.getClassCode());
			psmt.setString(2, sc.getClassName());
			psmt.setString(3, sc.getClassTeacher());
			psmt.setInt(4, sc.getClassMem());

			System.out.println(sc.getClassName() + " 강좌가 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// 2.강좌수정(강좌코드 입력후 강사 수정) 
	public void update(SwimClass sc) {
		String sql = "update classes \r\n"//
				+ "set class_t = ?, "//
				+ "where class_code = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sc.getClassTeacher());
			psmt.setInt(2, sc.getClassCode());

			System.out.println(sc.getClassName() + " 강좌가" + sc.getClassTeacher() + "강사로 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 3.강좌삭제(강좌코드로 삭제)
	public void delete(int classCode) {
		String sql = "delete from classes \r\n"//
				+ "where class_code = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, classCode);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 4.강좌목록조회(모든정보가 다 출력 된다) 
	public List<SwimClass> list() {
		conn = getConnect();
		List<SwimClass> swimList = new ArrayList<>();
		String sql = "select * from classes";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				swimList.add(new SwimClass(rs.getInt("class_code")//
						, rs.getString("class_name") //
						, rs.getString("class_t") //
						, rs.getInt("class_mem")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return swimList;
	}

	// 로그인
	public int login(String id, String pw) {
		String sql = "select * from users where id = ?";//
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs == null) {
				return -1; // 아이디가 없을때
			} else if (rs.next() && rs.getString("passwd").equals(pw)) {
//					System.out.println("로그인 성공");
				return 0; // 아이디 비밀번호 다 일치할떄
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2; // 아이디는 맞고 비번은 틀릴때
	}
}
