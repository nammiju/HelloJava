package co.edu.nested;

class People{
	int height;
	int weight;
	
	void showInfo() {
		System.out.println("showInfo.");
	}
}

class Student extends People{ // People클래스를 상속받는 Student클래스
	int studNo;
}

public class AnonymousExample {
	public static void main(String[] args) {
		// 익명 상속 클래스.
		People people = new People() { // People클래스를 상속받는 익명의 클래스 생성.
	//  부모클래스 변수 = new 부모클래스(){};		
			String color;
			
			@Override
			void showInfo() {
				System.out.println("익명 showInfo.");
				showColor();
			}
			
			void showColor() {
				System.out.println(this.color);
			}
		};
		
	}

}
