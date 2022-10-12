package co.edu.board;

import java.util.List;
import java.util.Scanner;

// main메소드 담은 클래스
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		Board bd = null;
//	1. 글등록 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수(게시글 읽으면 자동증가) 
//	2. 글수정 - 글번호 넣으면 글내용 - 작성일시 자동 변경
//	3. 글삭제 - 글번호
//	4. 글목록보기 - 글번호, 글제목, 작성자, 작성일시
//	5. 상세조회 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수

		while (true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록보기 5.상세조회 9.종료");
			System.out.print("선택>>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("===글등록===");
				System.out.println("입력하기>> 예) 글번호(숫자) 제목 내용 작성자");
				String writing = scn.nextLine();
				String[] writings = null;
				writings = writing.split(" ");
				bd = new Board(Integer.parseInt(writings[0]), writings[1], writings[2], writings[3], null,
						0);
				dao.create(bd);

			} else if (menu == 2) {
				System.out.println("===글수정===");
				System.out.println("수정할 글번호>>> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 내용>>");
				String content = scn.nextLine();

				bd = new Board(num, null, content, null, null, 0);

				dao.update(bd);
			} else if (menu == 3) {
				System.out.println("===글삭제===");
				System.out.println("삭제할 글번호>>> ");
				int num = Integer.parseInt(scn.nextLine());
				dao.delete(num);

			} else if (menu == 4) {
				System.out.println("===글목록보기===");
				List<Board> boardList = dao.search();
				for (Board board1 : boardList) {
//					4. 글목록보기 - 글번호, 글제목, 작성자, 작성일시
					System.out.println(
							board1.getBoardNum() + board1.getBoardTitle() + board1.getBoardWriter() + board1.getDate());
				}

			} else if (menu == 5) {
				System.out.println("===상세조회===");
				System.out.println("조회할 글번호>>> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println(dao.getbd(num));

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}

		}

	}
}
