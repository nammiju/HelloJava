package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe2 {
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10]; // 저장공간
	ArrayList friends = new ArrayList();

	// 친구를 등록 - 학교/회사/그외인지 구분해서 등록하도록 하는 기능
	public void exe() {

		while (true) {
			System.out.println("1.친구등록 2.친구조회 3.종료");
			System.out.println("선택 >>>");

			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();
				scn.nextLine();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				}
			} else if (menu == 2) {
				searchFriend();
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
			System.out.println("프로그램 종료.");
		}
	} // end of exe()

	// 추가메소드 정의 공간.
	public void addComFriend() {
		System.out.println("친구의 이름은? >>> ");
		String name = scn.nextLine();

		System.out.println("친구의 연락처는? >>>");
		String phone = scn.nextLine();
		System.out.println("친구의 회사명은? >>> ");
		String com = scn.nextLine();
		System.out.println("친구의 부서는? >>>");
		String dept = scn.nextLine();

		ComFriend cf = new ComFriend(name, phone, com, dept);

		friends.add(cf); // 비워져 있는 위치에 한건 등록.
//		for (int i = 0; i < friends.size(); i++) {
//			if (friends[i] == null) {
//				friends[i] = cf;
//				break;
//			}
//		}
	}

	public void addUnivFriend() {
		System.out.println("친구의 이름은? >>> ");
		String name = scn.nextLine();
		System.out.println("친구의 연락처는? >>>");
		String phone = scn.nextLine();
		System.out.println("친구의 대학은? >>> ");
		String univ = scn.nextLine();
		System.out.println("친구의 전공은? >>>");
		String major = scn.nextLine();

		UnivFriend uf = new UnivFriend(name, phone, univ, major);

		friends.add(uf);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = uf;
//				break;
//			}
//		}
	}

	public void addFriend() {
		System.out.println("친구의 이름은? >>> ");
		String name = scn.nextLine();
		System.out.println("친구의 연락처는? >>>");
		String phone = scn.nextLine();

		Friend f = new Friend(name, phone);

		friends.add(f);
//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] == null) {
//				friends[i] = f;
//				break;
//			}
//		}
	}

	public void searchFriend() {
		System.out.println("1.전체목록 2.친구조회");
		int num = scn.nextInt();
		if (num == 1) {
			for (Object friend : friends) {
				String list = (String) friend;
				System.out.println(list);
			}
		} else if (num == 2) {
			System.out.println("조회할 친구의 이름은? >>>");
			String name = scn.nextLine();
			for (int i = 0; i < friends.size(); i++) {
				// Friend 클래스의 상속. Friend, ComFriend, UnivFriend
				Object frnd = friends.get(i);
				if (frnd instanceof Friend) { // frnd라는 변수의 타입을 알려줌. 여기는 Friend
					Friend friend = (Friend) frnd; // 형변환
					System.out.println(friend.showInfo());

				} else if (frnd instanceof ComFriend) {
					ComFriend friend = (ComFriend) frnd;
					System.out.println(friend.showInfo());

				} else if (frnd instanceof UnivFriend) {
					UnivFriend friend = (UnivFriend) frnd;
					System.out.println(friend.showInfo());
				}

			}
//			{
//				if (friends[i] != null && friends[i].getName().equals(name)) { //.equals() 대신에 .contains()사용하면 문자 
//					// 권미현, 권수미, 강민기 가 있을 때 "미"만 넣어도 "미" 문자열이 포함된 것을 다 찾아줌
//					System.out.println(friends[i].showInfo());
//				}
//			}
		}
	}
}