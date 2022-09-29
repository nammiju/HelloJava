package co.edu.complex;

import java.util.Scanner;

public class ObjextExe {
	public static void main(String[] args) {

		String s1 = "홍길동";
		int i1 = 20;
		double d1 = 162; // double타입에 담기 위해서 162.0으로 자동으로 형변환 해줌

		Person p1 = new Person(); // 인스턴스 생성
		p1.name = "김민기"; // p1: 변수이름 name, age, height: 변수안의 속성
		p1.age = 22;
		p1.height = 172.3;
		System.out.println(p1); // co.edu.complex.Person@6f2b958e <- p1의 주소값을 출력해줌

		Person p2 = new Person();
		p2.name = "김경미";
		p2.age = 23;
		p2.height = 163.2;

		Person p3 = new Person(); // 인스턴스 생성
		p3.name = "주소영";
		p3.age = 22;
		p3.height = 172.3;
		System.out.println(p3);

		System.out.println("이름: " + p1.name);
		System.out.println("나이: " + p1.age);
		System.out.println("키: " + p1.height);

		Person[] persons = { p1, p2, p3 };

		System.out.println(persons[1].name); // pensons 배열의 인데스 값 1번의 속성 출력
		System.out.println(persons[1].age);
		System.out.println(persons[1].height);

//		persons[2].name = "송지은";
		p3.name = "송지은";

		// p1변수값과 persons[0]값을 비교.
		System.out.println(persons[0] == p1);

		// 김경미 이름을 찾아서 나이를 23에서 22로 바꿔보기
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].name.equals("김경미")) { // 문자열은 ==로 비교하는 대신 equals로 비교하기
				persons[i].age = 22;
			}
		}

//		String kim = "김경미"; // 문자열리터럴. 
		// 이름 입력하면 for문에서 찾아서 일치하는 이름의 나이를 입력한 나이로 바꿔줌
		Scanner scn = new Scanner(System.in);
		System.out.println("변경할 이름 >>> ");
		String name = scn.nextLine();
		System.out.println("변경할 나이 >>> ");
		int age = scn.nextInt();

		for (int i = 0; i < persons.length; i++) {
			if (persons[i].name.equals(name)) { // 문자열은 ==로 비교하는 대신 equals로 비교하기
				persons[i].age = age;
			}
		}

		// 전체 내용 출력
		for (int i = 0; i < persons.length; i++) {
			System.out.println(i + 1 + "번째 이름: " + persons[i].name + ", 나이: " + persons[i].age);
		}

//		String n1 = new String("홍길동");
//		String n2 = new String("홍길동");
//		System.out.println(n1 == n2); // false 출력
//
//		String m1 = "홍길동";
//		String m2 = "홍길동";
//		System.out.println(m1 == m2); // true 출력. 둘의 주소값이 같기 때문이다

	}
}
