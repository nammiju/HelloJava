package miju;

import java.util.Scanner;

public class ContactDAO {
	private static ContactDAO instance = new ContactDAO();

	private ContactDAO() {
	}

	public static ContactDAO getInstance() {
		return instance;
	}

	Scanner scn = new Scanner(System.in);
	Contact[] myContacts = new Contact[100];

	// 1. 연락처 등록
	public void addContact() {
		System.out.println("연락처 등록 메뉴입니다.");
		System.out.println("등록할 연락처를 입력하세요.('-' 제외) >>>");
		int phone = scn.nextInt();
		scn.nextLine();
		System.out.println("연락처에 저장할 이름을 입력하세요. >>>");
		String name = scn.nextLine();
		System.out.println("연락처에 저장할 메모를 입력하세요. >>>");
		String memo = scn.nextLine();

		Contact con = new Contact(name, phone, memo);
		for (int i = 0; i < myContacts.length; i++) {
			if (myContacts[i] == null) {
				myContacts[i] = con;
				break;
			}
		}
	}

	// 2. 모든 연락처 보기
	public void allContact() {
		System.out.println("모든 연락처 보기 메뉴입니다.");
		System.out.println("=====================================");
		for (Contact con : myContacts) {
			if (con != null) {
				System.out.println(con.toString());
			}
		}
		System.out.println("=====================================");

	}

	// 3. 연락처 검색
	public void searContact() {
		System.out.println("연락처 검색 메뉴입니다.");
		System.out.println("검색할 연락처 정보를 입력하세요.");
		System.out.println("이 름 >>>");
		String name1 = scn.nextLine();
		scn.nextLine();
		boolean check = true;
		for (int i = 0; i < myContacts.length; i++) {
			if (myContacts[i] != null && (myContacts[i].getName().equals(name1))) {
				System.out.println(
						"이름: " + name1 + " 연락처: " + myContacts[i].getPhone() + " 메모: " + myContacts[i].getMemo());
				check = false;
			}
		}
		if (check == true) {
			System.out.println(name1+ "씨는 없는 연락처입니다.");
		}
	}

	// 4. 연락처 수정
	public void modiContact() {
		System.out.println("연락처 수정 메뉴입니다.");
		System.out.println("수정할 연락처 정보를 입력하세요.");
		System.out.println("이 름 >>>");
		String name2 = scn.nextLine();
		scn.nextLine();

		boolean check = true;
		for (int i = 0; i < myContacts.length; i++) {
			if (myContacts[i] != null && (myContacts[i].getName().equals(name2))) {
				System.out.println("수정할 연락처를 입력하세요. >>>");
				int newPhone = scn.nextInt();
				System.out.println("수정할 메모를 입력하세요. >>>");
				String newMemo = scn.nextLine();
				myContacts[i].setPhone(newPhone);
				myContacts[i].setMemo(newMemo);
				System.out.println(
						name2 + "씨의 연락처를 " + myContacts[i].getPhone() + "메모는 " + myContacts[i].getMemo() + "로 수정했습니다.");
				check = false;
			}
		}
		if (check == true) {
			System.out.println(name2 + "씨는 등록된 연락처가 아닙니다.");
		}

	}

	// 5. 연락처 삭제
	public void delContact() {
		System.out.println("연락처 삭제 메뉴입니다.");
		System.out.println("삭제할 연락처 정보를 입력하세요.");
		System.out.println("이 름 >>>");
		String name = scn.nextLine();

		boolean check = true;
		for (int i = 0; i < myContacts.length; i++) {
			if (myContacts[i] != null && (myContacts[i].getName().equals(name))) {
				myContacts[i] = null;
				System.out.println(name + "씨의 정보를 삭제했습니다.");
				check = false;
			}
		}
		if (check == true) {
			System.out.println(name + "씨는 등록된 연락처가 아닙니다.");
		}
	}

	// 6. 전체 메뉴 확인
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.연락처 등록 2.모든 연락처 보기 3.연락처 검색 4.연락처 수정 5.연락처 삭제 9.종료");
			System.out.print("메뉴를 선택하세요. >>>");

			int menu = scn.nextInt();
			switch (menu) {
			case 1:
				addContact();
				break;
			case 2:
				allContact();
				break;
			case 3:
				searContact();
				break;
			case 4:
				modiContact();
				break;
			case 5:
				delContact();
				break;
			case 9:
				run = false;
				break;
			default: // 정해놓은 케이스 말고 다른거 적으면 실행되는 것.
				System.out.println("없는 메뉴입니다.");
			}

		} // end of while
		System.out.println("프로그램 종료.");
	} // end of exe()
}
