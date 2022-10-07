package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
		while (true) {
			try {
				int bytes = System.in.read(); // 키보드에 입력된 값을 읽어들임
				if (bytes == 122) // 소문자z의 값을 입력하면 빠져나옴.
					break;

				System.out.println("입력값: " + bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog.");
	}

	public static void cnangeCapital(String msg) {
		// 대문자->소문자, 소문자->대문자 두값의 차: 32
		// AbCd -> aBcD 97:65, 98:66, 99:67, (소문자-32=대문자)
		// 소문자: 97~122, 대문자: 65~90
		String[] msgAry = msg.split("");
		byte[] bytes new byte[msg.length()];
		int i = 0;
		for (String str : msgAry) {
			char chr = str.charAt(0);
			int chr2 = 0;

			if (chr >= 97)
				chr2 = chr - 32;
			else if (chr <= 92)
				chr2 = chr + 32;

			System.out.println((char) chr2);
		}

	}

}
