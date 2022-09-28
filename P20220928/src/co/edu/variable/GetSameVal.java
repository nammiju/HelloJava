package co.edu.variable;

import java.util.Scanner; 
import java.lang.System;
// java.lang이 베이스 패키지.
// Scanner 클래스의 소속을 임포트 해줘야지 에러가 안남

public class GetSameVal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); // Scanner 클래스: 사용자 입력값을 저장해줌.
		
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine(); // 사용자가 입력한 값을 읽은 후 입력값을 반환함.
		
		String[] names = {"김현지", "김유리", "남미주", "송지은"}; // 문자열을 담는 배열에 대한 변수 names
		
		boolean isChecked = false; // isChecked 변수 설정. 기본값이 false인
		for(int i=0; i<names.length; i++) {
			// 몇번째 위치에 있는지 출력
			if(names[i].equals(name)) { // 문자열 비교는 문자열.equals(비교문자열)
				System.out.println((i+1) + "번째 위치에 있습니다." ); //만족하면 출력되는 값
				isChecked = true; // 만족시 isChecked 변수의 값을 true로 바꿔줌
				break; // 만족시 더이상 반복하지 않고 빠져나옴
			}
		}	
		if(!isChecked) {  
			System.out.println("찾는 이름이 없습니다"); }
			
			scn.close();
			
			System.out.println("입력값: " + name);
	}
		
}

