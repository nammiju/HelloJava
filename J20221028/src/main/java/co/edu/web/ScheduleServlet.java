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

import co.edu.member.CalendarVO;
import co.edu.service.CalendarDAO;


@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ScheduleServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json;charset=utf-8");
		CalendarDAO dao = new CalendarDAO();
		List<CalendarVO> list = dao.getSchedule();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 입력값에 있는 한글 처리.
		response.setCharacterEncoding("utf-8"); // 응답값에 있는 한글 처리.
		response.setContentType("text/json;charset=utf-8"); // 출력할때 한글 처리.
		
		CalendarDAO dao = new CalendarDAO();
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStartDate(start);
		vo.setEndDate(end);
		
		dao.insertSchedule(vo);
		
		Gson gson = new GsonBuilder().create(); // gson인스턴스 호출
		 
		response.getWriter().print(gson.toJson(vo)); // 입력값을 Json타입으로 변환해준 다음 웹에 출력해줌. 
		
	}

}
