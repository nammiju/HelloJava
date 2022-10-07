package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	int empId;
	String empName;
	int salary;

	public Employ(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	

}

public class MorningCode {
	public static void main(String[] args) {
//		Scanner scn = new Scanner("Hello world Good Friend");

//		System.out.println(scn.next()); // 공백을 기준으로 하나씩 출력해줌
//		System.out.println(scn.next());
//		System.out.println(scn.next());
//		System.out.println(scn.next());

//		while(scn.hasNext())
//			System.out.println(scn.next());

//		String tok = "Hello World Good";
//		Scanner scn = new Scanner(tok);
//		Scanner scanner = new Scanner(System.in);
//
//		String[] toks = tok.split(" ");
//		for (String str : toks) {
//			System.out.println(str);
//		}

		Scanner scn = new Scanner(System.in);
		ArrayList<Employ> empList = new ArrayList<Employ>(); // Employ클래스만 담을 수 있는 ArrayList empList 생성.
		

		// 첫번째 값=> empId, 두번째 값=> empName, 세번째 값=> salary 에 넣기
		// Employee 클래스의 인스턴스 생성.
		// 그 값을 ArrayList에 저장.
		// 종료를 하고 싶으면 quit 입력시 종료.

		while (true) {
			System.out.println("입력>> ex ) 100 홍길동 2500");
			String inputVal = scn.nextLine(); 
			String[] list = inputVal.split(" "); // 입력한값 inputVal을 공백기준으로 잘라서 list 배열에 담아줌.

			if (list[0].equals("quit")) {
				break;
			}
			if(list.length != 3) {
				System.out.println("다시 입력...");
				continue;
			}
			empList.add(new Employ(Integer.parseInt(list[0]), list[1], Integer.parseInt(list[2])));  
			// 위에 만들어 놓은 ArrayList에 empList를 추가해줌
		}

		// for(반복문) 출력.
		for (Employ emp : empList) {
			System.out.println(emp.toString());

		}
	}

}
