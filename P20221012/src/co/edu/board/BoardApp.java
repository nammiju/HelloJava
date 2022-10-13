package co.edu.board;

import java.util.List;
import java.util.Scanner;

// main메소드 담은 클래스
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		Board bd = null;
		Reply re = null;
//	1. 글등록 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수(게시글 읽으면 자동증가) 
//	2. 글수정 - 글번호 넣으면 글내용 - 작성일시 자동 변경
//	3. 글삭제 - 글번호
//	4. 글목록보기 - 글번호, 글제목, 작성자, 작성일시
//	5. 상세조회 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수

		boolean check = false;

		while (!check) {
			System.out.println("로그인하세요.");
			System.out.print("아이디 입력>>>  ");
			String id = scn.nextLine();
			System.out.print("패스워드 입력>>>  ");
			String pwd = scn.nextLine();

			dao.login(id, pwd);
			if (dao.login(id, pwd) == 0) {
				System.out.println("로그인 성공");
				check = true;
				// 리턴값이 0이면 아이디 비번 다 일치하므로 최상위 while문을 false로 만들어
				// 최상위 while문을 중단시키고 아래에 있는 while문을 실행함

				while (true) {
					System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록보기 5.상세조회 9.종료");
					System.out.print("선택>>> ");
					int menu = Integer.parseInt(scn.nextLine());

					if (menu == 1) {
						System.out.println("===글등록===");
						System.out.println("입력하기>> 예) 글번호(숫자) 제목 내용");
						String writing = scn.nextLine();
						String[] writings = null;
						writings = writing.split(" ");
						bd = new Board(Integer.parseInt(writings[0]), writings[1], writings[2], id, null, 0);
						dao.create(bd);

					} else if (menu == 2) {
						System.out.println("===글수정===");
						System.out.println("수정할 글번호>>> ");
						int num = Integer.parseInt(scn.nextLine());

						dao.getbd(num);
						if (dao.getbd(num).getBoardWriter().equals(id)) {
							System.out.println("수정할 내용>>");
							String content = scn.nextLine();

							bd = new Board(num, null, content, null, null, 0);
							dao.update(bd);
						} else {
							System.out.println("수정할 권한이 없습니다.");
						}

					} else if (menu == 3) {
						System.out.println("===글삭제===");
						System.out.println("삭제할 글번호>>> ");
						int num = Integer.parseInt(scn.nextLine());

						dao.getbd(num);
						if (dao.getbd(num).getBoardWriter().equals(id)) {
							dao.delete(num);
							System.out.println(num + "번 글이 삭제되었습니다.");
						} else {
							System.out.println("삭제할 권한이 없습니다.");
						}

					} else if (menu == 4) {
						System.out.println("===글목록보기===");
						List<Board> boardList = dao.search();
//						int viewNum = 0;
//						int pageNum = 1;
						for (Board board1 : boardList) {
					//글목록보기 - 글번호, 글제목, 작성자, 작성일시
							System.out.println(board1.getBoardNum() + " " + board1.getBoardTitle() + " "
									+ board1.getBoardWriter() + " " + board1.getDate());
						}

					} else if (menu == 5) {
						System.out.println("===상세조회===");
						System.out.println("조회할 글번호>>> ");
						int num = Integer.parseInt(scn.nextLine());

						dao.cnt(num); // 조회수 메서드 실행.
						System.out.println(num + "번 글이 조회되었습니다.");
						System.out.println(dao.getbd(num)); // 상세조회 메서드 실행, 출력
						// 글하나 상세조회하면 댓글까지 같이 출력
						List<Reply> reply = dao.searchReply(num);
						if (reply.size() != 0) {
							for (Reply rep : reply) {
								System.out.println("┗ " + rep);
							}
						} else if (reply.size() == 0)
							System.out.println("┗ Null");

						// 댓글달기
						while (true) {
							System.out.println("댓글을 작성하시겠습니까? 1.네 2.아니오");
							System.out.println("입력>>> ");
							int yn = Integer.parseInt(scn.nextLine());
							if (yn == 1) {
								System.out.println("댓글내용입력>>> ");
								String repContent = scn.nextLine();
								re = new Reply(0, num, repContent, id, null);
								dao.reply(re);
							} else if (yn == 2) {
								break;
							}
						}

					} else if (menu == 9) {
						System.out.println("프로그램을 종료합니다.");
						break;

					} else {
						System.out.println("잘못된 메뉴입니다.");
					}
				}
			} else if (dao.login(id, pwd) == -1) {
				System.out.println("아이디를 확인하세요.");
			} else if (dao.login(id, pwd) == -2) {
				System.out.println("비밀번호를 확인하세요.");
			}
		}

	}
}
