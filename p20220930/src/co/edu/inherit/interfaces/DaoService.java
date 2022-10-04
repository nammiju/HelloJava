package co.edu.inherit.interfaces;

public interface DaoService {
	// 인터페이스는 필드와 생성자를 정의할 수 없다.
	// only 메소드만 정의가능. 대신 추상메소드만
	// 상수값을 정의할 수 있다.
	
	public abstract void insert(); // 추상메소드 지정할 때 abstract 안붙여도 기본으로 추상메소드가 생성됨.
	public void search();
	public void delete();
	
}
