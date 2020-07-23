package Project_01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AirlineMain_FindID extends JFrame implements ActionListener {
	private JTextField nameT, phoneT;
	private JLabel nameL, phoneL;
	private JButton okBtn, cancelBtn;

	public AirlineMain_FindID() {
		setLayout(null);
		setTitle("���̵� ã��");

		nameL = new JLabel("�̸�");
		nameL.setBounds(46, 69, 50, 21);
		add(nameL);

		nameT = new JTextField();
		nameT.setBounds(150, 69, 137, 21);
		add(nameT);
		nameT.setColumns(10);

		phoneL = new JLabel("����ó");
		phoneL.setBounds(46, 100, 50, 21);
		add(phoneL);

		phoneT = new JTextField();
		phoneT.setColumns(10);
		phoneT.setBounds(150, 100, 137, 21);
		add(phoneT);

		okBtn = new JButton("Ȯ��");
		okBtn.setBounds(46, 219, 91, 23);
		add(okBtn);

		cancelBtn = new JButton("���");
		cancelBtn.setBounds(196, 219, 91, 23);
		add(cancelBtn);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1450, 60, 350, 300);
		setVisible(true);
		setResizable(false);

		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Ȯ��") {
			JOptionPane.showMessageDialog(this, "������ ���̵�� " + "?? " + "�Դϴ�.");
			setVisible(false);
		} else if (e.getActionCommand() == "���") {
			setVisible(false);
		}
	}
}
