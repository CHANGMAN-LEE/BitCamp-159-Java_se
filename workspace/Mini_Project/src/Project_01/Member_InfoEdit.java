package Project_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Member_InfoEdit extends JFrame implements ActionListener {
	private String id, pwd, name, phone, address;
	private String age;
	private JLabel myInfoL, nameL, idL, pwdL, phoneL, addressL, emailL, questionL, answerL;
	private JTextField idT, pwdT, nameT, phoneT, emailT, answerT;
	private JButton pwdEdB, nameEdB, phoneEdB, emailEdB, editBtn, cancelBtn;
	private JComboBox addressComboBox, questionComboBox;

	public Member_InfoEdit(String id, String pwd, String name, String phone, String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.address = address;

		setLayout(null);

		myInfoL = new JLabel("기본 정보");
		myInfoL.setFont(new Font("맑은고딕체", Font.BOLD, 16));
		myInfoL.setBounds(270, 5, 70, 40);

		idL = new JLabel("아이디");
		idL.setBounds(14, 40, 35, 25);
		idT = new JTextField();
		idT.setEditable(false);
		idT.setBounds(14, 60, 320, 33);

		pwdL = new JLabel("비밀번호");
		pwdL.setBounds(14, 95, 50, 25);
		pwdT = new JTextField();
		pwdT.setBounds(14, 115, 263, 33);
		pwdEdB = new JButton("수정");
		pwdEdB.setBounds(283, 115, 50, 33);

		nameL = new JLabel("이름");
		nameL.setBounds(14, 150, 25, 25);
		nameT = new JTextField();
		nameT.setBounds(14, 170, 263, 33);
		nameEdB = new JButton("수정");
		nameEdB.setBounds(283, 170, 50, 33);

		phoneL = new JLabel("연락처");
		phoneL.setBounds(14, 205, 50, 25);
		phoneT = new JTextField();
		phoneT.setBounds(14, 225, 263, 33);
		phoneEdB = new JButton("수정");
		phoneEdB.setBounds(283, 225, 50, 33);

		addressL = new JLabel("주소");
		addressL.setBounds(14, 270, 25, 25);

		addressComboBox = new JComboBox();
		addressComboBox.setModel(new DefaultComboBoxModel(new String[] { "강원도", "광주광역시", "경기도", "경상남도", "경상북도", "대구광역시",
				"대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "인천광역시", "울산광역시", "전라남도", "전라북도", "제주특별자치도", "충청북도", "충청남도" }));
		addressComboBox.setBounds(45, 263, 290, 40);

		emailL = new JLabel("이메일");
		emailL.setBounds(14, 295, 35, 25);
		emailT = new JTextField();
		emailT.setBounds(14, 315, 263, 31);
		emailEdB = new JButton("수정");
		emailEdB.setBounds(283, 315, 50, 31);

		questionL = new JLabel("질문");
		questionL.setBounds(14, 360, 35, 25);

		questionComboBox = new JComboBox();
		questionComboBox.setModel(new DefaultComboBoxModel(new String[] { "출신 초등학교는?", "어머니 성함은?", "아버지 성함은?" }));
		questionComboBox.setBounds(45, 353, 290, 40);

		answerL = new JLabel("답");
		answerL.setBounds(14, 395, 25, 25);
		answerT = new JTextField();
		answerT.setColumns(10);
		answerT.setBounds(45, 395, 263, 33);

		editBtn = new JButton("수정 완료");
		editBtn.setBounds(55, 430, 120, 35);
		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(175, 430, 120, 35);

		add(myInfoL);
		add(idL);
		add(idT);
		add(pwdL);
		add(pwdT);
		add(pwdEdB);
		add(nameL);
		add(nameT);
		add(nameEdB);
		add(phoneL);
		add(phoneT);
		add(phoneEdB);
		add(addressL);
		add(addressComboBox);
		add(emailL);
		add(emailT);
		add(emailEdB);
		add(questionL);
		add(questionComboBox);
		add(answerL);
		add(answerT);
		add(editBtn);
		add(cancelBtn);

		setTitle("나의 정보");
		setSize(350, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		pwdEdB.addActionListener(this);
		nameEdB.addActionListener(this);
		phoneEdB.addActionListener(this);
		emailEdB.addActionListener(this);
		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				// setVisible(false);
			}
		});
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pwdEdB) {
			String pwd = JOptionPane.showInputDialog(this, "변경하실 비밀번호를 입력하세요.", "비밀번호 변경",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == nameEdB) {
			String name = JOptionPane.showInputDialog(this, "변경하실 이름을 입력하세요.", "이름 변경",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == phoneEdB) {
			String phone = JOptionPane.showInputDialog(this, "변경하실 전화번호를 입력하세요.", "연락처 변경",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == emailEdB) {
			String address = JOptionPane.showInputDialog(this, "변경하실 주소를 입력하세요.", "주소 변경",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == editBtn) {
			JOptionPane.showMessageDialog(this, "수정 완료", "수정", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		} else if (e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}
