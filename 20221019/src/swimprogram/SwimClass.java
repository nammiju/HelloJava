package swimprogram;

public class SwimClass {
	private int classCode;
	private String className;
	private int teacherCode;
	private int memberNum;

	public SwimClass(int classCode, String className, int teacherCode, int memberNum) {
		this.classCode = classCode;
		this.className = className;
		this.teacherCode = teacherCode;
		this.memberNum = memberNum;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(int teacherCode) {
		this.teacherCode = teacherCode;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
	@Override
	public String toString() {
		return  "강좌코드: " + classCode + ", 강좌명: " + className + ", 강사코드: " + teacherCode + ", 수강인원(명): " + memberNum;

		}
	
}
