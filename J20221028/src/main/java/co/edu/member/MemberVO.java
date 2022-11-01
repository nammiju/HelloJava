package co.edu.member;

public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String responsibility;

	public MemberVO() {
	}

	public MemberVO(String id, String passwd, String name, String email, String responsibility) {
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
		this.responsibility = responsibility;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", responsibility="
				+ responsibility + "]";
	}
}
