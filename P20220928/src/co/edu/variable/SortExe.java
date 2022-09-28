package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12}; 
		
		// 반복적인 처리를 통해 numAry의 배열을 작은 순서대로 바꾸고 싶음 
		// 결과가 numAry = {12, 21, 34}; 로 나옴
		// 케이스 : n1 > n2 > n3 
		// 케이스 : n1 < n2 > n3
		
		if(numAry[0] > numAry[1]) { // 34 > 21
			int temp = numAry[0]; // 빈 변수에 34를 먼저 담아줌 - null 21 12
			numAry[0] = numAry[1]; // 34자리 있었던 빈 자리에 21을 담아줌 - 21 null 12
			numAry[1] = numAry[0]; // 
			numAry[1] = temp;
		}
		for(int n : numAry) {
			System.out.println(n);
		}
	}
}
