package co.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.member.CalendarVO;
import co.edu.member.MemberVO;

public class CalendarDAO extends DAO{
	// 일정 가져오기.
		public  List<CalendarVO> getSchedule() {
			getConnect();
			List<CalendarVO> list = new ArrayList<>();
			String sql = "select * from full_calendar";
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while (rs.next()) {
					CalendarVO vo = new CalendarVO();
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("start_date"));
					vo.setEndDate(rs.getString("end_date"));
					
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return list;
			
		}
		
	// 스케줄 등록
		public void insertSchedule(CalendarVO vo) {
			getConnect();

			String sql = "insert into full_calendar(title, start_date, end_date)\r\n"
					+ "values(?, ?, ?)";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getTitle());
				psmt.setString(2, vo.getStartDate());
				psmt.setString(3, vo.getEndDate());

				psmt.executeUpdate(); // 쿼리실행.

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
}
