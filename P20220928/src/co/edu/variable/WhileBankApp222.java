package co.edu.variable;

import java.util.Scanner;

// 계좌정보를 선언: 계좌번호, 예금주명, 잔고
// 은행에서 계좌생성: Account[] banks; 
public class WhileBankApp222 {
	public static void main(String[] args) {
		// 메뉴: 0.계좌생성 1.예금 2.출금 3.잔액조회 4.종료
		Account[] banks = new Account[10];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int money = 0;
		while (run) {
			System.out.println("0.계좌생성 1.예금 2.출금 3.잔액조회 4.종료");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				// 예금기능. 계좌번호, 입금액 묻기
				System.out.println("입금할 계좌번호를 입력하세요. >>> ");
				String accNo = scn.nextLine();
				System.out.println("예금할 금액을 입력하세요. >>> ");
				int input = scn.nextInt();

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNo.equals(accNo)) {
						banks[i].balance = banks[i].balance + input;
						System.out.println(
								"예금주: " + banks[i].owner + " " + input + "원이 입금되었습니다. 잔액: " + banks[i].balance);
					}
				}
			} else if (menu == 2) {
				System.out.println("출금할 계좌번호를 입력하세교. >>>");
				String accNo = scn.nextLine();
				System.out.println("출금할 금액을 입력하세요. >>> ");
				int output = scn.nextInt();

				for (int i = 0; i < banks.length; i++) {  //if문 안에  if문 넣어서 가로로 조금 더 간결하게 수정함
					if (banks[i] != null && banks[i].accNo.equals(accNo)) {
						if (output > banks[i].balance) {
							System.out.println("잔고에 돈이 부족합니다.");
							break;
						} else {
							banks[i].balance = banks[i].balance - output;
							System.out.println(
									"예금주: " + banks[i].owner + " " + output + "원이 출금되었습니다. 잔액: " + banks[i].balance);
						}
					}
				}
			} else if (menu == 3) {
				System.out.println("조회할 계좌번호를 입력하세요. >>> ");
				String accNo = scn.nextLine();
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && banks[i].accNo.equals(accNo)) {
						System.out.println("예금주: " + banks[i].owner + " 잔액: " + banks[i].balance);
					}
				}
			} else if (menu == 4) {
				System.out.println("종료하였습니다.");
				run = false;
			} else if (menu == 0) {
				// 계좌번호 생성.
				System.out.println("생성할 계좌번호를 입력하세요. >>>");
				String accNo = scn.nextLine();
				System.out.println("예금주명을 입력하세요. >>>");
				String owner = scn.nextLine();

				Account acc = new Account(); // 인스턴스 생성.
				acc.accNo = accNo;
				acc.owner = owner;

				for (int i = 0; i < banks.length; i++) {
					if (banks[i] == null) {
						// 한건 입력. break;
						banks[i] = acc;
						break;
					}
				}
				System.out.println("계좌생성완료");
			}
		}
	}
}