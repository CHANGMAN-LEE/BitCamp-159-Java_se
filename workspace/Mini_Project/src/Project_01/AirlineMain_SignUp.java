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
		setTitle("ȸ������");

		idInputL = new JLabel("���̵� �Է�");
		idInputL.setFont(new Font("����", Font.PLAIN, 15));
		idInputL.setBounds(33, 32, 77, 26);
		getContentPane().add(idInputL);

		idInputT = new JTextField();
		idInputT.setBounds(121, 32, 141, 26);
		getContentPane().add(idInputT);
		idInputT.setColumns(10);

		idCheckBtn = new JButton("�ߺ�Ȯ��");
		idCheckBtn.setFont(new Font("����", Font.PLAIN, 10));
		idCheckBtn.setBounds(264, 38, 77, 20);
		getContentPane().add(idCheckBtn);

		idL = new JLabel("");
		idL.setBounds(121, 60, 220, 15);
		getContentPane().add(idL);

		pwInputL = new JLabel("��й�ȣ �Է�");
		pwInputL.setFont(new Font("����", Font.PLAIN, 15));
		pwInputL.setBounds(27, 99, 91, 26);
		getContentPane().add(pwInputL);

		pwInputT = new JPasswordField();
		pwInputT.setColumns(10);
		pwInputT.setBounds(121, 99, 141, 26);
		getContentPane().add(pwInputT);

		pwCheckL = new JLabel("��й�ȣ Ȯ��");
		pwCheckL.setFont(new Font("����", Font.PLAIN, 15));
		pwCheckL.setBounds(27, 135, 91, 26);
		getContentPane().add(pwCheckL);

		pwCheckLT = new JPasswordField();
		pwCheckLT.setColumns(10);
		pwCheckLT.setBounds(121, 135, 141, 26);
		getContentPane().add(pwCheckLT);

		pwL = new JLabel("");
		pwL.setBounds(264, 146, 51, 15);
		getContentPane().add(pwL);

		nameL = new JLabel("�̸�");
		nameL.setFont(new Font("����", Font.PLAIN, 15));
		nameL.setBounds(65, 180, 29, 26);
		getContentPane().add(nameL);

		nameT = new JTextField();
		nameT.setColumns(10);
		nameT.setBounds(121, 180, 141, 26);
		getContentPane().add(nameT);

		phoneL = new JLabel("����ó");
		phoneL.setFont(new Font("����", Font.PLAIN, 15));
		phoneL.setBounds(60, 216, 43, 26);
		getContentPane().add(phoneL);

		phoneT = new JTextField();
		phoneT.setColumns(10);
		phoneT.setBounds(121, 218, 141, 26);
		getContentPane().add(phoneT);

		phoneLabel = new JLabel("- ���� �Է�");
		phoneLabel.setBounds(264, 227, 70, 15);
		getContentPane().add(phoneLabel);

		mailL = new JLabel("�̸���");
		mailL.setFont(new Font("����", Font.PLAIN, 15));
		mailL.setBounds(60, 258, 43, 26);
		getContentPane().add(mailL);

		mailT = new JTextField();
		mailT.setColumns(10);
		mailT.setBounds(121, 258, 141, 26);
		getContentPane().add(mailT);

		mailBtn = new JButton("��������");
		mailBtn.setFont(new Font("����", Font.PLAIN, 10));
		mailBtn.setBounds(264, 264, 77, 20);
		getContentPane().add(mailBtn);

		codeT = new JTextField();
		codeT.setColumns(10);
		codeT.setBounds(121, 285, 141, 26);
		getContentPane().add(codeT);

		codeBtn = new JButton("����Ȯ��");
		codeBtn.setFont(new Font("����", Font.PLAIN, 10));
		codeBtn.setBounds(264, 291, 77, 20);
		getContentPane().add(codeBtn);

		addressL = new JLabel("�ּ�");
		addressL.setFont(new Font("����", Font.PLAIN, 15));
		addressL.setBounds(65, 321, 29, 26);
		getContentPane().add(addressL);

		address = new JComboBox();
		address.setModel(new DefaultComboBoxModel(new String[] { "������", "���ֱ�����", "��⵵", "��󳲵�", "���ϵ�", "�뱸������",
				"����������", "�λ걤����", "����Ư����", "����Ư����ġ��", "��õ������", "��걤����", "���󳲵�", "����ϵ�", "����Ư����ġ��", "��û�ϵ�", "��û����" }));
		address.setBounds(121, 321, 141, 26);
		getContentPane().add(address);

		questionL = new JLabel("����");
		questionL.setFont(new Font("����", Font.PLAIN, 15));
		questionL.setBounds(65, 363, 29, 26);
		getContentPane().add(questionL);

		question = new JComboBox();
		question.setModel(new DefaultComboBoxModel(new String[] { "��� �ʵ��б���?", "��Ӵ� ������?", "�ƹ��� ������?" }));
		question.setBounds(121, 363, 141, 26);
		getContentPane().add(question);

		answerL = new JLabel("��");
		answerL.setFont(new Font("����", Font.PLAIN, 15));
		answerL.setBounds(65, 391, 29, 26);
		getContentPane().add(answerL);

		anwerT = new JTextField();
		anwerT.setColumns(10);
		anwerT.setBounds(121, 391, 141, 26);
		getContentPane().add(anwerT);

		JButton joinBtn = new JButton("����");
		joinBtn.setBounds(68, 427, 91, 23);
		getContentPane().add(joinBtn);

		cancelBtn = new JButton("���");
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
		if (push == "����") {
			dto = new SignUpDTO();
			if (idInputT.getText().equals("") || pwInputT.getText().equals("") || pwCheckLT.getText().equals("")
					|| nameT.getText().equals("") || phoneT.getText().equals("") || mailT.getText().equals("")
					|| codeT.getText().equals("") || anwerT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "��ĭ�� ��� ä���ּ���.");
			} else if (!pwInputT.getText().equals(pwCheckLT.getText())) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
		} else if (push == "�ߺ�Ȯ��") {
//			System.out.println("����");
			String id = idInputT.getText();
			int check = 0;
			for (SignUpDTO dto : list) {
				if (dto.getId().equals(id)) {
					check = 1;
				}
			}
			if (check == 1) {
				idL.setText("�̹� �����ϴ� ���̵� �Դϴ�.");
			} else if (check == 0) {
				idL.setText("��밡���� ���̵� �Դϴ�.");
			}
		} else if (push == "���") {
			setVisible(false);
		}
	}
}