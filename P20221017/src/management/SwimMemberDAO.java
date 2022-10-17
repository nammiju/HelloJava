package management;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimMemberDAO extends DAO {
// 1.회원등록(이름, 나이, 성별, 연락처, 강좌코드)받고 회원코드는 자동생성이니까 0값 넣기?
	public void insert(SwimMember sm) {
		String sql = "insert into members (mem_code, mem_name, mem_birth, "//
				+ "mem_gender, mem_phone, class_code, date) \r\n"//
				+ "values (?, ?, ? ,?,?,?," + "sysdate)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql); // 회원코드
			psmt.setInt(1, sm.getMemberCode()); // 회원이름
			psmt.setString(2, sm.getMemberBirth());// 회원생년월일
			psmt.setString(3, sm.getGender()); // 성별
			psmt.setString(4, sm.getMemberPhone()); // 연락처
			psmt.setInt(5, sm.getClassCode()); // 강좌코드
			psmt.setString(6, sm.getDate());// 등록일

			System.out.println(sm.getMemberName() + " 회원이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 2.회원수정(회원코드로 강좌코드, 연락처 수정)
	public void update(SwimMember sm) {
		String sql = "update members \r\n"//
				+ "set mem_phone = ?, "//
				+ "class_code = ? "//
				+ "where mem_code = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sm.getMemberPhone());
			psmt.setInt(2, sm.getClassCode());
			psmt.setInt(3, sm.getMemberCode());

			System.out.println("회원정보 " + sm.getMemberCode() + "가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 3.회원삭제(회원코드로 삭제)
	public void delete(int memberCode) {
		String sql = "delete from members \r\n"//
				+ "where mem_code = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberCode);
			psmt.executeUpdate();

			System.out.println("회원정보 " + memberCode + "가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 4.회원목록조회(모든정보가 다 출력 된다)
	public List<SwimMember> list() {
		conn = getConnect();
		List<SwimMember> memberList = new ArrayList<>();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				memberList.add(new SwimMember(rs.getInt("mem_code")//
						, rs.getString("mem_name") //
						, rs.getString("mem_birth") //
						, rs.getString("mem_gender") //
						, rs.getString("mem_phone") //
						, rs.getInt("class_code"), rs.getString("date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}

// 5.회원검색(목록에서 이름이나 회원코드로 특정 회원 검색)
	public SwimMember search(String keyword) {
		
	}
}
