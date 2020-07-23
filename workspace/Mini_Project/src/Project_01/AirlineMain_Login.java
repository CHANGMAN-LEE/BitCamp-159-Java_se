package Project_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AirlineMain_Login extends JFrame implements ActionListener {
	private JTextField idT;
	private JPasswordField pwT;
	private JLabel idL;
	private JLabel pwL;
	private JButton loginBtn, signupBtn, findIdBtn, findPwBtn;

	public AirlineMain_Login() {
		setLayout(null);
		setTitle("�α���");

		JLabel titleL = new JLabel("BitAirline");
		titleL.setFont(new Font("����", Font.PLAIN, 34));
		titleL.setBounds(100, 62, 138, 48);

		idT = new JTextField();
		idT.setBounds(121, 130, 188, 31);
		idT.setColumns(10);

		pwT = new JPasswordField();
		pwT.setEchoChar('*');
		pwT.setBounds(121, 175, 188, 31);
		pwT.setColumns(10);

		idL = new JLabel("���̵�");
		idL.setFont(new Font("����", Font.PLAIN, 20));
		idL.setBounds(32, 130, 70, 31);

		pwL = new JLabel("��й�ȣ");
		pwL.setFont(new Font("����", Font.PLAIN, 20));
		pwL.setBounds(32, 175, 82, 31);

		loginBtn = new JButton("�� �� ��");
		loginBtn.setFont(new Font("����", Font.PLAIN, 15));
		loginBtn.setBounds(32, 235, 282, 31);

		signupBtn = new JButton("ȸ �� �� ��");
		signupBtn.setFont(new Font("����", Font.PLAIN, 15));
		signupBtn.setBounds(32, 276, 282, 31);

		findIdBtn = new JButton("ID ã��");
		findIdBtn.setFont(new Font("����", Font.PLAIN, 15));
		findIdBtn.setBounds(32, 317, 140, 31);

		findPwBtn = new JButton("PW ã��");
		findPwBtn.setFont(new Font("����", Font.PLAIN, 15));
		findPwBtn.setBounds(174, 317, 140, 31);

		add(titleL); add(idT); add(pwT); add(idL); add(pwL); add(loginBtn);
		add(signupBtn); add(findIdBtn); add(findPwBtn);

		setBounds(1300, 100, 350, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		loginBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		findIdBtn.addActionListener(this);
		findPwBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "�� �� ��") {
			if (idT.getText().equals("admin")) {
				if (pwT.getText().equals("1111")) {
					new Manager_();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			} else if (idT.getText().equals("member")) {
				if (pwT.getText().equals("1111")) {
					new Member_();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
		} else if (e.getActionCommand() == "ȸ �� �� ��") {
			new AirlineMain_SignUp();
		} else if (e.getActionCommand() == "ID ã��") {
			new AirlineMain_FindID();
		} else if (e.getActionCommand() == "PW ã��") {
			new AirlineMain_FindPW();
		}
	}

	public static void main(String[] args) {
		new AirlineMain_Login();
	}

}