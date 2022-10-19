package swimprogram;

public class SwimApply {
	private int applyCode;
	private int classCode;
	private int memberCode;

	public SwimApply(int applyCode, int classCode, int memberCode) {
		this.applyCode = applyCode;
		this.classCode = classCode;
		this.memberCode = memberCode;
	}

	public int getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(int applyCode) {
		this.applyCode = applyCode;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	
	
}
