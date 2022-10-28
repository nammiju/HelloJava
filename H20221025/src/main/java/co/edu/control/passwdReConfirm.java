package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.dao.MailAppNaver;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;

public class passwdReConfirm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 비밀번호 메일 발송 처리.
		String id = req.getParameter("id");

		MemberService service = new MemberServiceImpl();
		MemberVO result = service.memberSearch(id);

		if (result != null) {
			MailAppNaver mail = new MailAppNaver();

			String randomPw = "";
			for (int i = 1; i <= 6; i++) {
				randomPw += (int) (Math.random() * 9) + 1;
			}

			mail.sendMail("nmj_1025@naver.com", result.getEmail(), "임시비밀번호 메일입니다.", randomPw);

			service.memberUpdate(new MemberVO(id, randomPw, result.getName(), result.getEmail(), null));
			
			HttpUtil.forward(req, resp, "member/signInForm.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/passwdReConfirmForm.tiles");
		}

	}

}
