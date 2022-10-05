package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) throws ClassNotFoundException {
		// null pointer 참조.
		String str = "Hello World!!";
		// 예외처리. RuntimeException을 상속받아서 처리하는 예외클래스.
		try { // try 구문에 catch()에 적힌 에러가 나면 catch{} 구문 어어끄너..진휑시켜..
			String result = str.substring(0, 10);
			char chr = result.charAt(20);
			System.out.println(chr);
		} catch (NullPointerException | StringIndexOutOfBoundsException e1) { // 멀티 예외
			System.out.println("참조하는 값이 없습니다..");
//		} catch (StringIndexOutOfBoundsException e1) {
//			System.out.println("인덱스범위를 벗어난 값입니다.");
		} catch (RuntimeException e2) {
			System.out.println("실행예외가 발생했습니다.");
		} catch (Exception e3) { // 처리할 수 있는 예외중 가장 범위가 넓음. 만약 발생할 오류를 모르겠다면 익셉션을 걸면 된다... 그리고 가장 큰 범위의 예외를 제일
									// 마지막에 넣어야 한다.
			System.out.println("알수 없는 예외가 발생했습니다.");
		}

//		// 일반예외: Exception을 상속받아서 처리하는 예외클래스.
//		try {
//			Class.forName("java.lang.Srting");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("숫자입력 >>>");

			try {
				int menu = scn.nextInt(); // InputMismatchException
				System.out.println("입력값은: " + menu);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요!");
				scn.nextLine(); //
			} finally {
				System.out.println("반드시 실행할 코드.");
				// db connection 사용하고 resource 반환 하는 코드는 finally안에 주로 넣어준다.
			}
		}
		exceptMethod();

		System.out.println("프로그램 종료.");
	} // end of main()

	public static void exceptMethod() throws ClassNotFoundException {
		// 일반예외: Exception을 상속받아서 처리하는 예외클래스.
//		try {
			Class.forName("java.lang.Srting");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

	}
}
