package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.MainControl;
import co.edu.control.SearchBoard;
import co.edu.control.writeBoard;
import co.edu.control.writeForm;

public class FrontController extends HttpServlet {

	HashMap<String, Control> controlList;
	String charset;

	// 서블릿이 호출되면 한번 실행될 init() 둘중 아무거나 사용 가넝~
//	@Override
//	public void init() throws ServletException {
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl());
		controlList.put("/bulletin.do", new BulletinControl());
		controlList.put("/searchBoard.do", new SearchBoard());
		
		//글 등록
		controlList.put("/writeBoardForm.do", new writeForm());
		controlList.put("/writeBoard.do", new writeBoard());
	}
	// 서블릿이 호출될때마다 실행될 service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost:8081 (uri:)/H20221025/main.do 
		String context = req.getContextPath(); // : /H20221025
		String path = uri.substring(context.length()); // main.do 만 읽어오고 싶어서
		
		System.out.println(path);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); // main.do를 호출해서 거기에 있는 control을 실행.
	}
}
