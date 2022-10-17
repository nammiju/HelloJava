package management;

//강좌 정보
public class SwimClass {
	private int classCode;
	private String className;
	private String classTeacher;
	private int classMem;

	public SwimClass(int classCode, String className, String classTeacher, int classMem) {
		this.classCode = classCode;
		this.className = className;
		this.classTeacher = classTeacher;
		this.classMem = classMem;
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

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public int getClassMem() {
		return classMem;
	}

	public void setClassMem(int classMem) {
		this.classMem = classMem;
	}

	@Override
	public String toString() {
		return "강좌코드: " + classCode + ", 강좌명: " + className + ", 강사: " + classTeacher + ", 수강인원(명): " + classMem;

	}

}
