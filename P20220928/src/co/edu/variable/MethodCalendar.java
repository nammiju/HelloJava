package co.edu.variable;

public class MethodCalendar {
	public static void main(String[] args) {
		makeCal(9); // makeCal메서드 호출
	}
	
	public static void makeCal(int month) {
		System.out.println("      >>>>   " + month + " 월   <<<<");
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		// 요일 출력
		for(String day : days) { // days의 개수만큼 반복해서 day에 담음
			System.out.printf("%4s", day);
		}
		System.out.println(); // 줄바꿈 출력
		
		// 1일의 위치 지정
		for(int i = 0; i < getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력
		for(int i = 1; i <= getLastDate(month); i++) {
			System.out.printf("%4d", i); // 4자리 만큼 가져와서 출력
			if((i + getFirstDay(month)) % 7 == 0) { // i의 값이 7로 나눴을때 나머지가 0이 되는 순간에 줄바꿈 출력
				System.out.println();
			}
		}
	} // end of makeCal()
	
	public static int getFirstDay(int month) {
		if(month == 9) {
			return 4;
		} else if(month == 8) {
			return 1;
		} else if(month == 6) {
			return 3;
		}else if(month == 7) {
			return 5;
		}else {
			return 0;
		}
	} // end of getFirstDay()
	
	public static int getLastDate(int month) {
		// switch..case..구문
		switch (month) {
		case 9:
			return 30;
		case 8:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		default:
			return 30;
		}
	}
} // end of Class{


	
