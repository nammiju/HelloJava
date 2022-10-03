package miju;

public class ContactExe {
	public static void main(String[] args) {
		ContactDAO dao = ContactDAO.getInstance();
		dao.exe(); // dao.exe를 실행하겠다.
	}
}
