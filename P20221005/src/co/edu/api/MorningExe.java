package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int num = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("%2d",num+=1);
			}
			System.out.println();
		}
		
		int num2 = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3-i; j++) {
				System.out.printf("%2s","");
			}
			for (int k = 0; k < i+1; k++) {
				System.out.printf("%2d",num2+=1);
			}
			System.out.println();
		}

	}
}
