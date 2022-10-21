package swimprogram;

public class SwimTeacher {
	private int teacherCode;
	private String teacherName;
	private String classCode;
	private String memo;

	public SwimTeacher(int teacherCode, String teacherName, String classCode, String memo) {
		this.teacherCode = teacherCode;
		this.teacherName = teacherName;
		this.classCode = classCode;
		this.memo = memo;
	}

	public int getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(int teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
