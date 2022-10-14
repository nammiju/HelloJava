package co.edu.nested;

class Person { // 클래스의 멤버: 필드, 생성자, 메소드, 클래스
	// 필드
	String name;
	int age;

	// 생성자
	Person() {
	}

	// 메소드
	void showInfo() {
		// 로컬 클래스: 생성자 또는 메소드 내부에서 선언되는 중첩클래스
		class Local {
			void show() {
				System.out.println("show.");
			}
		}
		Local local = new Local(); // 인스턴스 할당
		local.show();
	}

	// Inner 클래스(인스턴스 선언해야만 사용할 수 있는 클래스): 클래스의 멤버로서 선언되는 중첩 클래스
	class Car {
		String carName;

		void rum() {
			System.out.println("run.");
		}
	}

	// Inner 클래스(정적)
	static class Calculator {
		void add() {
			System.out.println("add.");
		}
	}

	class Run implements Runnable { // Runnable 인터페이스를 구현한 클래스라서 Runnable에 있는 메소드를 반드시 구현해줘야한다.
		@Override
		public void run() {
			System.out.println("run 구현."); 
		}
	}

	// Inner 인터페이스.
	interface Runnable {
		void run();
	}
}

public class NestedExample {
	public static void main(String[] args) {
		Person p = new Person();

		// 인스턴스 멤버 클래스.
		Person.Car car = p.new Car(); // 내부클래스 인스턴스 생성 후 호출 가능.
		car.rum();

		// 정적 멤버 클래스.
		Person.Calculator cal = new Person.Calculator(); // 클래스이름.내부클래스이름으로 호출가능
		cal.add();

		p.showInfo(); // 로컬클래스 호출.
	}

}
