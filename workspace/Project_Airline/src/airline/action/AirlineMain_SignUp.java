package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class AirlineMain_SignUp extends JFrame implements ActionListener {
	private MemberDTO memberDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private JLabel info;
	private JTextField idInputT, nameT, phoneT, mailT, codeT, answerT;
	private JPasswordField pwInputT, pwCheckLT;
	private JButton joinBtn, cancelBtn, idCheckBtn, mailBtn, codeBtn;
	private JComboBox addressC, questionC;
	private JLabel idInputL, idL, pwInputL, pwCheckL, nameL, phoneL, phoneLabel, mailL, addressL, questionL, answerL;
	private int code = 2;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private AirlineMain_Email ae;
	private String codenum;

	public AirlineMain_SignUp() {
		setLayout(null);
		setTitle("BitAirline_회원가입");
		getContentPane().setBackground(new Color(3, 136, 166));

		idInputL = new JLabel("아이디");
		idInputL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		idInputL.setForeground(Color.WHITE);
		idInputL.setBounds(17, 25, 45, 25);
		getContentPane().add(idInputL);
		idInputT = new JTextField();
		idInputT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idInputT.setBounds(107, 25, 141, 26);
		getContentPane().add(idInputT);
		idInputT.setColumns(10);
		idCheckBtn = new JButton("중복확인");
		idCheckBtn.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		idCheckBtn.setBounds(252, 24, 78, 27);
		getContentPane().add(idCheckBtn);
		idL = new JLabel("");
		idL.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		idL.setForeground(Color.WHITE);
		idL.setBounds(107, 51, 220, 15);
		getContentPane().add(idL);

		pwInputL = new JLabel("비밀번호");
		pwInputL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		pwInputL.setForeground(Color.WHITE);
		pwInputL.setBounds(17, 72, 91, 26);
		getContentPane().add(pwInputL);
		pwInputT = new JPasswordField();
		pwInputT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwInputT.setColumns(10);
		pwInputT.setBounds(107, 72, 224, 26);
		getContentPane().add(pwInputT);

		pwCheckL = new JLabel("비밀번호 확인");
		pwCheckL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		pwCheckL.setForeground(Color.WHITE);
		pwCheckL.setBounds(17, 101, 91, 26); // 30
		getContentPane().add(pwCheckL);
		pwCheckLT = new JPasswordField();
		pwCheckLT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwCheckLT.setColumns(10);
		pwCheckLT.setBounds(107, 101, 224, 26);
		getContentPane().add(pwCheckLT);

		nameL = new JLabel("이름");
		nameL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		nameL.setForeground(Color.WHITE);
		nameL.setBounds(17, 143, 29, 26);
		getContentPane().add(nameL);
		nameT = new JTextField();
		nameT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameT.setColumns(10);
		nameT.setBounds(107, 143, 224, 26);
		getContentPane().add(nameT);

		phoneL = new JLabel("연락처");
		phoneL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		phoneL.setForeground(Color.WHITE);
		phoneL.setBounds(17, 185, 43, 26);
		getContentPane().add(phoneL);
		phoneT = new JTextField();
		phoneT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		phoneT.setColumns(10);
		phoneT.setBounds(107, 185, 141, 26);
		getContentPane().add(phoneT);
		phoneLabel = new JLabel("- 빼고 입력");
		phoneLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setBounds(257, 190, 70, 15);
		getContentPane().add(phoneLabel);

		mailL = new JLabel("이메일");
		mailL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		mailL.setForeground(Color.WHITE);
		mailL.setBounds(17, 230, 43, 26);
		getContentPane().add(mailL);
		mailT = new JTextField();
		mailT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		mailT.setColumns(10);
		mailT.setBounds(107, 230, 141, 26);
		getContentPane().add(mailT);
		mailBtn = new JButton("메일인증");
		mailBtn.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		mailBtn.setBounds(252, 229, 78, 27);
		getContentPane().add(mailBtn);

		codeT = new JTextField();
		codeT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		codeT.setColumns(10); // 30
		codeT.setBounds(107, 260, 141, 26);
		getContentPane().add(codeT);
		codeBtn = new JButton("인증확인");
		codeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		codeBtn.setBounds(252, 259, 78, 27);
		getContentPane().add(codeBtn);

		addressL = new JLabel("주소");
		addressL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		addressL.setForeground(Color.WHITE);
		addressL.setBounds(17, 300, 29, 26);
		getContentPane().add(addressL);
		addressC = new JComboBox();
		addressC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		addressC.setModel(new DefaultComboBoxModel(new String[] { "강원도", "광주광역시", "경기도", "경상남도", "경상북도", "대구광역시",
				"대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "인천광역시", "울산광역시", "전라남도", "전라북도", "제주특별자치도", "충청북도", "충청남도" }));
		addressC.setBackground(Color.WHITE);
		addressC.setBounds(107, 300, 224, 26);
		getContentPane().add(addressC);

		questionL = new JLabel("질문");
		questionL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		questionL.setForeground(Color.WHITE);
		questionL.setBounds(17, 345, 29, 26);
		getContentPane().add(questionL);
		questionC = new JComboBox();
		questionC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		questionC.setModel(new DefaultComboBoxModel(new String[] { "출신 초등학교는?", "어머니 성함은?", "아버지 성함은?" }));
		questionC.setBackground(Color.WHITE);
		questionC.setBounds(107, 345, 224, 26);
		getContentPane().add(questionC);

		answerL = new JLabel("답");
		answerL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		answerL.setForeground(Color.WHITE);
		answerL.setBounds(17, 375, 29, 26);
		getContentPane().add(answerL);
		answerT = new JTextField();
		answerT.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		answerT.setColumns(10);
		answerT.setBounds(107, 375, 224, 26);
		getContentPane().add(answerT);

		joinBtn = new JButton("가입");
		joinBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		joinBtn.setBounds(72, 424, 91, 28);
		getContentPane().add(joinBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cancelBtn.setBounds(173, 424, 91, 28);
		getContentPane().add(cancelBtn);

		setSize(350, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		idCheckBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		mailBtn.addActionListener(this);
		codeBtn.addActionListener(this);
		idCheckBtn.setFocusable(false);
		joinBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
		mailBtn.setFocusable(false);
		codeBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String push = e.getActionCommand();
		if (push == "가입") {
			if (codeT.getText().equals(ae.getCode())) {
				memberDTO = new MemberDTO();
				if (idInputT.getText().equals("") || pwInputT.getText().equals("") || pwCheckLT.getText().equals("")
						|| nameT.getText().equals("") || phoneT.getText().equals("") || mailT.getText().equals("")
						|| codeT.getText().equals("") || answerT.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "빈칸을 모두 채워주세요.");
				} else if (!pwInputT.getText().equals(pwCheckLT.getText())) {
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
				} else {
					if (pwInputT.getText().equals(pwCheckLT.getText())) {
						int seq = airlineDAO.getSeq();
						String id = idInputT.getText();
						String pw = pwInputT.getText();
						String pw2 = pwCheckLT.getText();
						String name = nameT.getText();
						String phone = phoneT.getText();
						String mail = mailT.getText();
						String address = addressC.getSelectedItem().toString();
						String question = questionC.getSelectedItem().toString();
						String answer = answerT.getText();
						int code = 2;

						memberDTO.setSeq(seq);
						memberDTO.setId(id);
						memberDTO.setPw(pw);
						memberDTO.setPw2(pw2);
						memberDTO.setName(name);
						memberDTO.setPhone(phone);
						memberDTO.setMail(mail);
						memberDTO.setAddress(address);
						memberDTO.setQuestion(question);
						memberDTO.setAnswer(answer);
						memberDTO.setCode(code);

						airlineDAO.member_insert(memberDTO);

						dispose();
					}
				}
			} else if (!(codeT.getText().equals(ae.getCode()))) {
				JOptionPane.showMessageDialog(this, "인증번호가 틀립니다.");
			}
		} else if (push == "중복확인") {
			String id = idInputT.getText();
			int check = 0;

			airlineDAO = new AirlineDAO();

			list = airlineDAO.getmemberList();

			for (MemberDTO memberDTO : list) {
				if (memberDTO.getId().equals(id)) {
					check = 1;
				}
			}

			if (check == 1) {
				idL.setText("이미 존재하는 아이디 입니다.");
			} else if (check == 0) {
				idL.setText("사용가능한 아이디 입니다.");
			}
		} else if (push == "취소") {
			dispose();
		} else if (push == "메일인증") {
			ae = new AirlineMain_Email(this);
			JOptionPane.showMessageDialog(this, "인증코드가 전송되었습니다.");
		} else if (push == "인증확인") {
			if (ae == null)
				return;
			if (codeT.getText().equals(ae.getCode())) {
				JOptionPane.showMessageDialog(this, "인증완료되었습니다.");
				codeBtn.setEnabled(false);
			} else if (!(codeT.getText().equals(ae.getCode()))) {
				JOptionPane.showMessageDialog(this, "인증번호가 틀립니다.");
				codeBtn.setEnabled(true);
			}
		}
	}

	public JTextField getMail() {
		return mailT;
	}

	public String getCodenum() {
		return codenum;
	}

}