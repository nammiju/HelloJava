package co.edu.nested;

import java.util.List;
import java.util.function.Consumer;

import co.edu.jdbc.Employee;
import co.edu.jdbc.EmployeeDAO;

public class FunctionalExample {
	public static void main(String[] args) {

		Consumer<String> consumer = (String t) -> {
			System.out.println(t + "는 흥미롭습니다.");
		};
		consumer.accept("자바");

		// 함수적 프로그래밍 -> 데이터를 처리할때.
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.search();

		// 시냇물이 흘러가는 것 처럼 데이터가 흐름이 있다 그것이! stream()
//		list.stream().forEach(new Consumer<Employee>() {
//			@Override
//			public void accept(Employee t) {
//				System.out.println("사번 " + t.getEmployeeId() + //
//						",이름 " + t.getLastName());
//			}
//		});
		list.stream().forEach((t) -> System.out.println(t.toString()));

	}
}
