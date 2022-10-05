package co.edu.api;

class Student {
	String name;
	int age;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}

public class ObjectExe {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		System.out.println(obj1.equals(obj2));
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2));
	}
}
