package co.edu.inherit.friend;

public class ComFriend extends Friend {
	private String company;
	private String dept;

	public ComFriend() {
		super();
	}

	public ComFriend(String name, String phone, String company, String dept) { // 값을 초기화하기 위해서 생성자 정의.
		super(name, phone); // 부모클래스의 생성자 호출.
		this.company = company;
		this.dept = dept;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String showInfo() {
		// 회사 친구의 정보.
		return "회사친구의 이름은 " + getName() 
				+ ", 연락처는 " + getPhone() 
				+ ", 회사명은 " + this.company
				+ ", 부서는 " + this.dept + "입니다.";
	}

}
