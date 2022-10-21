package swimprogram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimMemberDAO extends DAO {
// 회원등록
	public void insert(SwimMember sm) {
		conn = getConnect();
		String sql = "insert into swimmember(mem_code, mem_name, mem_birth, mem_gender, mem_phone, creation_date) \r\n"
				+ "values (mem_seq.nextval, ?, ?, ?, ?, sysdate)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sm.getMemberName());
			psmt.setString(2, sm.getMemberBirth());
			psmt.setString(3, sm.getGender());
			psmt.setString(4, sm.getMemberPhone());

			psmt.executeUpdate();
			System.out.println(sm.getMemberName() + " 회원이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

// 회원수정
	public void update(SwimMember sm) {
		conn = getConnect();
		String sql = "update swimmember \r\n" //
				+ "set mem_phone = ? "//
				+ "where mem_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sm.getMemberPhone());
			psmt.setInt(2, sm.getMemberCode());

			psmt.executeUpdate();
			System.out.println(sm.getMemberCode() + " 회원의 연락처가 " + sm.getMemberPhone() + " 으로 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

// 회원목록조회	
	public List<SwimMember> list(SwimMember sm) {
		conn = getConnect();
		List<SwimMember> memberList = new ArrayList<>();
		String sql = "select * from swimmember" //
				+ " where 	mem_code = decode(?, 0, mem_code, ?) "// ?값이 0이면 전체 출력하고 0이 아니면 ?값만 출력
				+ " and		mem_name like '%'||?||'%' " //
				+ "	and     mem_gender like '%'||?||'%' "
				+ " order by mem_code";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sm.getMemberCode());
			psmt.setInt(2, sm.getMemberCode());
			psmt.setString(3, sm.getMemberName());
			psmt.setString(4, sm.getGender());

			rs = psmt.executeQuery(); // rs에 쿼리 실행결과를 담아줌

			while (rs.next()) { // rs의 값이 있으면 true, 없으면 false
				int memCode = rs.getInt("mem_code"); // 컬럼명을 적어주기
				String memName = rs.getString("mem_name");
				String memBirth = rs.getString("mem_birth");
				String gender = rs.getString("mem_gender");
				String memPhone = rs.getString("mem_phone");
				String creDate = rs.getString("creation_date");

				SwimMember smInfo = new SwimMember(memCode, memName, memBirth, gender, memPhone, creDate);
				memberList.add(smInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return memberList;
	}
}
