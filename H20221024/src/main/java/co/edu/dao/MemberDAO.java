package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	
	// 생성, 수정, 삭제, 한건조회, 목록조회
	public void memberInsert(MemberVO vo) {
		// 한건 생성
		getConnect();

		String sql = "insert into members(id, passwd, name, email) values (?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate(); // 쿼리실행.
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public MemberVO memberSearch(String id) {
		// 한건 조회.
		getConnect();
		List<MemberVO> memList = new ArrayList<MemberVO>();
		String sql = "select * from members where id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");

				MemberVO member = new MemberVO(id, passwd, name, email);
				memList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return (MemberVO) memList;
	}

	public void memberUpdate(MemberVO vo) {
		// 수정.
		getConnect();
		String sql = "update members set passwd = ?, name =?, email=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void memberDelete(String id) {
		// 삭제
		getConnect();
		String sql = "delete from members where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate(); // 쿼리실행.
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<MemberVO> memberList(MemberVO vo) {
		// 목록 전체.
		getConnect();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from members" //
				+ " where id = '%'||?||'%' "//
				+ " and	passwd like '%'||?||'%' "//
				+ " and 	name like '%'||?||'%' "//
				+ " and 	email like '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");

				MemberVO mem = new MemberVO(id, passwd, name, email);
				memberList.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}
}
