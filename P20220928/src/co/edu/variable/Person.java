package co.edu.variable;

// 추상화: 
public class Person { // Person은 속성값도 담을 수 있고 기능도 담을 수 있는 복합적인 개체
	//속성 => 필드
	String name; //이름
	int age;
	double height;
	
	//기능 => 메소드
	void laugh() {
		System.out.println("웃는다.");
	}
	void sleep() {
		System.out.println("잠을 잡니다.");
	}
}
