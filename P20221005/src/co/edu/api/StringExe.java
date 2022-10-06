package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
//		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 }; // byte를 담는 배열 bytes 생성.
//
//		String str1 = new String(bytes); // 입력한 바이트 배열을 문자열로 변환해줌.
//		System.out.println(str1); // 출력: Hello Java
//
//		String str2 = new String(bytes, 6, 4); // bytes 배열의 인덱스 번호 6번부터 4개
//		System.out.println(str2); // 출력: Java

//		String fileName = "src/co/edu/api/Data.txt";
//		File file = new File(fileName);
//
////		String searchKey = "자바";
//		String searchKey = "자 바";
//		searchKey = searchKey.replace(" ", "");
//
//		Scanner scn = null;
//		try {
//			scn = new Scanner(file);
//			while (true) {
//				String str = scn.nextLine();
//				if (str == null) {
//					break;
//				}
//				if (str.indexOf(searchKey) != -1)
//					System.out.println(str);
//
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//
//		}
//
//		System.out.println("end of prog");
//	}
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);

		Scanner scn = null;
		try {
			scn = new Scanner(file);

//			while (true) {
//				String str = scn.nextLine();
//				str = str.replace(" ", "");
//				str = str.replace("-", "");
//				char gender = str.charAt(6);
//				switch (gender) {
//				case '1':
//				case '3':
//					System.out.println("남자 입니다.");
//					break;
//				case '2':
//				case '4':
//					System.out.println("여자 입니다.");
//					break;
//				}
//			}
			String str = scn.nextLine();
			
			if(str == null) 
				break;
			
			if(str.replace("-", "").charAt(6)%2==1) {
				System.out.println("남자입니다.");
			} else if(str.replace("-", "").charAt(6)%2==0) {
				System.out.println("여자입니다.");
			} else {
				System.out.println("잘못된 번호입니다.");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}
		System.out.println("end of prog");

	}
}
