package swimprogram;

public class SwimTeacher {
	private int teacherCode;
	private String teacherName;
	private int classCode;
	private String memo;

	public SwimTeacher(int teacherCode, String teacherName, int classCode, String memo) {
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

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
