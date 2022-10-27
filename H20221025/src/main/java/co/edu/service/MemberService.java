package co.edu.service;

import java.util.List;

import co.edu.board.MemberVO;

public interface MemberService {
	// 회원관리 기능만 정의.
	// 입력(횐가입)
	public void insertMember(MemberVO vo);
	//로그인
	public MemberVO login(String id, String passwd);
	//회원목록
	public List<MemberVO> memberList();
}
