package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {

		setTitle("원도우 UI");
		setSize(300, 250); // 원도우 사이즈.

		setLayout(new FlowLayout()); // 배치관리자.

		JButton btn = new JButton("확인"); // 버튼 생성
		JButton btn2 = new JButton("취소");
		btn.addActionListener(e -> System.out.println("확인버튼 클릭.")); // 이벤트가 발생하면 매개값으로 설정된 인터페이스를 구현해줌
		btn2.addActionListener((e) -> {
			System.out.println("취소버튼 클릭.");
			System.exit(0); // 0값: 종료
		}); // 이벤트는 람다표현식으로 만들 수 있다.
		
		
		add(btn); // 컨트롤 등록.(버튼 만들기만 하는게 다가 아니다)
		add(btn2);

		setVisible(true); // 화면출력.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스버튼 누르면 화면종료.

	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
