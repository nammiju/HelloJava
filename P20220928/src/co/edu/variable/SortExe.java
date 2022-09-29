package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = {34, 21, 12}; 
		
		// 반복적인 처리를 통해 numAry의 배열을 작은 순서대로 바꾸고 싶음 
		// 결과가 numAry = {12, 21, 34}; 로 나옴
		// 케이스 : n1 > n2 > n3 
		// 케이스 : n1 < n2 > n3
		
///숫자를 알고 있으문
//		int temp = numAry[0];
//		numAry[0] = numAry[2];
//		numAry[2] = temp;
		
		

		
		//내가 끄적이고 실패한거
//		if(numAry[0] > numAry[2]) {
//			temp = numAry[0];
//			numAry[0] = numAry[2];
//			numAry[2] = numAry[0];
//		}
//		if(numAry[0] > numAry[1]) { 
//			temp= numAry[0]; 
//			numAry[0] = numAry[1]; 
//			numAry[1] = numAry[0];
//		}
		
		//어떤 경우에도 오름차순으로 정렬이 되도록 만들기
		if(numAry[0] > numAry[1]) { // 34 > 21
			int temp = numAry[0]; // 빈 변수에 34를 먼저 옮겨줌 - null 21 12
			numAry[0] = numAry[1]; // 34자리 있었던 빈 자리에 21을 담아줌 - 21 null 12
			numAry[1] = temp; // 다시 1번째 값을 빈공간에 담아줌
	}
		if(numAry[1] > numAry[2]) { 
			int temp = numAry[1]; 
			numAry[1] = numAry[2];  
			numAry[2] = temp;  
		}
		
		if(numAry[0] > numAry[1]) { 
			int temp = numAry[0]; 
			numAry[0] = numAry[1];  
			numAry[1] = temp;  
		}
		
		for(int n : numAry) {
			System.out.println(n);
		}
		for(int n : numAry) {
			System.out.print(n + " ");
		}
		
		int[] nums = { 34, 21, 12, 9}; // 배열의 크기가 4개
		//오름차순 정렬
		
		for(int j=0; j < nums.length -1; j++) {
			for (int i=0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i+1]) { // i=0일때 1번째랑 2번쨰 위치 비교후  첫번째가 더 크면
					int temp = 0;
					temp = nums[i]; // 첫번째값을 temp에 넣기
					nums[i] = nums[i+1]; // 첫번째에 두번째 값 넣기
					nums[i+1] = temp; // 두번째는 첫번쨰에 원래 있던 값 넣기
				}
			}
		}
		for(int n : nums) {
			System.out.println(n);
		}
	
	
	}
}
