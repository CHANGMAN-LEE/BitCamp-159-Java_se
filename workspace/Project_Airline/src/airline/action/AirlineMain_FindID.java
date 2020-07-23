package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AirlineMain_FindID extends JFrame implements ActionListener {
	private ImageIcon mlogo;
	private JTextField nameT, phoneT;
	private JLabel titleL, idL, nameL, phoneL;
	private JButton okBtn, cancelBtn;
	private AirlineDAO airlineDAO;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();

	public AirlineMain_FindID() {
		setLayout(null);
		setTitle("BitAirline_[�α���] ���̵� ã��");
		getContentPane().setBackground(new Color(3, 136, 166));

		mlogo = new ImageIcon("mlogo.png");
		titleL = new JLabel(mlogo);
		titleL.setBounds(122, 5, 100, 30);
		add(titleL);

		idL = new JLabel("���̵� ã��");
		idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setFont(new Font("���� ���", Font.BOLD, 22));
		idL.setForeground(Color.WHITE);
		idL.setBounds(100, 35, 145, 30);
		add(idL);

		nameL = new JLabel("�̸�");
		nameL.setFont(new Font("���� ���", Font.BOLD, 17));
		nameL.setForeground(Color.WHITE);
		nameL.setBounds(50, 91, 50, 21);
		add(nameL);

		nameT = new JTextField();
		nameT.setBounds(122, 87, 170, 30);
		nameT.setFont(new Font("���� ���", Font.PLAIN, 17));
		add(nameT);
		nameT.setColumns(10);

		phoneL = new JLabel("����ó");
		phoneL.setFont(new Font("���� ���", Font.BOLD, 17));
		phoneL.setForeground(Color.WHITE);
		phoneL.setBounds(50, 141, 52, 21);
		add(phoneL);

		phoneT = new JTextField();
		phoneT.setColumns(10);
		phoneT.setFont(new Font("���� ���", Font.PLAIN, 17));
		phoneT.setBounds(122, 137, 170, 30);
		add(phoneT);

		okBtn = new JButton("Ȯ��");
		okBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		okBtn.setBounds(75, 200, 91, 28);
		add(okBtn);

		cancelBtn = new JButton("���");
		cancelBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		cancelBtn.setBounds(175, 200, 91, 28);
		add(cancelBtn);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 270);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "Ȯ��") {
			airlineDAO = new AirlineDAO();
			list = airlineDAO.getmemberList();
			for (MemberDTO memberDTO : list) {
				if (nameT.getText().equals("") || phoneT.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "�� ĭ�� ä���ּ���.");
					break;
				} else if (!nameT.getText().equals("")) {
					if (nameT.getText().equals(memberDTO.getName())) {
						if (phoneT.getText().equals(memberDTO.getPhone())) {
							JOptionPane.showMessageDialog(this, "������ ���̵�� " + memberDTO.getId() + " �Դϴ�.");
							dispose();
							break;
						} else if (!phoneT.getText().equals(memberDTO.getPhone())) {
							JOptionPane.showMessageDialog(this, "�ڵ��� ��ȣ�� Ʋ�Ƚ��ϴ�.");
						}
					}
				}
			}

		} else if (e.getActionCommand() == "���") {
			dispose();
		}
	}
}