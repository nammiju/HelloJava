package co.edu;

import java.util.Arrays;

public class Student { // public: 다른 클래스에서 이 클래스를 사용할 수 있다.
	// 필드.
	private String id; // private: 외부클래스에서 직접 접근을 못하게 함.
	private String name;
	private String major;
	private int age; // 정수값 23, 0,-12 등의 값이 들어갈 수 있으나 '나이'라는 의미랑 맞지않을 수 있음
	private String[] hobbies = new String[5];
	
	// 정적 메소드. static이 붙어있음
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}

	// 생성자(필드의 값을 초기화), 생성자 오버로딩(동일한 이름의 생성자를 여러번 정의)
	public Student() {
		// 매개값이 없는 생성자 => 기본생성자.
		this.name = "기본값";
		this.id = "000-000";
	}
	public Student(String studId, String studName) {
		this.id = studId;
		this.name = studName;		
	}
	public Student(String studId, String studName, String major, int age) {
//		this(); -> 기본생성자를 호줄함.
		this(studId, studName); // -> 위의 메서드의 값을 받아와줌. 
		this.major = major;
		this.age = age;
	}
	
	
	// 매서드.
	// 학번
	void setId(String id) {
		this.id = id;
	}

	String getId() {
		return this.id;
	}

	// 나이
	void setAge(int age) {
		if (age < 0) {
			this.age = 0; // this: 인스턴스를 말함. 매개변수 age가 아닌 필드이름 age를 뜻함
		} else {
			this.age = age;
		}
	}

	int getAge() {
		return this.age;
	}

	// 이름
	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return this.name;
	}

	// 전공
	void setMajor(String major) {
		this.major = major;
	}

	String getMajor() {
		return this.major;
	}

	// 취미
	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for (String hobby : hobbies) {
			for (int i = 0; i < this.hobbies.length; i++) {
				if (this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}

	String[] getHobbies() {
		return this.hobbies;
	}

	String getHobb() {
		String str = "취미는 ";
		for (String hobby : hobbies) {
			if (hobby != null) {
				str += hobby + " ";
			}
		}
		str += "입니다.";
		return str;
	}

	// 취미추가 메서드.
	void addHobby(String hobby) {
		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}
		}
	}

	// showInfo()
	public String showInfo() {
		return "이름은 " + this.name + "이고 학번은 " + this.id + "입니다. 현재 " + this.major + "을 전공하는 " + this.age + "살 학생입니다.";
	}

	void study() {
		System.out.println(name + "은 " + major + " 공부를 한다.");
	}

	void game() {
		System.out.println(name + "은 게임을 한다.");
	}

	void sleep() {
		System.out.println(name + "은 잠을 잔다.");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", major=" + major + ", age=" + age + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	
}
