package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// 넘어오는 데이터가 []배열의 형식
		// [{"id":"user1","name":"홍길동","email":"email.com","responsibility":"user"},{},{}]
		// 만약 데이터가 3건이면 1(0),2(1),3(2) 이렇게 마지막 데이터엔 콤마가 없어야 한다.
//		String json = "[";
//		for (int i = 0; i < list.size(); i++) {
//			json += "{\"id\":\"" + list.get(i).getId() //
//					+ "\",\"name\":\"" + list.get(i).getName() //
//					+ "\",\"email\":\"" + list.get(i).getEmail() //
//					+ "\",\"responsibility\":\"" + list.get(i).getResponsibility() + "\"}";
//			if (i < list.size() - 1) {
//				json += ",";
//			}
//		}
//		json += "]";
		Gson gson = new GsonBuilder().create(); // 위에 울라불라한거 두줄로 정리 쌉.
		response.getWriter().print(gson.toJson(list));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8"); // 입력값에 있는 한글 처리.
		response.setCharacterEncoding("utf-8"); // 응답값에 있는 한글 처리.
		response.setContentType("text/json;charset=utf-8"); // 출력할때 한글 처리.
		
		String job = request.getParameter("job");
		
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		// job => 등록, 삭제 구분.
		if(job.equals("delete")) {
			if(dao.deleteMember(id)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}
			
		}else if (job.equals("insert")) {
			String pw = request.getParameter("passwd");
			String em = request.getParameter("email");
			String nm = request.getParameter("name");
			
			// 폼에서 받아온 데이터 DB에 한 건 입력 처리.
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setEmail(em);
			vo.setName(nm);
			
			dao.insertMember(vo);
			
			Gson gson = new GsonBuilder().create(); // gson인스턴스 호출
			 
			response.getWriter().print(gson.toJson(vo)); // 입력값을 Json타입으로 변환해준 다음 웹에 출력해줌. 
			
		}
	
	}

}
