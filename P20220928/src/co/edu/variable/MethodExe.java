package co.edu.variable;

public class MethodExe {
	
	// main 메소드: 첫번째 실행.
	public static void main(String[] args) {
//		printStar();
//		printStar(3); //매개변수가 들어감
//		printCircle("@");
//		printCircle("◆", 5);
//		int result = sum(2, 3);
		int result = sum(sum(2, 3), sum(3, 4)); // sum(2,3)의 값과 sum(3,4)의 값을 다시 sum의 매개값으로 사용
		System.out.println("최종값은 " + result);
		
}
	
	
	public static void printStar() { // 반환값: 없음(void가 반환값 없다고 정해놓은거임), 매개변수: 없음.
		System.out.println("★");
	}
	
	public static void printStar(int times) { // 반환값: 없음, 매개변수: times
		for(int i = 0; i < times; i++) {
			System.out.println("★");
		}
	}
	
	public static void printCircle(String Circle) { // 넣은값(매개변수)을 출력해줌
		System.out.println(Circle); 
	}
	
	// 출력할 모양, 갯수를 모두 매개변수로 받아와서 처리함. 매개변수는 필요에 따라 여러개 설정 가넝
	public static void printCircle(String circle, int times) { // circle 매개변수는 String으로 문자타입만 올 수 있도록 한정함
		for(int i = 0; i < times; i++) {
			System.out.println(circle);
		}
	}
	
	// 반환값을 가지는 메소드.
	public static int sum(int n1, int n2) { //반환값을 가지는 메소드는 반드시 return 값을 적어줘야한당
		int result = n1 * 2 + n2 *3;
		System.out.println("결과값은 " + result);
		return result; // 반환값의 유형은 선언한 값과 같아야함. 이 경우 static 뒤에 int로 정해놨기 때문에 int값만 반환된당
	}
	
	
}
