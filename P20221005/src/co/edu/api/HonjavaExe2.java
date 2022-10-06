package co.edu.api;

import java.io.UnsupportedEncodingException;

public class HonjavaExe2 {
	public static void main(String[] args) {
		// 주민번호로 남녀 구분하기
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7); // ssn의 인덱스 7번의 문자를 gender에 저장.
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}

		// 문자열 비교(equals())
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";

		if (strVar1 == strVar2) { // 객체의 String객체를 비교함.
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}

		if (strVar1.equals(strVar2)) { // equals()는 객체의 문자열만을 비교함.
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}

		// 바이트 배열로 변환(getBytes())
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes(); // 기본문자셋으로 인코딩.
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);

		try {
			byte[] bytes2 = str.getBytes("EUC-KR"); // EUC-KR을 이용해서 인코딩 및 디코딩.
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes3->String: " + str2);

			byte[] bytes3 = str.getBytes("UTF-8"); // UTF-8을 이용해서 인코딩 및 디코딩.
			System.out.println("bytes2.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3->String: " + str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} // end of 바이트 배열로 변환(getBytes())

		// 문자열 찾기(indexOf())
		String subject = "자바 프로그래밍";

		int location = subject.indexOf("프로그래밍"); // subject의 "프로그래밍"의 시작하는 인덱스 번호인 3이 저장됨.
		System.out.println(location); // 3 출력.

		if (subject.indexOf("자바") != -1) { // if( 문자열.indexOf("찾는문자열") =! -1{찾는문자열이 포함된 경우} else{포함되어 있지 않은 경우}
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}

	} // end of main

}
