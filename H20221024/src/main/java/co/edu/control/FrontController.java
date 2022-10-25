package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet {

	Map<String, Command> control = new HashMap<>();

	@Override
	public void init() throws ServletException {
		control.put("/main.do", new MainControl());
		// 추가기능.
		control.put("/memberAddForm.do", new memberAddForm());
		control.put("/memberAdd.do", new MemberAddControl());
		// 수정기능.
		control.put("/memberModifyForm.do", new MemberModifyForm());
		control.put("/memberModify.do", new MemberModifyControl());
		// 삭제기능.
		control.put("/memberRemoveForm.do", new memberRemoveForm());
		control.put("/memberRemove.do", new memberRemove());
		// 한건조회.
		control.put("/memberSearchForm.do", new memberSearchForm());
		control.put("/memberSearch.do", new memberSearch());
		// 목록.
		control.put("/memberList.do", new memberList());
		// 로그인.
		control.put("/loginForm.do", new LoginForm());
		control.put("/login.do", new login());
		// 로그아웃.
		control.put("/loginOut.do", new loginOut());
		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = control.get(path);
		command.exec(req, resp);
	}
}
