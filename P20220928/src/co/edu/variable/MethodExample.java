package co.edu.variable;

public class MethodExample {
	// 가로, 세로 값을 넣어주면 => 넓이가 나옴
	public static int getArea(int garo, int sero) {
		int res = garo*sero;
		return res;
	}
	
	// 배열요소의 각 값의 합을 반환하는 메소드
	public static int sumAry(int[] ary) { 
		int sum = 0;
		for(int i = 0; i < ary.length; i++) {
			sum= sum + ary[i];
		}
		return sum;
	}
	//두 수를 나눈 결과를 반환하는 메소드
	public static double divide(double n1, double n2) {
		double result = n1 / n2;
		return result;
	}
	
	//두 수를 나누는 작업. 매개변수를 int타입으로 지정.
	public static double divide(int n1, int n2) {
		// 유형: 정수 - byte(1), short(2), int(4), long(8) 계산할때 한쪽의 작은값을 자동으로 다른쪽의 큰타입으로 변환해서 계산함
		// 유형: 실수 - float(4), double(8) 
		// 1bit * 8 = 1byte.
		if(n2 == 0) {
			return 0;
		}		
		double result = (double) n1 / n2; // 3.0 / 2.0 = 1.5
		return result;
	}
	
	
		
	public static void main(String[] args) {
		int result = getArea(20, 15);
		System.out.println("전체 넓이는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry);
		System.out.println("전체 배열요소의 합계는 " + result);

		int[] intAry2 = {23, 45, 12, 55};
		result = sumAry(intAry2);
		System.out.println("전체 배열요소의 합계는 " + result);

		// 실수 처리. float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2; // = 기준으로 오른쪽 왼쪽의 값의 형식이 같아야 함.
		
		d3 = divide(d1, d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 =divide(3, 0);
		System.out.println("나눈 결과는 " + d3);
	}
}
