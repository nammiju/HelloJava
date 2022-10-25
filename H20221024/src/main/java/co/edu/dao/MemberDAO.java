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
		String sql = "select * from members where id = ?";
		MemberVO member = null;
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				String id1 = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				vo.setResponsibility(rs.getString("responsibility"));

				member = new MemberVO(id1, passwd, name, email);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
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

	public List<MemberVO> memberList() {
		// 목록 전체.
		getConnect();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from members";
		MemberVO vo = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");

				vo.setResponsibility(rs.getString("responsibility"));
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
	
	// 로그인 확인 쿼리.
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id = ? and passwd = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
}
