package co.edu.except;

public class RectPrint {
	public static void main(String[] args) {
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			System.out.printf("%3d", cnt);
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", cnt += 5);
			}
			System.out.println();
			cnt = i + 2;
		}
	}
}
