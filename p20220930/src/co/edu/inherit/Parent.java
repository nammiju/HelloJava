package co.edu.inherit;

public class Parent extends Object{
	String field;
	Parent(){
		System.out.println("Parent() call.");
	}
	Parent(String args){ // 매개변수를 받는 생성자.
		System.out.println("Parent(String args) call.");
	}
	void method() {
		System.out.println("parent method() call.");
	}
	
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
	
}
