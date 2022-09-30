package co.edu.board;

import java.util.Scanner;

// 기능만 담는 클래스
public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100]; // Board라는 클래스에 100개의 방이 있는 myBoards 라는 인스턴스 생성.

	// 1.글등록
	public void addBoard() {
		System.out.println("글등록 기능.");
		System.out.println("글번호 입력 >>>");
		int bNo = scn.nextInt();
		scn.nextLine();
		System.out.println("글제목 입력 >>>");
		String title = scn.nextLine();
		System.out.println("글내용 입력 >>>");
		String content = scn.nextLine();

		Board brd = new Board(bNo, title, content);
		// 배열 등록.
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] == null) {
				myBoards[i] = brd;
				break;
			}
		}
	}

	// 2.글목록보기
	public void boardList() {
		System.out.println("글목록 기능.");
		for (Board brd : myBoards) {
			if (brd != null) {
				System.out.println(brd.toString());
			}
		}
	}

	// 3.글상세보기
	public void boardDetail() {
		System.out.println("상세보기 기능.");
		System.out.println("조회할 글번호 >>>");
		int sno = scn.nextInt();
		boolean check = true;
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] != null && (myBoards[i].getBoardNo() == sno)) {
				System.out.println(sno + "번 글 제목: " + myBoards[i].getTitle() + " 내용: " + myBoards[i].getContent());
				check = false;
			}
		}
		if (check == true) {
			System.out.println("없는 글번호입니다.");
		}
	}

	// 4.글삭제
	public void delBoard() {
		System.out.println("글삭제 기능.");
		System.out.println("삭제할 글번호 >>>");
		int dno = scn.nextInt();
		boolean check = true;
		for (int i = 0; i < myBoards.length; i++) {
			if (myBoards[i] != null && myBoards[i].getBoardNo() == dno) {
				myBoards[i] = null;
				System.out.println(dno + "번 글이 삭제되었습니다.");
				check = false;
			}
		}
		if (check == true) {
			System.out.println("없는 글번호입니다.");
		}
	}

	// 5.전체 메뉴 확인
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.글등록 2.글목록보기 3.글상세보기 4.글삭제 9.종료");
			System.out.print("선택 >>>");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				addBoard();
				break;
			case 2:
				boardList();
				break;
			case 3:
				boardDetail();
				break;
			case 4:
				delBoard();
				break;
			case 9:
				run = false;
				break;
			default: // 정해놓은 케이스 말고 다른거 적으면 실행되는 것.
				System.out.println("잘못된 메뉴입니다.");
			}

		} // end of while
		System.out.println("프로그램 종료.");
	} // end of exe()
}
