package co.edu.service;

import java.util.List;

import co.edu.board.MemberVO;
import co.edu.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao = new MemberDAO();

	// 횐가입
	@Override
	public void insertMember(MemberVO vo) {
		dao.memberInsert(vo);
	}
	// 로그인
	@Override
	public MemberVO login(String id, String passwd) {
		return dao.login(id, passwd);
	}
	
	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

}
