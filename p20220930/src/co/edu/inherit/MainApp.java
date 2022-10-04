package co.edu.inherit;

public class MainApp { // 메인 메소드를 담고 있는 클래스 생성
	public static void main(String[] args) {
		Child child = new Child(); // Child - field1, method1
		child.method(); // Parent의 메소드.
		child.method1(); // Child의 메소드.
		
		Child2 child2 = new Child2();
		child2.method(); // Parent 클래스로부터 상속을 받아서 자식클래스인 Child2에서도 사용이 가능하다.
		child2.method2(); // Child2의 메소드.
		
		Parent c1 = new Parent(); 
		c1 = new Child(); // 부모클래스의 변수에 자식클래스의 인스턴스를 대입 가능하다.
		c1 = new Child2(); // 자동형변환(자식인스턴스가 부모인스턴스로 자동으로 형변환이 일어난다.)
		
//		c1 .method2(); // 부모클래스의 멤버들만 호출이 가능하다.
		
		if(c1 instanceof Child2) { // instanceof: c1이라는 변수가 Child2클래스를 상속하는지 아닌지 트루 폴스 나옴.
			Child2 c2 = (Child2) c1; // 강제형변환(casting)
			c2.method2();
		}
		
		Parent c3 = new Parent(); // 문법상 오류는 아니지만 실행하면 오류가 난다.
		if(c3 instanceof Child2) { // c3 변수가 Child2 타입의 변수가 맞는지 확인
			Child2 c4 = (Child2) c3; // casting.
			c4.method2();
		}
	}

}
