package swimprogram;

import java.sql.SQLException;

public class SwimApplyDAO extends DAO {
//로그인 
	public int login(String id, String pwd) {
		String sql = "select * from users where id = ?";//
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs == null) {
				return -1; // 아이디가 없을때
			} else if (rs.next() && rs.getString("passwd").equals(pwd)) {
//				System.out.println("로그인 성공");
				return 0; // 아이디 비밀번호 다 일치할떄
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2; // 아이디는 맞고 비번은 틀릴때
	}

//수강등록
	public void insert(SwimApply sa) {
		conn = getConnect();
		String sql = "insert into apply(apply_code, class_code, mem_code) \r\n" + "values (apply_seq.nextval, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sa.getClassCode());
			psmt.setInt(2, sa.getMemberCode());

			psmt.executeUpdate();
			System.out.println(sa.getMemberCode() + "회원이 " + sa.getClassCode() + " 강좌에 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
