package co.edu.emp;

import java.util.ArrayList;
import java.util.Scanner;

// 컬렉션 활용해서 데이터 저장.
public class EmployeeArrayList implements EmployeeService {
	ArrayList<Employee> list;
	int ldx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료.");
	}

	@Override
	public void input() {

		// 사번입력 & 예외처리.
		int eId = readInt("사번을 입력하세요. >>>");
//		while (true) {
//			try {
//				System.out.println("사번을 입력하세요. >>>");
//				eId = Integer.parseInt(scn.nextLine());
//				break;
//			} catch (NumberFormatException e) {
//				System.out.println("숫자를 입력하세요.");
//			}
//		}
//		
		System.out.println("이름을 입력하세요. >>>");
		String name = scn.nextLine();
		
		// 부서입력 & 예외처리(10, 20, 30 이외의 부서는 부적절).
		int deptId = -1;
		while (true) {
			deptId=readInt("부서를 입력하세요. >>>");
			try {
				validDetp(deptId);
				break;
			} catch (InvalidDetpException e1) {
				System.out.println(e1.getMessage());
			}
		}
		
		// 급여입력 & 예외처리.
		int sal = readInt("급여를 입력하세요. >>>");

		System.out.println("이메일을 입력하세요. >>>");
		String email = scn.nextLine();

		Employee emp = new Employee(eId, name, sal, deptId, email);
		list.add(emp);

	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for (int i = 0; i < list.size(); i++) {
//			Employee emp = list.get(i);
//			if (emp.getEmployeeId() == employeeId) {
//				result = emp.getName();
//				break;
//			}
//		}
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	@Override
	public void print() {
//		for(Employee allemp : list) {
//			System.out.println(allemp);
		System.out.printf("%5s %10s %7s\n", "사원번호", "이름   ", "급여   ");
		System.out.println("========================");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%5d %10s %7d\n", list.get(i).getEmployeeId(), list.get(i).getName(),
					list.get(i).getSalary());
		}
	}

	@Override
	public int searchSal(int employeeId) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int readInt(String msg) {
		int result = -1;
		System.out.println(msg);
		try {
			result = Integer.parseInt(scn.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		return result;
	}
	
	public void validDetp(int detp) throws InvalidDetpException{
		int validDetp = detp % 10;
		if(validDetp !=0 || detp > 30) {
			throw new InvalidDetpException("잘못도니 부서정보입니다.");
		}
	}

}
