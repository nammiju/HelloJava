package swimprogram;

import java.util.List;
import java.util.Scanner;

public class SwimManagementApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SwimApplyDAO saDao = new SwimApplyDAO();

		boolean check = false;
		while (!check) { // 로그인 시작
			System.out.println("로그인하세요.");
			System.out.print("아이디 입력>>> ");
			String id = scn.nextLine();
			System.out.print("패스워드 입력>>> ");
			String pwd = scn.nextLine();

			int log = saDao.login(id, pwd); // 로그인

			if (log == 0) {
				System.out.println(" 관리자 계정 로그인 성공");
				check = true;
				// 리턴값이 0이면 아이디 비번 다 일치하므로 최상위 while문을 false로 만들어
				// 최상위 while문을 중단시키고 아래에 있는 while문을 실행함
			} else if (log == -1) {
				System.out.println("아이디를 확인하세요.");
			} else if (log == -2) {
				System.out.println("비밀번호를 확인하세요.");
			}
		} // 로그인 끝

		mainProgram();

		System.out.println("프로그램 종료.");
	} // end of main

	public static void mainProgram() {
		Scanner scn = new Scanner(System.in);
		boolean main = true;

		while (main) { // 메인메뉴 시작
			System.out.println("===메인메뉴===");
			System.out.println("1.강좌관리 2.회원관리 3.강사관리 4.수강관리 5.프로그램종료");
			System.out.print("선택>>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				classManagement();

			} else if (menu == 2) {
				membermanagement();

			} else if (menu == 3) {
				teachermanagement();

			} else if (menu == 4) {
				applymanagement();

			} else if (menu == 5) {
				main = false;
				break;
			}
		}
	} // 메인메뉴 끝

	public static void classManagement() {
		SwimApplyDAO saDao = new SwimApplyDAO();
		SwimClassDAO scDao = new SwimClassDAO();
		SwimClass sc = null;
		Scanner scn = new Scanner(System.in);

		boolean upA = true; // 강좌관리메뉴 시작으로 가도록 해줄 while문의 변수
		while (upA) {
			System.out.println("===강좌관리메뉴===");
			System.out.println("1.강좌등록 2.강좌수정 3.강좌목록조회 9.메인메뉴이동");
			System.out.print("선택>>> ");
			int menuA = Integer.parseInt(scn.nextLine());

			if (menuA == 1) {
				System.out.println("===강좌등록===");
				System.out.println("등록할 강좌명 입력하기>>  ");
				String scInfo = scn.nextLine();
				System.out.println("담당 강사코드 입력하기>>  ");
				int code = Integer.parseInt(scn.nextLine());

				sc = new SwimClass(0, scInfo, code, 0); // 강좌코드(자동생성), 강좌명(입력값), 강사코드, 정원
				scDao.insert(sc);
				
			} else if (menuA == 2) {
				System.out.println("===강좌수정===");
				System.out.println("수정할 강좌코드 입력하기>> ");
				int num = Integer.parseInt(scn.nextLine());

				List<SwimClass> list = scDao.list(new SwimClass(num, null, 0, 0));

				if (list.size() != 0) {
					System.out.println("수정할 강좌명 입력하기>>  ");
					String name = scn.nextLine();
					System.out.println("수정할 강사코드 입력하기>> ");
					int Tcode = Integer.parseInt(scn.nextLine());

					sc = new SwimClass(num, name, Tcode, 0);
					scDao.update(sc);

					
				} else {
					System.out.println("요청하신 강좌코드가 없습니다.");
				}

			} else if (menuA == 3) {
				System.out.println("===강좌목록조회===");
				System.out.println("조회할 강좌코드 입력하기>> \r\n" + "※코드를 모를시 0을 입력해주세요※");
				int clsCode = Integer.parseInt(scn.nextLine());
				System.out.println("조회할 강좌명 입력하기>> \r\n" + "※강좌명을 모를시 엔터를 입력해주세요※");
				String cName = scn.nextLine();
				System.out.println("조회할 강사코드 입력하기>> \r\n" + "※코드를 모를시 0을 입력해주세요※");
				int tCode = Integer.parseInt(scn.nextLine());

//				int memNum = 0;
//				memNum= saDao.membernum(new SwimApply(0, clsCode, 0));

				sc = new SwimClass(clsCode, cName, tCode, 0);
				List<SwimClass> swimList = scDao.list(sc);

				for (SwimClass list : swimList) {
					System.out.println("강좌코드: " + list.getClassCode() + ", 강좌명: " + list.getClassName() //
							+ ", 강사코드: " + list.getTeacherCode() //
							+ ", 잔여인원/총정원: "
							+ (list.getMemberNum() - saDao.membernum(new SwimApply(0, list.getClassCode(), 0))) + "/"
							+ list.getMemberNum()); // 10-수강인원 어케 구하는지 여쭤보기.
				}

			} else if (menuA == 9) {
				System.out.println("강좌관리 종료. 상위메뉴로 이동합니다.");
				upA = false;
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while;
	} // end of classManagement().

	public static void membermanagement() {
		SwimMemberDAO smDao = new SwimMemberDAO();
		SwimMember sm = null;
		Scanner scn = new Scanner(System.in);
		boolean upB = true; // 회원관리메뉴 시작으로 가도록 해줄 while문의 변수
		while (upB) {
			System.out.println("===회원관리메뉴===");
			System.out.println("1.회원등록 2.회원수정 3.회원목록조회 9.메인메뉴이동");
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
				break;

			} else if (menuB == 2) {
				System.out.println("===회원수정===");
				System.out.println("수정할 회원코드 입력하기>> ");
				int num = Integer.parseInt(scn.nextLine());

				List<SwimMember> smList = smDao.list(new SwimMember(num, null, null, null, null, null));

				if (smList.size() != 0) {
					System.out.println("수정할 연락처 입력하기>>");
					String phone = scn.nextLine();

					sm = new SwimMember(num, null, null, null, phone, null);
					smDao.update(sm);
				} else {
					System.out.println("요청하신 회원이 없습니다.");
				}

			} else if (menuB == 3) {
				boolean check = true;
				while (check) {
					System.out.println("===회원목록조회===");
					System.out.println("1.전체목록 2.회원코드로조회 3.이름으로조회 4.성별로조회 9.상위메뉴로이동");
					int num = Integer.parseInt(scn.nextLine());

					if (num == 1) {
						System.out.println("===등록된 전체회원===");
						sm = new SwimMember(0, null, null, null, null, null);
						// 회원코드(자동생성), 이름, 생년월일, 성별, 연락처, 등록일
						List<SwimMember> memList = smDao.list(sm);

						for (SwimMember list : memList) {
							System.out.println("회원코드: " + list.getMemberCode() + ", 이름: " + list.getMemberName() //
									+ ", 생년월일: " + list.getMemberBirth() + ", 성별: " + list.getGender()//
									+ ", 연락처: " + list.getMemberPhone() + ", 등록일: " + list.getCreDates());
						}
					} else if (num == 2) {
						System.out.println("조회할 회원코드 입력하기>> ");
						int code = Integer.parseInt(scn.nextLine());
						sm = new SwimMember(code, null, null, null, null, null);
						// 회원코드(자동생성), 이름, 생년월일, 성별, 연락처, 등록일
						List<SwimMember> memList = smDao.list(sm);

						for (SwimMember list : memList) {
							System.out.println("회원코드: " + list.getMemberCode() + ", 이름: " + list.getMemberName() //
									+ ", 생년월일: " + list.getMemberBirth() + ", 성별: " + list.getGender()//
									+ ", 연락처: " + list.getMemberPhone() + ", 등록일: " + list.getCreDates());
						}
					} else if (num == 3) {
						System.out.println("조회할 회원이름 입력하기>> ");
						String name = scn.nextLine();
						sm = new SwimMember(0, name, null, null, null, null);
						// 회원코드(자동생성), 이름, 생년월일, 성별, 연락처, 등록일
						List<SwimMember> memList = smDao.list(sm);

						for (SwimMember list : memList) {
							System.out.println("회원코드: " + list.getMemberCode() + ", 이름: " + list.getMemberName() //
									+ ", 생년월일: " + list.getMemberBirth() + ", 성별: " + list.getGender()//
									+ ", 연락처: " + list.getMemberPhone() + ", 등록일: " + list.getCreDates());
						}
					} else if (num == 4) {
						System.out.println("조회할 성별 입력하기>> 예) 남/여");
						String gender = scn.nextLine();
						sm = new SwimMember(0, null, null, gender, null, null);
						// 회원코드(자동생성), 이름, 생년월일, 성별, 연락처, 등록일
						List<SwimMember> memList = smDao.list(sm);

						for (SwimMember list : memList) {
							System.out.println("회원코드: " + list.getMemberCode() + ", 이름: " + list.getMemberName() //
									+ ", 생년월일: " + list.getMemberBirth() + ", 성별: " + list.getGender()//
									+ ", 연락처: " + list.getMemberPhone() + ", 등록일: " + list.getCreDates());
						}
					} else if (num == 9) {
						System.out.println("상위메뉴로 이동합니다.");
						check = false;
						break;
					}
				}
			} else if (menuB == 9) {
				System.out.println("회원관리 종료. 상위메뉴로 이동합니다.");
				upB = false;
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}
	}

	public static void teachermanagement() {
		SwimTeacherDAO stDao = new SwimTeacherDAO();
		SwimTeacher st = null;
		Scanner scn = new Scanner(System.in);

		boolean upC = true; // 강사관리메뉴 시작으로 가도록 해줄 while문의 변수

		while (upC) {
			System.out.println("===강사관리메뉴===");
			System.out.println("1.강사등록 2.강사수정 3.강사목록조회 9.메인메뉴이동");
			System.out.print("선택>>> ");
			int menuC = Integer.parseInt(scn.nextLine());
			if (menuC == 1) {
				System.out.println("===강사등록===");
				System.out.println("등록할 강사명 입력하기>> ");
				String name = scn.nextLine();
				System.out.println("메모 입력하기>> ");
				String memo = scn.nextLine();

				st = new SwimTeacher(0, name, null, memo);
				// 강사코드(자동생성), 강사명(입력값), 강좌코드, 메모(입력값)
				stDao.insert(st);

			} else if (menuC == 2) {
				System.out.println("===강사수정===");
				System.out.println("수정할 강사명 입력하기>> ");
				String tname = scn.nextLine();

				List<SwimTeacher> stList = stDao.list(new SwimTeacher(0, tname, null, null));

				if (stList.size() != 0) {
					System.out.println("수정할 강좌코드 입력하기>> ");
					String cla = scn.nextLine();
					System.out.println("수정할 메모 입력하기>> \r\n" + "※수정할 메모가 없을시 엔터를 입력해주세요※");
					String memo = scn.nextLine();

					st = new SwimTeacher(0, tname, cla, memo);
					stDao.update(st);
				} else {
					System.out.println("요청하신 강사가 없습니다.");
				}

			} else if (menuC == 3) {
				System.out.println("===강사목록조회===");

				List<SwimTeacher> stList = stDao.list(new SwimTeacher(0, null, null, null));
				for (SwimTeacher list : stList) {
					System.out.println("강사코드: " + list.getTeacherCode() //
							+ ", 강사명: " + list.getTeacherName() //
							+ ", 담당강좌코드: " + list.getClassCode() //
							+ ", 메모: " + list.getMemo() //
					);
				}
			} else if (menuC == 9) {
				System.out.println("강사관리 종료. 상위메뉴로 이동합니다.");
				upC = false;
				break;
			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while;
	}

	public static void applymanagement() {
		SwimApplyDAO saDao = new SwimApplyDAO();
		SwimApply sa = null;
		Scanner scn = new Scanner(System.in);

		boolean upD = true; // 수강관리메뉴 시작으로 가도록 해줄 while문의 변수

		while (upD) {
			System.out.println("===수강관리메뉴===");
			System.out.println("1.수강등록 9.메인메뉴이동");
			System.out.print("선택>>> ");
			int menuD = Integer.parseInt(scn.nextLine());

			if (menuD == 1) {
				System.out.println("===수강등록===");
				System.out.println("수강등록할 회원코드 입력하기>> ");
				int smCode = Integer.parseInt(scn.nextLine());
				System.out.println("등록할 강좌코드 입력하기>> ");
				int scCode = Integer.parseInt(scn.nextLine());

				sa = new SwimApply(0, scCode, smCode);
				// 수강코드, 강좌코드, 회원코드
				int result = saDao.insert(sa);
				if (result == -1) {
					System.out.println("신청가능한 강좌수를 초과하였습니다.");
				} else if (result == -2) {
					System.out.println(sa.getMemberCode() + "회원이 " + sa.getClassCode() + " 강좌에 등록되었습니다.");
				} else if (result == -3) {
					System.out.println("수강할 수 있는 정원을 초과하였습니다.");
				}

			} else if (menuD == 9) {
				System.out.println("수강관리 종료. 상위메뉴로 이동합니다.");
				upD = false;
				break;
			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while;
	}
}
