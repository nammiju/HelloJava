package co.edu.emp;

// 추가, 수정, 삭제, 조회 처리 CRUD
public interface EmployeeService {
	// 초기화(init).
	public void init();

	// 추가.
	public void input();

	// 조회. 사원번호를 넣으면 이름 반환.
	public String search(int employeeId);

	public void print(); // 전체사원정보 출력.
	
	public int searchSal(int employeeId);
}
