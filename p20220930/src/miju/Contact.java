package miju;

// 내용담는 클래스
public class Contact {
	private String name;
	private int phone;
	private String memo;
	
	public Contact() {} // 매개변수가 없는 기본 생성자.

	public Contact(String name, int phone, String memo) {
		super(); // 상속
		this. name =  name;
		this.phone = phone;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", memo=" + memo + "]";
	}
	
	
}
