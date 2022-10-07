package co.edu.api;

import java.util.ArrayList;
import java.util.List;

class Box<T> { // T: 어떤 타입을 사용할지 정하지 않았을때 앞에 오브젝트나 타입대신에 적어주면 됨.
	T obj;

	void set(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}

class Member {
	private String name;
	private String id;
	private int point;

	public Member(String name, String id, int point) { // 생성자
		super();
		this.name = name;
		this.id = id;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}

class Employee {
	private String empName;
	private String empId;
	private int salary;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}

public class StringExe3 {
	public static void main(String[] args) {

		Box<String> box = new Box<String>(); // box 안에는 스트링타입만 들어갈 수 있어염
		box.set("Hello");
//		box.set(200); // 스트링타입만 들어갈수 있게 지정했는데 정수를 넣어서 오류남
		String result = (String) box.get(); // 리턴되는 것이 오브젝트 타입이라 출력하고 싶은 타입이 있으면 타입을 지정해줘야함.
		System.out.println(result); // 마지막에 정수가 들어갔는데 스트링타입으로 지정해줘서 문법상 오류는 없지만 실행시 오류가 발생한다.

		String[] stAry; // 문자열을 담을 수 있는 배열
		List<String> list = new ArrayList<String>(); // 컬렉션, 스트링 타입만 담겠다구 지정함ㅋㄷ
		list.add("Hello");

		List<Member> members = new ArrayList<Member>(); // MeMber클래스의 인스턴스만 담을 수 있는 컬렉션
		members.add(new Member("홍길동", "hong", 10000));
		members.add(new Member("김민기", "kim", 20000));
		members.add(new Member("박인기", "park", 30000));

		List<Employee> employees = changeType(members); // Member =>
		for (Employee emp : employees) {
			System.out
					.println("name: " + emp.getEmpName() + ", id: " + emp.getEmpId() + ", salary: " + emp.getSalary());
		}

	} // end of StringExe3

	public static List<Employee> changeType(List<Member> collect) { // List<Employee>: 반환값과 리턴타입,
		// 3 -> 3개. // changeType(List<Member> collect): 매개변수
		List<Employee> empls = new ArrayList<Employee>();
		for (Member member : collect) {
			Employee emp = new Employee();
			emp.setEmpId(member.getId()); // member에서 에서 Id를 가져와 setEmpId에 넣는다
			emp.setEmpName(member.getName());
			emp.setSalary(member.getPoint());

			empls.add(emp);

		}
		return empls;
	}
}
