package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class MemberDAO extends DAO{
	public void memberInsert(MemberVO vo) {
		// 계정 한건 생성
		getConnect();

		String sql = "insert into members(id, passwd, name, email, responsibility) values (?,?,?,?,'user')";

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
	
	// 로그인
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
	
	// 회원전체목록 출력하기.
	public List<MemberVO> memberList(){
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id")); 
				vo.setPasswd(rs.getString("passwd")); 
				vo.setName(rs.getString("name")); 
				vo.setEmail(rs.getString("email"));  

				list.add(vo);
			}return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 한건 조회
	public MemberVO memberSearch(String id) {
		getConnect();
		MemberVO member = null;
		String sql = "select * from members where id = ?";
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

				member = new MemberVO(id1, passwd, name, email, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	// 수정
	public void memberUpdate(MemberVO vo) {
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
}
