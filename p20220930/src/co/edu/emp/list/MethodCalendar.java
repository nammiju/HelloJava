package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar {

	private static MethodCalendar instance = new MethodCalendar();

	private MethodCalendar() {
	}

	public static MethodCalendar getInstance() {
		return instance;
	}

	public void makeCal(int year, int month) { // 정적 메소드는 인스턴스를 만들지 않아도 사용가능하다
		System.out.println("    >>>> " + year + "년 " + month + "월 <<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		// 요일 출력
		for (String day : days) { // days의 개수만큼 반복해서 day에 담음
			System.out.printf("%4s", day);
		}
		System.out.println(); // 줄바꿈 출력

		// 1일의 위치 지정
		for (int i = 0; i < getFirstDay(year, month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력
		for (int i = 1; i <= getLastDate(year, month); i++) {
			System.out.printf("%4d", i); // 4자리 만큼 가져와서 출력
			if ((i + getFirstDay(year, month)) % 7 == 0) { // i의 값이 7로 나눴을때 나머지가 0이 되는 순간에 줄바꿈 출력
				System.out.println();
			}
		}
	} // end of makeCal()

	public int getFirstDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); // 1워를 0부터 계산해서 넣는 월에 -1 해줘야 찾는 월이 나옴.
		cal.get(Calendar.DAY_OF_WEEK);
		return cal.get(Calendar.DAY_OF_WEEK) - 1; // 일요일 - 1

	} // end of getFirstDay()

	public int getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.getActualMaximum(Calendar.DATE);

	}
} // end of Class{
