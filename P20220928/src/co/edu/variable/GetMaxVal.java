package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5]; // 값을 안주고 크기만 5로 정함. 정수를 5개 담을 수 있는 배열 생성. 그 배열의 이름은 randomAry. 크기를 한번선언하면 고정됨.
		randomAry[0] = (int) (Math.random() * 100) + 1; // Math.random(): 0 ~ 1 사이의 임의의 수 생성. 1 ~ 10 사이의 임의의 실수 생성 후 (int)로 실수로 바까줌
		randomAry[1] = (int) (Math.random() * 100) + 1;
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;
	
		int maxVal = 0; // 배열 요소 중 가장 큰 값을 저장하기 위한 용도.
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
			// maxVal 변수에 두 값을 비교해서 큰값을 담기.
			if(maxVal < randomAry[i]) {
				maxVal = randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값중 최대값은? => " + maxVal);	
		
		int minVal = randomAry[0];
		for(int i=0; i<5; i++) {
			if(minVal > randomAry[i]) {
				minVal = randomAry[i];
			}
		}
		System.out.println("생성된 배열의 임의의 값중 최소값은? => " + minVal);
	
	}
	

}
