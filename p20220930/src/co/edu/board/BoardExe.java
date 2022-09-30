package co.edu.board;

public class BoardExe {
	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();
//				new BoardDAO(); // BoardDAO의 인스턴스를 호출하고
		dao.exe(); // dao.exe를 실행하겠다.
	}
}
