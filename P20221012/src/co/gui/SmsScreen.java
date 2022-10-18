package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.gui.MailScreen.MyActionListener;

public class SmsScreen extends JFrame {
	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(40, 15);

	JPanel center, bottom; // 컴포넌트를 모아두기 위한 panel 생성
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt; // 텍스트 필드
	JTextArea contentTxt; // 컨텐츠를 담을 텍스트 공간
	JButton send, cancel; // 전송, 취소 버튼

	SmsApp app = new SmsApp();

	public SmsScreen() {
		setTitle("문자보내기");
		setSize(350, 300);
		setLayout(new BorderLayout());
		
		// panel 선언
		center = new JPanel();
		bottom = new JPanel();

		// label 세팅
		toLbl = new JLabel("받는사람");
		fromLbl = new JLabel("보내는사람");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1); // 크기 지정
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		// textfield 세팅
		toTxt = new JTextField(20); // ()안은 크기를 지정하는 것
		fromTxt = new JTextField(20);
		contentTxt = new JTextArea(10, 20); // 로우와 컬럼값 지정

		// button 세팅
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); // ActionListener: 인터페이스 -> 구현객체
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		// container setting.
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		// 컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);

		// 윈도우에 컨테이너 배치.
		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면의 중앙에 띄움
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == send) {
				System.out.println("보내기 버튼 actionPerformed");
				String from = fromTxt.getText(); // 텍스트 필드의 값을 읽어들임.
				String to = toTxt.getText();
				String content = contentTxt.getText();
				
				app.sendSms(to, from, content);
				// 콘솔에 "성공"; -> 값을 지워주도록 
				System.out.println("성공");
				JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				fromTxt.setText(null);
				toTxt.setText(null);
				contentTxt.setText(null);
//				}{
//					// 콘솔에 "실패"; 
//					System.out.println("실패");
//					JOptionPane.showMessageDialog(null, "발송실패!!", "전송결과", JOptionPane.DEFAULT_OPTION);
//				}
			} else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed");
			}
		}
		
	}
	public static void main(String[] args) {
		new SmsScreen();
	}
}
