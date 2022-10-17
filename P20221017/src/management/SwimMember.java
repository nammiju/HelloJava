package management;

// 회원 정보
public class SwimMember {
	private int memberCode;
	private String memberName;
	private String memberBirth;
	private String gender;
	private String memberPhone;
	private int classCode;
	private String date;

	public SwimMember(int memberCode, String memberName, String memberBirth, String gender,
			String memberPhone,int classCode, String date) {
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.gender = gender;
		this.memberPhone = memberPhone;
		this.classCode = classCode;
		this.date = date;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "회원코드: " + memberCode + ", 회원이름: " + memberName + ", 생년월일: " + memberBirth //
				+ "수강강좌" + classCode + ", 성별: " + gender + ", 연락처: " + memberPhone + ", 등록일: " + date;
	}
}
