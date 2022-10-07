package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample3 {
	public static void main(String[] args) {
		// 1.저장 2.조회 3.종료
		Map<String, Integer> students = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		
		while (true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("학생이름입력>> ");
				String name = scn.nextLine();
				scn.nextLine();
				System.out.println("학생점수입력>> ");
				int score = scn.nextInt();

				students.put(name, score);

			} else if (menu == 2) {
				System.out.println("조회할 학생이름입력>> ");
				String searchName = scn.nextLine();
				scn.nextLine();
				System.out.println(searchName);
				System.out.println("점수: " + students.get(searchName));

			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;

			}
		} // end of while
		System.out.println("프로그램 종료.");
	}
}
