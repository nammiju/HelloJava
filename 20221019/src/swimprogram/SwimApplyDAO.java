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
	public int insert(SwimApply sa) {
		int num = 0;
		conn = getConnect();
		String sql1 = "select * from apply where mem_code= ?"; 
		String sql2 = "select count(*) count\r\n"
				+ "from apply "
				+ "where class_code = ?";
		String sql3 = "select * from swimclass\r\n"
				+ "where class_code = ?";
		String sql4 = "insert into apply(apply_code, class_code, mem_code) \r\n" //
				+ "values (apply_seq.nextval, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, sa.getMemberCode());
			rs = psmt.executeQuery();
			if(rs.next()) {
				return -1; // 강좌수 초과
			} else {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, sa.getClassCode());
				rs = psmt.executeQuery();
				if(rs.next()) {
					 num = rs.getInt("count");
				}
				
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, sa.getClassCode());
				rs = psmt.executeQuery();
				if(rs.next()) {
					if(num < rs.getInt("member_num")) {
						psmt = conn.prepareStatement(sql4);
						psmt.setInt(1, sa.getClassCode());
						psmt.setInt(2, sa.getMemberCode());

						psmt.executeUpdate();
						return -2; // 수강신청 완료.
						
					} else {
						return -3; // 수강정원 초과.
						
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}return 1;
	} 
	
	public int membernum(SwimApply sa) {
		int num = 0;
		conn = getConnect();
		String sql = "select count(*) count\r\n"
				+ "from apply "
				+ "where class_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sa.getClassCode());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				 num = rs.getInt("count");
				 return num;
				 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}return num;
		
	}
}
