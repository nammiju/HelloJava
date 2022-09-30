package co.edu;

// 하나의 실행클래스와 여러개의 라이브러리 클래스가 필요하다.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
		Person kim = new Person(); // 인스턴스(실체)를 생성.
		kim.name = "김민기";
		kim.age = 20;
		kim.sleep();
		kim.eat("사과");

		Person lee = new Person();
		lee.name = "이순신";
		lee.age = 25;
		lee.sleep();
		lee.eat("피자");

//		System.out.println(kim);

		Student stud1 = new Student();
//		stud1.id = "1212";
		stud1.setId("1212");
//		stud1.name = "홍길동";
		stud1.setName("홍길동");
//		stud1.major = "컴퓨터공학";
		stud1.setMajor("컴퓨터공학");

		stud1.study();
		stud1.game();
		stud1.sleep();

		Student stud2 = new Student();
//		stud2.id = "3434";
		stud2.setId("3434");
//		stud2.name = "임꺽정";
		stud2.setName("임꺽정");
//		stud2.major = "경영학";

		Student stud3 = new Student();

		Student[] students;
		students = new Student[] { stud1, stud2, stud3 };
		for (Student stud : students) {
//			System.out.println("학번: " + stud.id + ", 학생이름: " + stud.name);
			System.out.println("학번: " + stud.getId() + ", 학생이름: " + stud.getName());

			// 상속.
			WorkMan wman = new WorkMan(); // WorkMan 클래스엔 name 속성이 없지만 부모 클래스인 Person으로부터 상속받았기때문에 name속성을 쓸 수 있다.
			wman.name = "직장인";
			wman.age = 30;

			StudMan sman = new StudMan();
			sman.school = "고등학교";
			sman.height = 164.3;

		}
	}
}
