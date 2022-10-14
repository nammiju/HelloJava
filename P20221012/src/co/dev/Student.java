package co.dev;

public class Student {
	private int studNo;
	private String studName;
	private int score;

	Student(int studNo, String studName, int score) { // 생성자 - 값을 담아주기 편하도록
		this.studNo = studNo;
		this.studName = studName;
		this.score = score;
	}

	public int getStudNo() { // 값(필드)를 반환해주는 메소드. 반환타입을 미리 지정해준다.
		return studNo;
	}

	public void setStudNo(int studNo) { //매개값 studNo를 받아와서 필드 값을 지정해주는 메소드.
		this.studNo = studNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	 static void add(Student stud) {
		// TODO Auto-generated method stub
		
	}
	
	
}
