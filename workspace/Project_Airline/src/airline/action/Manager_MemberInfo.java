package airline.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class Manager_MemberInfo extends JFrame implements ActionListener {
	private JButton changeBtn, exitBtn, updateBtn;
	private JLabel idL, pwdL, nameL, phoneL, mailL, areaL;
	private JTextField idF, nameF, phoneF, mailF, areaF;
	private JPasswordField pwdF;
	private DefaultTableModel model2;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private AirlineDAO airlineDAO = new AirlineDAO();
	private MemberDTO memberDTO = new MemberDTO();
	private String loginId;
	private int seq, code;
	private String question, answer;

	public Manager_MemberInfo(String answerid, DefaultTableModel model2) {
		this.model2 = model2;
		this.loginId = answerid;
		setLayout(null);

		// JButton
		changeBtn = new JButton("����");
		changeBtn.setBounds(250, 260, 60, 35);
		changeBtn.setFont(new Font("���� ���", Font.BOLD, 13));

		updateBtn = new JButton("�����Ϸ�");
		updateBtn.setBounds(30, 390, 130, 35);
		updateBtn.setFont(new Font("���� ���", Font.BOLD, 13));
		exitBtn = new JButton("���");
		exitBtn.setBounds(182, 390, 130, 35);
		exitBtn.setFont(new Font("���� ���", Font.BOLD, 13));

		// JLabel
		idL = new JLabel("���̵�");
		idL.setBounds(40, 40, 80, 35);
		idL.setFont(new Font("���� ���", Font.BOLD, 13));
		idL.setForeground(Color.WHITE);

		pwdL = new JLabel("��й�ȣ");
		pwdL.setBounds(40, 95, 80, 35);
		pwdL.setFont(new Font("���� ���", Font.BOLD, 13));
		pwdL.setForeground(Color.WHITE);

		nameL = new JLabel("�̸�");
		nameL.setBounds(40, 150, 80, 35);
		nameL.setFont(new Font("���� ���", Font.BOLD, 13));
		nameL.setForeground(Color.WHITE);

		phoneL = new JLabel("����ó");
		phoneL.setBounds(40, 205, 100, 35);
		phoneL.setFont(new Font("���� ���", Font.BOLD, 13));
		phoneL.setForeground(Color.WHITE);

		mailL = new JLabel("�̸���");
		mailL.setBounds(40, 260, 80, 35);
		mailL.setFont(new Font("���� ���", Font.BOLD, 13));
		mailL.setForeground(Color.WHITE);

		areaL = new JLabel("��������");
		areaL.setBounds(40, 315, 80, 35);
		areaL.setFont(new Font("���� ���", Font.BOLD, 13));
		areaL.setForeground(Color.WHITE);

		// JTextField
		idF = new JTextField();
		idF.setBounds(130, 40, 180, 35);
		idF.setEnabled(false);

		pwdF = new JPasswordField();
		pwdF.setBounds(130, 95, 180, 35);
		pwdF.setEnabled(false);

		nameF = new JTextField();
		nameF.setBounds(130, 150, 180, 35);
		nameF.setEnabled(false);

		phoneF = new JTextField();
		phoneF.setEnabled(false);
		phoneF.setBounds(130, 205, 180, 35);

		mailF = new JTextField();
		mailF.setEnabled(false);
		mailF.setBounds(130, 260, 110, 35);

		areaF = new JTextField();
		areaF.setEnabled(false);
		areaF.setBounds(130, 315, 180, 35);

		Container c = getContentPane();
		c.add(changeBtn);
		c.add(updateBtn);
		c.add(exitBtn);
		c.add(idL);
		c.add(pwdL);
		c.add(nameL);
		c.add(phoneL);
		c.add(mailL);
		c.add(areaL);
		c.add(idF);
		c.add(pwdF);
		c.add(nameF);
		c.add(phoneF);
		c.add(mailF);
		c.add(areaF);

		output(loginId);

		setTitle("BitAirline_[������] ȸ�� ������ ");
		setSize(350, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(3, 136, 166));

		// �̺�Ʈ
		changeBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		updateBtn.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}// MemberInfo()

	public int output(String answerid) {
		this.loginId = answerid;
		int sw = 0;

		airlineDAO = new AirlineDAO();
		list = airlineDAO.getmemberList();

		for (MemberDTO memberDTO : list) {
			if (memberDTO.getId().equals(answerid)) {
				seq = memberDTO.getSeq();
				idF.setText(memberDTO.getId());
				pwdF.setText(memberDTO.getPw());
				nameF.setText(memberDTO.getName());
				phoneF.setText(memberDTO.getPhone());
				mailF.setText(memberDTO.getMail());
				areaF.setText(memberDTO.getAddress());
				question = memberDTO.getQuestion();
				answer = memberDTO.getAnswer();
				code = memberDTO.getCode();
			}
		}
		return sw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changeBtn) {
			mailF.setEnabled(true);
			changeBtn.setEnabled(false);
		} else if (e.getSource() == exitBtn) {
			dispose();
		} else if (e.getSource() == updateBtn) {
			int choice = JOptionPane.showConfirmDialog(this, "ȸ�������� �����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				if (choice == JOptionPane.YES_OPTION) {
					int check = 0;

					String mail = mailF.getText();

					for (MemberDTO memberDTO : list) {
						if (memberDTO.getMail().equals(mail)) {
							check = 1;
						}
					} // for
					if (check == 1) {
						JOptionPane.showMessageDialog(this, "�̹� �����ϴ� �̸��� �Դϴ�.");
					} else if (check == 0) {
						memberDTO.setSeq(seq);
						memberDTO.setId(idF.getText());
						memberDTO.setPw(pwdF.getText());
						memberDTO.setPw2(pwdF.getText());
						memberDTO.setName(nameF.getText());
						memberDTO.setPhone(phoneF.getText());
						memberDTO.setMail(mail);
						memberDTO.setAddress(areaF.getText());
						memberDTO.setQuestion(question);
						memberDTO.setAnswer(answer);
						memberDTO.setCode(code);

						// DB
						airlineDAO.member_update(memberDTO);

						// ����
						output2(model2);
						dispose();

						JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
					} // check ==2
				}
			} else if (choice == JOptionPane.NO_OPTION) {
				dispose();
			}
		} // upBtn()
	}// actionPerformed()

	public int output2(DefaultTableModel model2) {
		this.model2 = model2;
		model2.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list) {
			if (memberDTO.getCode() == 2) {
				Vector<String> v = new Vector<String>();
				v.add(memberDTO.getId());
				v.add(memberDTO.getName());
				v.add(memberDTO.getPhone());
				v.add(memberDTO.getMail());
				v.add(memberDTO.getAddress());
				model2.addRow(v);
				sw = 1;
			}
		}
		return sw;
	}
}