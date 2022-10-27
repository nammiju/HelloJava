package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class signInForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 입력한 아이디, 패스워드 => 검증 맞으면 session 객체에 id값을 저장.
		// 로그인 성공 페이지 띄우기. signIn.jsp
		HttpUtil.forward(req, resp, "member/signInForm.tiles");
	}

}
