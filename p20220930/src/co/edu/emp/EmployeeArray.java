package co.edu.emp;

import java.util.Scanner;

// 배열 저장.
public class EmployeeArray implements EmployeeService {

	// 데이터 저장 공간 생성.
	Employee[] list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		System.out.println("사원수를 입력하세요. >>>");
		int cnt = Integer.parseInt(scn.nextLine());
		list = new Employee[cnt]; // 입력하는 사원수 만큼의 인스턴스를 저장할 수 있는 공간 생성.
	}

	@Override
	public void input() {

		if (idx >= list.length) {
			System.out.println("더이상 입력이 불가합니다.");
			return; // 메소드가 종료됨.
		}

		System.out.println("사번을 입력하세요. >>>");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름을 입력하세요. >>>");
		String name = scn.nextLine();
		System.out.println("부서를 입력하세요. >>>");
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("급여를 입력하세요. >>>");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("이메일을 입력하세요. >>>");
		String email = scn.nextLine();

		Employee emp = new Employee(eId, name, sal, deptId, email);
		list[idx++] = emp;
	}

	@Override
	public String search(int employeeId) {
		// 입력된 값중에서 찾도록. list[5]여도 idx값 만큼만 돌리도록.
		// 100, 200, 300
		String result = null;
		for (int i = 0; i < idx; i++) {
			if (list[i].getEmployeeId() == employeeId) {
				result = list[i].getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
		for (int i = 0; i < idx; i++) {
			System.out.printf("%5d %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary()); // %5d
																													// %10s
																													// %7d\n
		}
	}

	@Override
	public int searchSal(int employeeId) {
		// 사번을 넣으면 급여를 반환.
		int sal = -1; // int는 기본값으로 null을 가질 수 없움. 
		for (int i = 0; i < idx; i++) {
			if (list[i].getEmployeeId() == employeeId) {
				sal = list[i].getSalary();
				break;
			}
		}
		return sal;
	}
}
