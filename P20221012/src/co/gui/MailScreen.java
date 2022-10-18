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

public class MailScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(30, 15);

	JPanel center, bottom; // 컴포넌트를 모아두기 위한 panel 생성
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블 생성
	JTextField fromTxt, toTxt, subjectTxt; // 텍스트 필드
	JTextArea contentTxt; // 컨텐츠를 담을 텍스트 공간
	JButton send, cancel; // 전송, 취소 버튼

	MailAppNaver app = new MailAppNaver();

	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());

		// panel 선언
		center = new JPanel();
		bottom = new JPanel();

		// label 세팅
		toLbl = new JLabel("받는 사람");
		fromLbl = new JLabel("보내는 사람");
		subjectLbl = new JLabel("제목: ");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1); // 크기 지정
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);

		// textfield 세팅
		toTxt = new JTextField(22); // ()안은 크기를 지정하는 것
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25); // 로우와 컬럼값 지정

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
		center.add(subjectLbl);
		center.add(subjectTxt);
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

	// 기능을 실행하는 구현객체.
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 어떤 객체에 이벤트가 일어났는지 알려줌.
			if (src == send) {
				System.out.println("보내기 버튼 actionPerformed");
				String from = fromTxt.getText(); // 텍스트 필드의 값을 읽어들임.
				String to = toTxt.getText();
				String subject = subjectTxt.getText();
				String content = contentTxt.getText();
						
				if(app.sendMail(from, to, subject, content).equals("Success")) {
					// 콘솔에 "성공"; -> 값을 지워주도록 
					System.out.println("성공");
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
					fromTxt.setText(null);
					toTxt.setText(null);
					subjectTxt.setText(null);
					contentTxt.setText(null);
				}else {
					// 콘솔에 "실패"; 
					System.out.println("실패");
					JOptionPane.showMessageDialog(null, "발송실패!!", "전송결과", JOptionPane.DEFAULT_OPTION);
				}
			} else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed");
			}
		}

	}

	public static void main(String[] args) {
		new MailScreen();
	}
}
