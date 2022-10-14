package co.dev;

import java.util.ArrayList;

public class StudExample {
	public static void main(String[] args) {
//	Student stud = new Student();
		Student stud = new Student(101, "홍길동", 80); // 인스턴스 생성 - 일치하는 데이터타입만 담을 수 있다.
		String name1 = stud.getStudName();
		int score1 = stud.getScore();

		ArrayList<Student> studList = new ArrayList<Student>();
		// Student 클래스의 인스턴스만 담을 수 있는 ArrayList를 생성하고 변수명을 studList라고 정함.
		studList.add(stud); // studList컬렉션에 stud값 추가.
		studList.add(new Student(102, "김현수", 88));
		studList.add(0, new Student(103, "박문수", 78));
		// 값을 넣는 여러 방식

		Student hong = new Student(201, "홍수완", 90); // 김현수 앞에 넣고 싶음
		for (int i = 0; i < studList.size(); i++) {
			if (studList.get(i).getStudName().equals("김현수")) { // studList에서 이름이 김현수이면
				studList.add(i, hong); // 김현수 인덱스 자리에 변수 hong 넣어줌.
				break;
			}
		}

		// 입력된 순서대로 출력
		for (int i = 0; i < studList.size(); i++) {
			System.out.println(studList.get(i).getStudName()); // studList에서 인덱스번호 i의 StudName 한건을 출력해줌.
		}

		
		// 학번기준으로 정렬.
		ArrayList<Student> sortAry = new ArrayList<Student>(); // 새로운 배열을 담을 컬렉션 생성.
//		for (int i = 0; i < studList.size(); i++)
		
//		// 학번기준으로 정렬된(오름차순, 내림차순) 배열 출력.
//		ArrayList<Student> sortAry = new ArrayList<Student>(); // 새로운 배열을 담을 컬렉션 생성.
//
////		for (int i = 0; i < studList.size(); i++) {
////			for (int j = 0; j < i; j++) {
////				sort.add(j, studList.get(i))
////			}
//////			if(studList.get(i).getStudNo()<studList.get(i+1).getStudNo()) {
////				
//			}

		}

	}

