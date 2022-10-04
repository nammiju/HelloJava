package co.edu.inherit.dbinterface;

public class CompanyApp {
	public static void main(String[] args) {
		// 추가, 수정, 삭제, 조회 기능.
//	MysqlDAO  dao = new MysqlDAO();
//	dao.insert();
//	dao.update();
//	dao.search();
//	dao.delete();

//		OracleDAO dao = new OracleDAO();
//		dao.add();
//		dao.modify();
//		dao.find();
//		dao.remove();
		
		DaoService dao = new MysqlDAO();
		dao = new OracleDAO(); // ver2.0
		dao.insert();
		dao.modify();
		dao.remove();
		dao.search();
		
		// 익명구현객체: 인터페이스 구현 코드만 존재.
		DaoService anonym = new DaoService () { // 클래스를 선언하지 않음.

			@Override
			public void insert() {
				System.out.println("익명db 입력.");
			}

			@Override
			public void modify() {
				System.out.println("익명db 수정.");
			}

			@Override
			public void remove() {
				System.out.println("익명db 삭제.");
			}

			@Override
			public void search() {
				System.out.println("익명db 조회.");
			}
			
		};
		anonym.insert();
		anonym.search();
		anonym.remove();
		anonym.modify();
	}
}
