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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class AirlineMain_FindPW2 extends JFrame implements ActionListener {
	private ImageIcon mlogo;
	private JTextField idT, answerT;
	private JLabel titleL, pwdL, idL, questionL, answerL;
	private JComboBox questionC;
	private JButton okBtn, cancelBtn;
	private AirlineDAO airlineDAO;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();

	public AirlineMain_FindPW2() {
		setLayout(null);
		setTitle("BitAirline_비밀번호 찾기");

		getContentPane().setBackground(new Color(3, 136, 166));

		mlogo = new ImageIcon("mlogo.png");
		titleL = new JLabel(mlogo);
		titleL.setBounds(122, 5, 100, 30);
		add(titleL);

		pwdL = new JLabel("질문으로 찾기");
		pwdL.setHorizontalAlignment(JLabel.CENTER);
		pwdL.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		pwdL.setForeground(Color.WHITE);
		pwdL.setBounds(95, 35, 150, 30);
		add(pwdL);

		idL = new JLabel("아이디");
		idL.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		idL.setForeground(Color.WHITE);
		idL.setBounds(30, 81, 50, 21);
		add(idL);

		idT = new JTextField();
		idT.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		idT.setBounds(105, 79, 206, 30);
		idT.setColumns(10);
		add(idT);

		questionL = new JLabel("질문");
		questionL.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		questionL.setForeground(Color.WHITE);
		questionL.setBounds(30, 121, 50, 21);
		add(questionL);

		questionC = new JComboBox();
		questionC.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		questionC.setModel(new DefaultComboBoxModel(new String[] { "출신 초등학교는?", "어머니 성함은?", "아버지 성함은?" }));
		questionC.setBackground(Color.WHITE);
		questionC.setBounds(105, 119, 206, 30);
		add(questionC);

		answerL = new JLabel("답");
		answerL.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		answerL.setForeground(Color.WHITE);
		answerL.setBounds(30, 161, 70, 21);
		add(answerL);

		answerT = new JTextField();
		answerT.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		answerT.setBounds(105, 159, 206, 30);
		answerT.setColumns(10);
		add(answerT);

		okBtn = new JButton("확인");
		okBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		okBtn.setBounds(76, 200, 91, 28);
		add(okBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cancelBtn.setBounds(176, 200, 91, 28);
		add(cancelBtn);

		setSize(350, 270);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		okBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		airlineDAO = new AirlineDAO();
		int check = 0;
		String question = (String) questionC.getSelectedItem();
		if (e.getActionCommand() == "확인") {
			if (idT.getText().equals("") || answerT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸을 모두 채워주세요.");

			} else if (!idT.getText().equals("") || !answerT.getText().equals("")) {
				list = airlineDAO.getmemberList();
				for (MemberDTO memberDTO : list) {
					if (idT.getText() == null) {
						return;
					}
					if (idT.getText().equals(memberDTO.getId())) { // 가입한 아이디가 기존에 있을 때
						if (question.equals(memberDTO.getQuestion())
								&& answerT.getText().equals(memberDTO.getAnswer())) {
							check = 1;
							JOptionPane.showMessageDialog(this, "인증완료되었습니다.");
							String changePw = JOptionPane.showInputDialog(this, "변경하실 비밀번호를 입력하세요.");
							memberDTO.setSeq(memberDTO.getSeq());
							memberDTO.setId(memberDTO.getId());
							memberDTO.setPw(changePw);
							memberDTO.setPw2(changePw);
							memberDTO.setName(memberDTO.getName());
							memberDTO.setPhone(memberDTO.getPhone());
							memberDTO.setMail(memberDTO.getMail());
							memberDTO.setAddress(memberDTO.getAddress());
							memberDTO.setQuestion(memberDTO.getQuestion());
							memberDTO.setAnswer(memberDTO.getAnswer());
							memberDTO.setCode(memberDTO.getCode());

							airlineDAO.member_update(memberDTO);
							dispose();
							break;
						} else if (!question.equals(memberDTO.getQuestion())) {
							check = 3;
						} else if (question.equals(memberDTO.getQuestion())
								&& !answerT.getText().equals(memberDTO.getAnswer())) {
							check = 4;
						}
					}
				} // for
				if (check == 3) {
					JOptionPane.showMessageDialog(this, "가입 시 선택한 질문과 다릅니다.");
				} else if (check == 4) {
					JOptionPane.showMessageDialog(this, "가입 시 입력한 답변과 다릅니다.");
				}
			}
		} else if (e.getActionCommand() == "취소") {
			dispose();
		}
	}

}