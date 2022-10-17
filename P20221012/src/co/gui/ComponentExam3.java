package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// 간단한 계산기.
public class ComponentExam3 extends JFrame {

	String[] keys = { "1", "2", "3", "+", "4", "5", "6", //
			"-", "7", "8", "9", "*", "0", "=", "C", "/" };
	JButton[] keyBtn = new JButton[16];
	String displayText = ""; // 누적된 값을 담기위한 빈배열 선언.
	String left, right; // 연산자를 기준으로 앞뒤로 구분된 값을 담아줄 배열

	public ComponentExam3() {
		setTitle("계산기 UI");
		setBounds(100, 100, 300, 220); // 위치와 크기

		setLayout(new FlowLayout()); // FlowLayout(): 순차적으로 배열해주는 레이아웃

		// display 정보를 출력하기 위한 panel.
		JPanel displayPanel = new JPanel(); // 입력창
		JTextField display = new JTextField("0", 20);
		display.setHorizontalAlignment(JTextField.RIGHT); // display의 텍스트가 오른쪽부터 정렬되게함.
		displayPanel.add(display);

		// 버튼을 생성하기 위한 panel.
		JPanel keyPanel = new JPanel(); // 계산기 버튼부분
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < keyBtn.length; i++) {
			keyBtn[i] = new JButton(keys[i]);
			// 버튼 이벤트.
			keyBtn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(((JButton) e.getSource()).getText()); // 누르면(이벤트가 발생하면) 라벨의 정보가 콘솔에 출력되게 함
					String keyOper = ((JButton) e.getSource()).getText();
					// 계산처리.
					if (keyOper.equals("=")) {
						left = displayText.substring(0, displayText.indexOf("+")); // ex) 345+12 -> + 연산자를 기점으로 앞의 값과 뒤의
																					// 값을 구분시켜줌
						right = displayText.substring(displayText.indexOf("+") + 1);

						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right)); // 스트링타입을 인트타입으로 바꾸어 두개의 값을 더해주고 그걸 다시 스트링으로 바꿈.
						display.setText(displayText);
						return;
					}
					
					if (keyOper.equals("C")) {
						displayText = "0";
						display.setText(displayText);
						return;
					}

					displayText += keyOper;
					display.setText(displayText);

				}
			});
			keyPanel.add(keyBtn[i]);
		}

		add(displayPanel);
		add(keyPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ComponentExam3();
	}
}
