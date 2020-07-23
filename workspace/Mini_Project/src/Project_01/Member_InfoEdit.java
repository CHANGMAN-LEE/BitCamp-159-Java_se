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

		myInfoL = new JLabel("�⺻ ����");
		myInfoL.setFont(new Font("�������ü", Font.BOLD, 16));
		myInfoL.setBounds(270, 5, 70, 40);

		idL = new JLabel("���̵�");
		idL.setBounds(14, 40, 35, 25);
		idT = new JTextField();
		idT.setEditable(false);
		idT.setBounds(14, 60, 320, 33);

		pwdL = new JLabel("��й�ȣ");
		pwdL.setBounds(14, 95, 50, 25);
		pwdT = new JTextField();
		pwdT.setBounds(14, 115, 263, 33);
		pwdEdB = new JButton("����");
		pwdEdB.setBounds(283, 115, 50, 33);

		nameL = new JLabel("�̸�");
		nameL.setBounds(14, 150, 25, 25);
		nameT = new JTextField();
		nameT.setBounds(14, 170, 263, 33);
		nameEdB = new JButton("����");
		nameEdB.setBounds(283, 170, 50, 33);

		phoneL = new JLabel("����ó");
		phoneL.setBounds(14, 205, 50, 25);
		phoneT = new JTextField();
		phoneT.setBounds(14, 225, 263, 33);
		phoneEdB = new JButton("����");
		phoneEdB.setBounds(283, 225, 50, 33);

		addressL = new JLabel("�ּ�");
		addressL.setBounds(14, 270, 25, 25);

		addressComboBox = new JComboBox();
		addressComboBox.setModel(new DefaultComboBoxModel(new String[] { "������", "���ֱ�����", "��⵵", "��󳲵�", "���ϵ�", "�뱸������",
				"����������", "�λ걤����", "����Ư����", "����Ư����ġ��", "��õ������", "��걤����", "���󳲵�", "����ϵ�", "����Ư����ġ��", "��û�ϵ�", "��û����" }));
		addressComboBox.setBounds(45, 263, 290, 40);

		emailL = new JLabel("�̸���");
		emailL.setBounds(14, 295, 35, 25);
		emailT = new JTextField();
		emailT.setBounds(14, 315, 263, 31);
		emailEdB = new JButton("����");
		emailEdB.setBounds(283, 315, 50, 31);

		questionL = new JLabel("����");
		questionL.setBounds(14, 360, 35, 25);

		questionComboBox = new JComboBox();
		questionComboBox.setModel(new DefaultComboBoxModel(new String[] { "��� �ʵ��б���?", "��Ӵ� ������?", "�ƹ��� ������?" }));
		questionComboBox.setBounds(45, 353, 290, 40);

		answerL = new JLabel("��");
		answerL.setBounds(14, 395, 25, 25);
		answerT = new JTextField();
		answerT.setColumns(10);
		answerT.setBounds(45, 395, 263, 33);

		editBtn = new JButton("���� �Ϸ�");
		editBtn.setBounds(55, 430, 120, 35);
		cancelBtn = new JButton("���");
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

		setTitle("���� ����");
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
			String pwd = JOptionPane.showInputDialog(this, "�����Ͻ� ��й�ȣ�� �Է��ϼ���.", "��й�ȣ ����",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == nameEdB) {
			String name = JOptionPane.showInputDialog(this, "�����Ͻ� �̸��� �Է��ϼ���.", "�̸� ����",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == phoneEdB) {
			String phone = JOptionPane.showInputDialog(this, "�����Ͻ� ��ȭ��ȣ�� �Է��ϼ���.", "����ó ����",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == emailEdB) {
			String address = JOptionPane.showInputDialog(this, "�����Ͻ� �ּҸ� �Է��ϼ���.", "�ּ� ����",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == editBtn) {
			JOptionPane.showMessageDialog(this, "���� �Ϸ�", "����", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		} else if (e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}
