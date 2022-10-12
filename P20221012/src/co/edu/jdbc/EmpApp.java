package co.edu.jdbc;

//메인메소드 담고 있는 클래스
public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		
		//  입력.
		int empId = 101;
		String lastName = "Hong";
		String email = "hongkil@email";
		String hireDate = "2020-05-11";
		String jobId = "ST_MAN";
		Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
		
//		empDao.insert(emp1); 
//		empDao.update(emp1);
//		empDao.delete(empId);
		System.out.println(empDao.getEmp(empId));
		
//		List<Employee> employees = empDao.search();
//
//		for (Employee emp : employees) {
//			System.out.println(emp);
//		}
	}
}
