package swimprogram;

import java.util.List;
import java.util.Scanner;

public class SwimManagementApp {
	public static void main(String[] args) {
		SwimMemberDAO smDao = new SwimMemberDAO();
		SwimClassDAO scDao = new SwimClassDAO();
		SwimTeacherDAO stDao = new SwimTeacherDAO();
		SwimApplyDAO saDao = new SwimApplyDAO();

		Scanner scn = new Scanner(System.in);
		SwimClass sc = null;
		SwimMember sm = null;
		SwimTeacher st = null;
		SwimApply sa = null;

		boolean check = false;
		while (!check) { // 로그인 시작
			System.out.println("로그인하세요.");
			System.out.print("아이디 입력>>> ");
			String id = scn.nextLine();
			System.out.print("패스워드 입력>>> ");
			String pw = scn.nextLine();

			saDao.login(id, pw); // 로그인

			if (scDao.login(id, pw) == 0) {
				System.out.println(id + " 계정 로그인 성공");
				check = true;
				// 리턴값이 0이면 아이디 비번 다 일치하므로 최상위 while문을 false로 만들어
				// 최상위 while문을 중단시키고 아래에 있는 while문을 실행함

				while (true) { // 메인메뉴 시작
					System.out.println("===메인메뉴===");
					System.out.println("a.강좌관리 b.회원관리 c.강사관리 d.수강관리 e.프로그램종료");
					System.out.print("선택>>> ");
					String menu = scn.nextLine();

					if (menu.equals("a")) {
						System.out.println("===강좌관리메뉴===");
						System.out.println("1.강좌등록 2.강좌수정 3.강좌목록조회 9.메인메뉴이동");
						System.out.print("선택>>> ");
						int menuA = Integer.parseInt(scn.nextLine());
						if (menuA == 1) {
							System.out.println("===강좌등록===");
							System.out.println("등록할 강좌명 입력하기>>  예)오전 초급반");
							String scInfo = scn.nextLine();
							sc = new SwimClass(0, scInfo, 0, 0); // 강좌코드(자동생성), 강좌명(입력값), 강사코드, 정원
							scDao.insert(sc);

						} else if (menuA == 2) {
							System.out.println("===강좌수정===");
							System.out.println("수정할 강좌코드 입력하기>> ");
							int num = Integer.parseInt(scn.nextLine());

							if (sc.getClassCode() == num) {
								System.out.println("수정할 강사코드 입력하기>> ");
								int Tcode = Integer.parseInt(scn.nextLine());

								sc = new SwimClass(num, null, Tcode, 0);
								scDao.update(sc);

							} else {
								System.out.println("요청하신 강좌코드가 없습니다.");
							}

						} else if (menuA == 3) {
							System.out.println("===강좌목록조회===");
							List<SwimClass> swimList = scDao.list();
							for (SwimClass list : swimList) {
								System.out.println("강좌코드: " + list.getClassCode() + ", 강좌명: " + list.getClassName() //
										+ ", 강사코드: " + list.getTeacherCode() //
										+ ", 잔여인원/총정원: " + "/" + list.getMemberNum()); // 10-수강인원 어케 구하는지 여쭤보기.
							}
						} else if (menuA == 9) {
							System.out.println("강좌관리를 종료합니다.");
							break;
						} else {
							System.out.println("잘못된 메뉴입니다.");
						}

					} else if (menu.equals("b")) {
						System.out.println("===회원관리메뉴===");
						System.out.println("1.회원등록 2.회원수정 3.회원목록조회 4.회원검색 9.메인메뉴이동");
						System.out.print("선택>>> ");
						int menuB = Integer.parseInt(scn.nextLine());

						if (menuB == 1) {
							System.out.println("===회원등록===");
							System.out.println("등록할 회원정보 입력하기>> 예) 이름 생년월일(년-월-일) 성별(남/여) 연락처 ");
							String smInfo = scn.nextLine();
							String[] smInfos = null;
							smInfos = smInfo.split(" ");
							sm = new SwimMember(0, smInfos[0], smInfos[1], smInfos[2], smInfos[3], null);
							// 회원코드(자동생성), 이름, 생년월일, 성별, 연락처, 등록일
							smDao.insert(sm);

						} else if (menuB == 2) {
							System.out.println("===회원수정===");
							System.out.println("수정할 회원코드 입력하기>> ");
							int num = Integer.parseInt(scn.nextLine());

							if (sm.getMemberCode() == num) {
								System.out.println("수정할 연락처>>");
								String phone = scn.nextLine();
								System.out.println("수정할 강좌코드>>");
								int code = Integer.parseInt(scn.nextLine());

								sm = new SwimMember(num, null, null, null, phone, null);
								smDao.update(sm);
							} else {
								System.out.println("요청하신 회원이 없습니다.");
							}

						} else if (menuB == 3) {
							System.out.println("===회원목록조회===");
							List<SwimMember> memList = smDao.list();
							for (SwimMember list : memList) {
								System.out.println("회원코드: " + list.getMemberCode() //
										+ ", 회원이름: " + list.getMemberName() //
										+ ", 생년월일: " + list.getMemberBirth() //
										+ ", 성별: " + list.getGender() //
										+ ", 연락처: " + list.getMemberPhone() //
										+ ", 수강강좌: " + // sc에 없고 sa에 있는 수강강좌 어케 구하는지 여쭤보기.
										+"등록일: " + list.getCreDates());

							}

						} else if (menuB == 4) {
							System.out.println("===회원검색===");
							System.out.println("검색할 회원코드 또는 회원이름 입력하기>> ");
							String smInfo = scn.nextLine();
							String[] smInfos = null;
							smInfos = smInfo.split(" ");

//						if(smInfos instanceof int) { //쿼리부터 짜기
//							
//						}

//								Integer.parseInt(scn.nextLine());

						} else if (menuB == 9) {
							System.out.println("회원관리를 종료합니다.");
							break;

						} else {
							System.out.println("잘못된 메뉴입니다.");
						}

					} else if (menu.equals("c")) {
						System.out.println("===강사관리메뉴===");
						System.out.println("1.강사등록 2.강사목록조회 9.메인메뉴이동");
						System.out.print("선택>>> ");
						int menuC = Integer.parseInt(scn.nextLine());

						if (menuC == 1) {
							System.out.println("===강사등록===");
							System.out.println("등록할 강사명 입력하기>> ");
							String name = scn.nextLine();
							System.out.println("메모 입력하기>> ");
							String memo = scn.nextLine();

							st = new SwimTeacher(0, name, 0, memo);
							// 강사코드(자동생성), 강사명(입력값), 강좌코드, 메모(입력값)
							stDao.insert(st);

						} else if (menuC == 2) {
							System.out.println("===강사목록조회===");
							List<SwimTeacher> stList = stDao.list();
							for (SwimTeacher list : stList) {
								System.out.println("강사코드: " + list.getTeacherCode() //
										+ ", 강사명: " + list.getTeacherName() //
										+ ", 담당강좌코드: " + list.getClassCode() //
										+ ", 메모: " + list.getMemo() //
								);
							}
						} else if (menuC == 9) {
							System.out.println("강좌관리를 종료합니다.");
							break;
						} else {
							System.out.println("잘못된 메뉴입니다.");
						}

					} else if (menu.equals("d")) {
						System.out.println("===수강관리메뉴===");
						System.out.println("1.수강등록 9.메인메뉴이동");
						System.out.print("선택>>> ");
						int menuD = Integer.parseInt(scn.nextLine());
						if (menuD == 1) {
							System.out.println("===강사등록===");
							System.out.println("등록할 강사명 입력하기>> ");
							String name = scn.nextLine();
							System.out.println("메모 입력하기>> ");
							String memo = scn.nextLine();

							st = new SwimTeacher(0, name, 0, memo);
							// 강사코드(자동생성), 강사명(입력값), 강좌코드, 메모(입력값)
							stDao.insert(st);

						} else if (menuD == 9) {
							System.out.println("강좌관리를 종료합니다.");
							break;
						} else {
							System.out.println("잘못된 메뉴입니다.");
						}
					} else if (menu.equals("e")) {
						System.out.println("프로그램을 종료합니다.");
						break;
					}
				} // 메인메뉴 끝
			} else if (scDao.login(id, pw) == -1) {
				System.out.println("아이디를 확인하세요.");
			} else if (scDao.login(id, pw) == -2) {
				System.out.println("비밀번호를 확인하세요.");
			}
		} // 로그인 끝
	}
}
