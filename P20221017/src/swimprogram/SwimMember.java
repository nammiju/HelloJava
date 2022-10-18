package swimprogram;

public class SwimMember {
	private int memberCode;
	private String memberName;
	private String memberBirth;
	private String gender;
	private String memberPhone;
	private String creDates;
	
	public SwimMember(int memberCode, String memberName, String memberBirth, String gender,
			String memberPhone, String creDates) {
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.gender = gender;
		this.memberPhone = memberPhone;
		this.creDates = creDates;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
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

	public String getCreDates() {
		return creDates;
	}

	public void setCreDates(String creDates) {
		this.creDates = creDates;
	}
	
	
}
