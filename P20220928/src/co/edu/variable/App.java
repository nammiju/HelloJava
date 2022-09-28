package co.edu.variable;

// 자바는 class에서 시작한다.
// 클래스의 main 메소드로 시작.
public class App {
	public static void main(String[] args) { // main 메소드
		System.out.println("매개값을 출력."); // (매개값) 출력하는 기능
		
		// 먼저 변수의 타입을 지정해주고 값을 넣어야 한다. 
		// ex)정수(in, long), 실수(double, float)
		// 참.거짓(boolean), 문자열(String)
		
		int myAge = 25; // 왼쪽과 오른쪽의 타입은 항상 동일해야함.
//		String 내나이 = "스물다섯"; // 변수명을 한글로 쓸 수도 있으나 가급적이면 영문 사용
//		내나이 = "28"; // 변수에 다른 값을 줄수도 있다. "28"은 문자열 28을 의미
	
		int result = myAge + 30;
		System.out.println(myAge + "값과 30을 더하면 " + result + "입니다.");
		
		// 배열
		//let numAry = [];
		int[] numAry = {20, 29, 13, 44, 88, 33}; // 배열 선언
		int sum = 0;
//		1) 배열의 합계
		for (int i = 0; i <6; i++) {
//			System.out.println(numAry[i]);
//			if (numAry[i] % 2 == 0) { // 값이 짝수일 경우에만 합계
//				sum = sum + numAry[i];
			if ( i % 2 == 0) { // 인덱스 번호가 짝수인 경우 합계 
				sum = sum + numAry[i]; 
				}
		}
		System.out.println("짝수의 합계=> " + sum);
		
//		2) 배열 조건/
		sum = 0; // 0 값으로 초기화.
		// 문제: sum의 값이 100을 넘어서는 시점에서 break; 그때의 sum을 출력.
		for(int i = 0; i <6; i++) { 
			sum = sum + numAry[i];
			if(sum > 100) {
				break;
			}
		}
		System.out.println("100을 넘어서는 시점의 sum = " + sum);
		
		
		System.out.println("최종커밋하기");
	}
	
}
