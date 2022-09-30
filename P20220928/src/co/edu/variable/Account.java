package co.edu.variable;

public class Account { 
	private String accNo; // 계좌번호. 두단어의 조합: 2번째단어의 첫글자는 대문자로 작성하기.
	private String owner; // 예금주.
	private int balance; // 예금액.
	
	// setter, getter 메서드 정의.
	void setAccno(String accno) {
		this.accNo = accno;
	}	
	String getAccno() {
		return this.accNo;
	}
	void setOwner(String owner) {
		this.owner = owner;
	}	
	String getOwner() {
		return this.owner;
	}
	void setBalance(int balance) {
		this.balance = balance;
	}	
	int getBalance() {
		return this.balance;
	}
	
}
