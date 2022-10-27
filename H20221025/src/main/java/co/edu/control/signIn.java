package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;

public class signIn implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 화면으로 이동
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		MemberService service = new MemberServiceImpl();
		MemberVO result = service.login(id, passwd);
		
		
		if (result != null) {
			req.setAttribute("logInfo", result);

			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getResponsibility()); // admin인지 user인지 따라서 권한을 달리 주고 싶음.

			
			
			HttpUtil.forward(req, resp, "member/signIn.tiles");
			
		} else {
			HttpUtil.forward(req, resp, "member/signInForm.tiles");
		}
		
		
		
	}

}
