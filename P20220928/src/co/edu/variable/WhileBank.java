package co.edu.variable;

import java.util.Scanner;

public class WhileBank {
	public static void main(String[] args) {
		bankApp();
	}

	public static void bankApp() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		// 메뉴: 1.예금 2.출금 3.잔고확인 4.종료
		// 잔고가 10만원 이상은 안됨 잔고 99000원 일때 1000원까지만 입금가능하고 10000원 넣으면 입금 안되게 하기
		while (run) {
			System.out.println("1.예금 2.출금 3.잔고확인 4.종료");
			int menu = scn.nextInt();

			switch (menu) {
			case 1:
				System.out.println("예금처리하는 메뉴입니다.");
				System.out.println("예금액을 입력하세요. >>>");
				int input = scn.nextInt();
				if (money + input > 100000) {
					System.out.println("예금액은 100000원을 초과 할 수 없습니다.");
					break;
				}
				System.out.println(input + "원 입금하셨습니다.");
				money = money + input;
				break; // 케이스마다 브레이크를 적어줘야 하나만 실행하고 끝낸다.
			case 2:
				System.out.println("출금처리하는 메뉴입니다.");
				System.out.println("출금액을 입력하세요. >>>");
				int output = scn.nextInt();
				if (money < output) {
					System.out.println("잔고에 돈이 부족합니다.");
					break;
				}
				System.out.println(output + "원 출금하셨습니다.");
				money = money - output;
				break;
			case 3:
				System.out.println("잔고확인하는 메뉴입니다.");
				System.out.println("현재 잔고는 : " + money + " 원 입니다.");
				break;
			case 4:
				System.out.println("종료하는 메뉴입니다.");
				run = false; // 4 입력하면 run이 false로 바껴서 프로그램이 종료됨.
			}
		} // end of while
		System.out.println("end of program.");
	} // end of bankApp()
}
