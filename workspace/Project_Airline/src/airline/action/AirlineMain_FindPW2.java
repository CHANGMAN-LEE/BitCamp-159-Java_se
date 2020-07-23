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
		setTitle("BitAirline_��й�ȣ ã��");

		getContentPane().setBackground(new Color(3, 136, 166));

		mlogo = new ImageIcon("mlogo.png");
		titleL = new JLabel(mlogo);
		titleL.setBounds(122, 5, 100, 30);
		add(titleL);

		pwdL = new JLabel("�������� ã��");
		pwdL.setHorizontalAlignment(JLabel.CENTER);
		pwdL.setFont(new Font("���� ���", Font.BOLD, 23));
		pwdL.setForeground(Color.WHITE);
		pwdL.setBounds(95, 35, 150, 30);
		add(pwdL);

		idL = new JLabel("���̵�");
		idL.setFont(new Font("���� ���", Font.BOLD, 14));
		idL.setForeground(Color.WHITE);
		idL.setBounds(30, 81, 50, 21);
		add(idL);

		idT = new JTextField();
		idT.setFont(new Font("���� ���", Font.PLAIN, 17));
		idT.setBounds(105, 79, 206, 30);
		idT.setColumns(10);
		add(idT);

		questionL = new JLabel("����");
		questionL.setFont(new Font("���� ���", Font.BOLD, 14));
		questionL.setForeground(Color.WHITE);
		questionL.setBounds(30, 121, 50, 21);
		add(questionL);

		questionC = new JComboBox();
		questionC.setFont(new Font("���� ���", Font.BOLD, 14));
		questionC.setModel(new DefaultComboBoxModel(new String[] { "��� �ʵ��б���?", "��Ӵ� ������?", "�ƹ��� ������?" }));
		questionC.setBackground(Color.WHITE);
		questionC.setBounds(105, 119, 206, 30);
		add(questionC);

		answerL = new JLabel("��");
		answerL.setFont(new Font("���� ���", Font.BOLD, 14));
		answerL.setForeground(Color.WHITE);
		answerL.setBounds(30, 161, 70, 21);
		add(answerL);

		answerT = new JTextField();
		answerT.setFont(new Font("���� ���", Font.PLAIN, 17));
		answerT.setBounds(105, 159, 206, 30);
		answerT.setColumns(10);
		add(answerT);

		okBtn = new JButton("Ȯ��");
		okBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		okBtn.setBounds(76, 200, 91, 28);
		add(okBtn);

		cancelBtn = new JButton("���");
		cancelBtn.setFont(new Font("���� ���", Font.BOLD, 14));
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
		if (e.getActionCommand() == "Ȯ��") {
			if (idT.getText().equals("") || answerT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��ĭ�� ��� ä���ּ���.");

			} else if (!idT.getText().equals("") || !answerT.getText().equals("")) {
				list = airlineDAO.getmemberList();
				for (MemberDTO memberDTO : list) {
					if (idT.getText() == null) {
						return;
					}
					if (idT.getText().equals(memberDTO.getId())) { // ������ ���̵� ������ ���� ��
						if (question.equals(memberDTO.getQuestion())
								&& answerT.getText().equals(memberDTO.getAnswer())) {
							check = 1;
							JOptionPane.showMessageDialog(this, "�����Ϸ�Ǿ����ϴ�.");
							String changePw = JOptionPane.showInputDialog(this, "�����Ͻ� ��й�ȣ�� �Է��ϼ���.");
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
					JOptionPane.showMessageDialog(this, "���� �� ������ ������ �ٸ��ϴ�.");
				} else if (check == 4) {
					JOptionPane.showMessageDialog(this, "���� �� �Է��� �亯�� �ٸ��ϴ�.");
				}
			}
		} else if (e.getActionCommand() == "���") {
			dispose();
		}
	}

}