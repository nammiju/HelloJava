package co.edu.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);
		Employee emp = null;
		// 메뉴 => 1.사원등록(insert 메소드 호출) 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료
		while (true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.일괄등록 9.종료");
			System.out.print("선택>>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("=====사원등록메뉴=====");
				System.out.println("사원번호>>> ");
				int id = scn.nextInt();
				scn.nextLine();
				System.out.println("사원이름>>> ");
				String name = scn.nextLine();
				System.out.println("이메일>>> ");
				String email = scn.nextLine();
				System.out.println("입사날짜>>> ");
				String date = scn.nextLine();
				System.out.println("직무>>> ");
				String job = scn.nextLine();

				emp = new Employee(id, name, email, date, job);

				dao.insert(emp);

			} else if (menu == 2) {
				System.out.println("=====한건조회메뉴=====");
				System.out.println("조회할 사원번호>>> ");
				int id = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getEmp(id));

			} else if (menu == 3) {
				System.out.println("======수정메뉴======");
				System.out.println("수정할 사원번호>>> ");
				int id = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 이메일>>> ");
				String email = scn.nextLine();
				System.out.println("수정할 입사날짜>>> ");
				String date = scn.nextLine();
				System.out.println("수정할 직무>>> ");
				String job = scn.nextLine();

				emp = new Employee(id, null, email, date, job);

				dao.update(emp);

			} else if (menu == 4) {
				System.out.println("======삭제메뉴======");
				System.out.println("삭제할 사원번호>>> ");
				int id = Integer.parseInt(scn.nextLine());
				dao.delete(id);

			} else if (menu == 5) {
				System.out.println("=====목록조회메뉴=====");
				List<Employee> employees = dao.search();
				for (Employee emp1 : employees) {
					System.out.println(emp1);
				}

			} else if (menu == 6) {
				System.out.println("=====일괄등록메뉴=====");
				
				
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}

		scn.close();
	}
}
