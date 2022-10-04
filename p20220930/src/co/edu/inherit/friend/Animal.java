package co.edu.inherit.friend;

public abstract class Animal { // abstract 추상클래스
	private String kind;

	public Animal() {

	};

	public Animal(String kind) {
		this.kind = kind;
	}
	
	public void move() {
		System.out.println("움직입니다.");
	}
	public abstract void eat(); // 메소드에 추상화를 주면(=추상메소드) 자식 클래스에서 반드시 구현하도록 강제된다.
	public abstract void speak(); 
}
