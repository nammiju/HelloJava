package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		final String constVar = "Hello"; // 맨 앞에 final 붙이면 한번 값이 할당되면 재할당 불가함.
//		constVar = "World"; // 에러남~
		
		FriendExe app = new FriendExe();
		app.exe();
	}
}
