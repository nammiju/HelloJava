package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class passwdReConfirmForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자가 입력한 아이디를 받아서 저장된 이메일 주소로 변경된 비밀번호를 발송.
		// 경고창에 메일 발송알림 띄우기
		
		HttpUtil.forward(req, resp, "member/passwdReConfirmForm.tiles");

	}

}
