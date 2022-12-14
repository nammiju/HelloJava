package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;

public class signUp implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		// 디비에 입력
		MemberService service = new MemberServiceImpl();
		service.insertMember(new MemberVO(id, passwd, name, email, null));
		
		HttpUtil.forward(req, resp, "member/signUp.tiles");
		

	}

}
