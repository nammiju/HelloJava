package co.edu.nested;

// 익명구현 객체.
// 추상메소드가 하나만 존재하는 인터페이스: Functional 인터페이스.
interface MyInterface {
	void run();
}

interface MyInterface2 {
	void run(String kind); // 문자열타입 kind를 매개값으로 받는 메소드 run.
}

interface MyInterface3 { // 매개값과 반환값이 있는 인터페이스.
	int sum(int num1, int num2);

}

public class AnonymousExample3 {
	public static void main(String[] args) {

//		MyInterface intf = new MyInterface() {
//			@Override
//			public void run() {
//				System.out.println("MyInterface Run.");
//			}
//		};

		// 람다표현식. (기능을 구현할때 사용하면 보기에 간편해짐)
		// 매개값과 반환타입이 없는 경우나 Functional 인터페스의 경우만 람다표현식 쓸 수 있음.
		MyInterface intf = () -> System.out.println("MyInterface Run.");
		intf.run();

//		MyInterface2 intf2 = new MyInterface2() {
//			@Override
//			public void run(String kind) {
//				System.out.println(kind + " Run.");
//			};
//		};
//		intf2.run("농구종목");
		MyInterface2 intf2 = kind -> System.out.println(kind + " Run.");
		intf2.run("농구종목");

//		MyInterface3 intf3 = new MyInterface3() {
//			@Override
//			public int sum(int num1, int num2) {
//				return num1 * 2 + num2;
//			}
//		};
//		int result = intf3.sum(10, 20);
		MyInterface3 intf3 = (num1, num2) -> num1 * 2 + num2;
		int result = intf3.sum(10, 20);

		intf3 = (num1, num2) -> num1 * 2 + num2 * 3;
		result = intf3.sum(11, 22);
		
		

	}
}
