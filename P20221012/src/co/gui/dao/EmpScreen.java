package co.gui.dao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EmpScreen extends JFrame {

	// 입력항목 처리를 위한 컴포넌트.
	private String[] labels = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
	private JTextField[] fields = new JTextField[6];

	// 컴포넌트 배치를 위한 패널.
	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;

	// 컨테이너.
	private JTable table;

	// 버튼.
	private JButton addBtn, delBtn, findBtn, initBtn;

	EmpDAO dao = new EmpDAO();
	List<EmployeeVO> list;

	public EmpScreen() {
		setTitle("사원정보 관리화면");
		setLayout(new BorderLayout());

		// topPanel에 들어갈 컴포넌트 추가.
		topPanel = new JPanel(new GridLayout(6, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}
		
		add(topPanel); // 위쪽의 입력항목을 배치.
		

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 가운데 배치.
		setVisible(true);

	}

	public static void main(String[] args) {

	}
}
