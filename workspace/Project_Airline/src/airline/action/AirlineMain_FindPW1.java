package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class AirlineMain_FindPW1 extends JFrame implements ActionListener {
	private ImageIcon mlogo;
	private JTextField idT, mailT, codeT;
	private JLabel titleL, pwdL, idL, mailL, codeL;
	private JButton okBtn, cancelBtn, sendBtn;
	private AirlineDAO airlineDAO;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private AirlineMain_Email_PW aePW;
	private String codenum;

	public AirlineMain_FindPW1() {
		setLayout(null);
		setTitle("BitAirline_��й�ȣ ã��");
		
		getContentPane().setBackground(new Color(3, 136, 166));
		
		mlogo = new ImageIcon("mlogo.png");
		titleL = new JLabel(mlogo);
		titleL.setBounds(122, 5, 100, 30);
		add(titleL);

		pwdL = new JLabel("�̸��Ϸ� ã��");
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

		mailL = new JLabel("�̸���");
		mailL.setFont(new Font("���� ���", Font.BOLD, 14));
		mailL.setForeground(Color.WHITE);
		mailL.setBounds(30, 121, 50, 21);
		add(mailL);

		mailT = new JTextField();
		mailT.setFont(new Font("���� ���", Font.PLAIN, 17));
		mailT.setColumns(10);
		mailT.setBounds(105, 119, 140, 30);
		add(mailT);

		sendBtn = new JButton("����");
		sendBtn.setFont(new Font("���� ���", Font.BOLD, 13));
		sendBtn.setBounds(250, 119, 60, 29);
		add(sendBtn);

		codeL = new JLabel("�����ڵ�");
		codeL.setFont(new Font("���� ���", Font.BOLD, 14));
		codeL.setForeground(Color.WHITE);
		codeL.setBounds(30, 161, 70, 21);
		add(codeL);

		codeT = new JTextField();
		codeT.setFont(new Font("���� ���", Font.PLAIN, 17));
		codeT.setBounds(105, 159, 206, 30);
		codeT.setColumns(10);
		add(codeT);

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

		sendBtn.addActionListener(this);
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		sendBtn.setFocusable(false);
		okBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		airlineDAO = new AirlineDAO();
		int check = 0;
		if (e.getActionCommand() == "����") {
			list = airlineDAO.getmemberList();
			for (MemberDTO memberDTO : list) {
				if (idT.getText().equals(memberDTO.getId()) && mailT.getText().equals(memberDTO.getMail())) {
					check = 1;
					break;
				} else {
					check = 2;
				}
			}
			if (check == 1) {
				aePW = new AirlineMain_Email_PW(this);
				JOptionPane.showMessageDialog(this, "�����ڵ尡 ���۵Ǿ����ϴ�.");
				sendBtn.setEnabled(false);
			} else if (check == 2) {
				JOptionPane.showMessageDialog(this, "���̵�� �̸����� ��ġ���� �ʽ��ϴ�.");
			}

		} else if (e.getActionCommand() == "Ȯ��") {
			if (aePW == null)
				return;
			if (idT.getText().equals("") || mailT.getText().equals("") || codeT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��ĭ�� ��� ä���ּ���.");

			} else if (!idT.getText().equals("") && !mailT.getText().equals("") && !codeT.getText().equals("")) {
				if (codeT.getText().equals(aePW.getCode())) {
					check = 1;
				} else {
					check = 2;
				}
				if (check == 1) {
					list = airlineDAO.getmemberList();
					for (MemberDTO memberDTO : list) {
						if (idT.getText() == null) {
							return;
						}
						if (idT.getText().equals(memberDTO.getId())) {
							if (codeT.getText().equals(aePW.getCode())) {
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
							}
						}
					} // for
				} else if (check == 2) {
					JOptionPane.showMessageDialog(this, "�����ڵ尡 Ʋ���ϴ�.");
				}
			}
		} else if (e.getActionCommand() == "���") {
			dispose();
		}
	}

	public JTextField getMail() {
		return mailT;
	}

	public String getCodenum() {
		return codenum;
	}
}