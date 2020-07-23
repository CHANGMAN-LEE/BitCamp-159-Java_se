package Project_01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AirlineMain_SignUp extends JFrame implements ActionListener {
	private SignUpDTO dto;
	public List<SignUpDTO> list = new ArrayList<SignUpDTO>();
	private JTextField idInputT, nameT, phoneT, mailT, codeT, anwerT;
	private JPasswordField pwInputT, pwCheckLT;
	private JButton joinBtn, cancelBtn, idCheckBtn, mailBtn, codeBtn;
	private JComboBox address, question;
	private JLabel idInputL, idL, pwInputL, pwCheckL, pwL, nameL, phoneL, phoneLabel, mailL, addressL, questionL,
			answerL;

	public AirlineMain_SignUp() {
		setLayout(null);
		setTitle("회원가입");

		idInputL = new JLabel("아이디 입력");
		idInputL.setFont(new Font("굴림", Font.PLAIN, 15));
		idInputL.setBounds(33, 32, 77, 26);
		getContentPane().add(idInputL);

		idInputT = new JTextField();
		idInputT.setBounds(121, 32, 141, 26);
		getContentPane().add(idInputT);
		idInputT.setColumns(10);

		idCheckBtn = new JButton("중복확인");
		idCheckBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		idCheckBtn.setBounds(264, 38, 77, 20);
		getContentPane().add(idCheckBtn);

		idL = new JLabel("");
		idL.setBounds(121, 60, 220, 15);
		getContentPane().add(idL);

		pwInputL = new JLabel("비밀번호 입력");
		pwInputL.setFont(new Font("굴림", Font.PLAIN, 15));
		pwInputL.setBounds(27, 99, 91, 26);
		getContentPane().add(pwInputL);

		pwInputT = new JPasswordField();
		pwInputT.setColumns(10);
		pwInputT.setBounds(121, 99, 141, 26);
		getContentPane().add(pwInputT);

		pwCheckL = new JLabel("비밀번호 확인");
		pwCheckL.setFont(new Font("굴림", Font.PLAIN, 15));
		pwCheckL.setBounds(27, 135, 91, 26);
		getContentPane().add(pwCheckL);

		pwCheckLT = new JPasswordField();
		pwCheckLT.setColumns(10);
		pwCheckLT.setBounds(121, 135, 141, 26);
		getContentPane().add(pwCheckLT);

		pwL = new JLabel("");
		pwL.setBounds(264, 146, 51, 15);
		getContentPane().add(pwL);

		nameL = new JLabel("이름");
		nameL.setFont(new Font("굴림", Font.PLAIN, 15));
		nameL.setBounds(65, 180, 29, 26);
		getContentPane().add(nameL);

		nameT = new JTextField();
		nameT.setColumns(10);
		nameT.setBounds(121, 180, 141, 26);
		getContentPane().add(nameT);

		phoneL = new JLabel("연락처");
		phoneL.setFont(new Font("굴림", Font.PLAIN, 15));
		phoneL.setBounds(60, 216, 43, 26);
		getContentPane().add(phoneL);

		phoneT = new JTextField();
		phoneT.setColumns(10);
		phoneT.setBounds(121, 218, 141, 26);
		getContentPane().add(phoneT);

		phoneLabel = new JLabel("- 뺴고 입력");
		phoneLabel.setBounds(264, 227, 70, 15);
		getContentPane().add(phoneLabel);

		mailL = new JLabel("이메일");
		mailL.setFont(new Font("굴림", Font.PLAIN, 15));
		mailL.setBounds(60, 258, 43, 26);
		getContentPane().add(mailL);

		mailT = new JTextField();
		mailT.setColumns(10);
		mailT.setBounds(121, 258, 141, 26);
		getContentPane().add(mailT);

		mailBtn = new JButton("메일인증");
		mailBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		mailBtn.setBounds(264, 264, 77, 20);
		getContentPane().add(mailBtn);

		codeT = new JTextField();
		codeT.setColumns(10);
		codeT.setBounds(121, 285, 141, 26);
		getContentPane().add(codeT);

		codeBtn = new JButton("인증확인");
		codeBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		codeBtn.setBounds(264, 291, 77, 20);
		getContentPane().add(codeBtn);

		addressL = new JLabel("주소");
		addressL.setFont(new Font("굴림", Font.PLAIN, 15));
		addressL.setBounds(65, 321, 29, 26);
		getContentPane().add(addressL);

		address = new JComboBox();
		address.setModel(new DefaultComboBoxModel(new String[] { "강원도", "광주광역시", "경기도", "경상남도", "경상북도", "대구광역시",
				"대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "인천광역시", "울산광역시", "전라남도", "전라북도", "제주특별자치도", "충청북도", "충청남도" }));
		address.setBounds(121, 321, 141, 26);
		getContentPane().add(address);

		questionL = new JLabel("질문");
		questionL.setFont(new Font("굴림", Font.PLAIN, 15));
		questionL.setBounds(65, 363, 29, 26);
		getContentPane().add(questionL);

		question = new JComboBox();
		question.setModel(new DefaultComboBoxModel(new String[] { "출신 초등학교는?", "어머니 성함은?", "아버지 성함은?" }));
		question.setBounds(121, 363, 141, 26);
		getContentPane().add(question);

		answerL = new JLabel("답");
		answerL.setFont(new Font("굴림", Font.PLAIN, 15));
		answerL.setBounds(65, 391, 29, 26);
		getContentPane().add(answerL);

		anwerT = new JTextField();
		anwerT.setColumns(10);
		anwerT.setBounds(121, 391, 141, 26);
		getContentPane().add(anwerT);

		JButton joinBtn = new JButton("가입");
		joinBtn.setBounds(68, 427, 91, 23);
		getContentPane().add(joinBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(187, 427, 91, 23);
		getContentPane().add(cancelBtn);

		setBounds(1450, 60, 350, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		idCheckBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String push = e.getActionCommand();
		if (push == "가입") {
			dto = new SignUpDTO();
			if (idInputT.getText().equals("") || pwInputT.getText().equals("") || pwCheckLT.getText().equals("")
					|| nameT.getText().equals("") || phoneT.getText().equals("") || mailT.getText().equals("")
					|| codeT.getText().equals("") || anwerT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸을 모두 채워주세요.");
			} else if (!pwInputT.getText().equals(pwCheckLT.getText())) {
				JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
			} else {
				if (pwInputT.getText().equals(pwCheckLT.getText())) {
					dto.setData(idInputT.getText(), pwInputT.getText(), pwCheckLT.getText(), nameT.getText(),
							phoneT.getText(), mailT.getText(), address.getActionCommand(), question.getActionCommand(),
							anwerT.getText());
					list.add(dto);

//					for (SignUpDTO dto : list) {
//						System.out.println(dto.getId() + ", " + dto.getName());
//					}
//					System.out.println();
					setVisible(false);
				}
			}
		} else if (push == "중복확인") {
//			System.out.println("눌림");
			String id = idInputT.getText();
			int check = 0;
			for (SignUpDTO dto : list) {
				if (dto.getId().equals(id)) {
					check = 1;
				}
			}
			if (check == 1) {
				idL.setText("이미 존재하는 아이디 입니다.");
			} else if (check == 0) {
				idL.setText("사용가능한 아이디 입니다.");
			}
		} else if (push == "취소") {
			setVisible(false);
		}
	}
}