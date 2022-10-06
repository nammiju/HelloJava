package co.edu.api;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
	String name;
	int age;

	@Override
	public String toString() {
		return "학생의 이름은 " + name + ",나이는 " + age + "입니다.";
	}

	// Set 컬렉션: 동일한 인스턴스는 담아주지않는 컬렉션. 
	@Override
	public int hashCode() { 
		return age;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
}

// 모든 클래스의 최상위 Object.
public class ObjectExe {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1.equals(obj2));

		Student s1 = new Student();
		s1.name = "Hong";
		s1.age = 10;
		Student s2 = new Student();
		s2.name = "Hong";
		s2.age = 11;
		String s3 = "Hong";

//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equals(s3));
//		System.out.println(s1); // 자동으로 투스트링값이 출력된다. 만약에 위해서 toString을 따로 지정하지 않았다면 오브젝트 클래스의 투스트링이 나옴. 
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// Set 컬렉션: 인터페이스 -> 구현클래스를 통해서 인스턴스 생성.
		Set<Integer> set= new HashSet<Integer>();
		set.add(new Integer(100));
		set.add(new Integer(110));
		set.add(new Integer(100)); // 중복된 값은 포함시키지 않음. 
		
		System.out.println("컬렉션의 크기: "+set.size());
		
		// Set 컬렉션에 Student 인스턴스 저장시 논리적으로 동일한 인스턴스를 판단하는것은
		// hasCode(), equals()를 기준으로 한다.
		Set<Student> students = new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		System.out.println("컬렉션의 크기: "+students.size());
	}
}
