package co.edu;

public class AppMain2 { // AppMain2는 public 이라소 외부 클래스에서 접근이 가넝하다.
	public static void main(String[] args) {

		Student.staticMethod(); // 사용법: 클래스이름.메소드이름();

		Math.random();
		Math.round(.5);

		Student s1 = new Student(); // Student
//		s1.staticMethod(); // 에러는 아닌데 부자연스럽다는 경고는 뜬다.

		s1.setId("111-111");
		s1.setName("홍길동");
		s1.setMajor("컴퓨터공학");
		s1.setAge(20);

		System.out.println(s1.getId()); // 값이 들어가기 전엔 초기값인 null이 출력된다.
		System.out.println(s1.getAge()); // 초기값 0 출력
		System.out.println(s1.showInfo());

		System.out.println("여기 >>>>" + s1);

		Student s2 = new Student();
		s2.setName("김민수");
		s2.setId("111-222");
		s2.setMajor("전자공학");
		s2.setAge(23);
		System.out.println(s2.showInfo());

		String[] hob = { "독서", "자전거" };
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());

		System.out.println(s2.getHobb());

		Student s3 = new Student(); // 생성자 호출
		System.out.println(s3.getName());

		Student s4 = new Student("111-234", "주소영", "경영학", 23);
		System.out.println(s4.showInfo());

		Student s5 = new Student("111-345", "송지은", "건축학", 24);
		System.out.println(s5.showInfo());
	}
}
