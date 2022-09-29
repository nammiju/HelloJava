package co.edu.variable;

import java.util.Scanner;

public class WhileExe {

	public static void main(String[] args) {
		whileFnc3();
	}

	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료하고싶으면 9입력.
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("월을 선택하세요. 종료는 -1 을 입력하세요.");
			int input = scn.nextInt();
			if (input == -1) { // 입력되는 인풋값이 9면 종료
				break;
			}
			MethodCalendar.makeCal(input);
			System.out.println();
		}
		System.out.println("end of program");
		scn.close();
	}

	public static void whileFnc2() {
		// while 구문
		Scanner scn = new Scanner(System.in); // 사용자가 값을 넣으면 그 값을 반환.
		while (true) { // true 넣으면 무한반복한다는 뜻
			System.out.println("값을 입력하세요. 종료하려면 stop을 입력하세요.");
			String inputVal = scn.nextLine();
			if (inputVal.equals("stop")) { // 사용자가 stop 입력하면 조검문 빠져나옴
				break;
			}
			System.out.println("사용자 입력값 >> " + inputVal); // 사용자가 stop말고 다른 값 입력하면 수행함
		}
		System.out.println("end of program");
		scn.close(); // 시스템자원을 반환.
	} // end of whileFnc2

	public static void whileFnc() {
		// for 반복문: 반복횟수가 정해져 있을때 사용하기 조흠
		int i = 0;
		while (i < 4) { // 괄호안의 조건을 만족하면 실행
			System.out.println(i);
			i++; // 출력후 i값을 1 증가시키겠습니당
		}
		System.out.println("end of program");
	} // end of whileFnc
}
