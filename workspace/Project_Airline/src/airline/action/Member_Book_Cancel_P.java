package airline.action;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Member_Book_Cancel_P extends JPanel {
	private JLabel selectL, psngrN, psngrNT, pspt, psptN, psptNT, sex, sexT, age, ageT, psngrSeat, psngrSeatT;
	private JTextField psptT;
	private JCheckBox select;

	public Member_Book_Cancel_P() {
		// ž�°� ���� ���� -> ����Ȯ�� �� ������� �����ӿ� �ʿ��� �г�
		setLayout(null);
		setBackground(new Color(3, 136, 166));

		selectL = new JLabel("����");
		selectL.setForeground(Color.WHITE);
		selectL.setFont(new Font("���� ���", Font.BOLD, 13));
		selectL.setBounds(23, 2, 65, 25);
		select = new JCheckBox();
		select.setBackground(new Color(3, 136, 166));
		select.setBounds(25, 30, 30, 30);

		psngrN = new JLabel("ž�°��̸�");
		psngrN.setForeground(Color.WHITE);
		psngrN.setFont(new Font("���� ���", Font.BOLD, 13));
		psngrN.setBounds(83, 2, 65, 25);
		psngrNT = new JLabel();
		psngrNT.setOpaque(true);
		psngrNT.setFont(new Font("���� ���", Font.PLAIN, 13));
		psngrNT.setBackground(Color.WHITE);
		psngrNT.setBounds(85, 32, 60, 30);

		pspt = new JLabel("���ǹ�ȣ");
		pspt.setForeground(Color.WHITE);
		pspt.setFont(new Font("���� ���", Font.BOLD, 13));
		pspt.setBounds(178, 2, 65, 25);
		psptT = new JTextField();
		psptT.setOpaque(true);
		psptT.setBackground(Color.WHITE);
		psptT.setFont(new Font("���� ���", Font.PLAIN, 13));
		psptT.setBounds(175, 32, 60, 30);

		psptN = new JLabel("�����̸�");
		psptN.setForeground(Color.WHITE);
		psptN.setFont(new Font("���� ���", Font.BOLD, 13));
		psptN.setBounds(293, 2, 65, 25);
		psptNT = new JLabel();
		psptNT.setOpaque(true);
		psptNT.setBackground(Color.WHITE);
		psptNT.setFont(new Font("���� ���", Font.PLAIN, 13));
		psptNT.setBounds(265, 32, 110, 30);

		sex = new JLabel("����");
		sex.setForeground(Color.WHITE);
		sex.setFont(new Font("���� ���", Font.BOLD, 13));
		sex.setBounds(407, 2, 65, 25);
		sexT = new JLabel();
		sexT.setOpaque(true);
		sexT.setBackground(Color.WHITE);
		sexT.setFont(new Font("���� ���", Font.PLAIN, 13));
		sexT.setBounds(405, 32, 30, 30);

		age = new JLabel("����");
		age.setForeground(Color.WHITE);
		age.setFont(new Font("���� ���", Font.BOLD, 13));
		age.setBounds(469, 2, 65, 25);
		ageT = new JLabel();
		ageT.setFont(new Font("���� ���", Font.PLAIN, 13));
		ageT.setOpaque(true);
		ageT.setBackground(Color.WHITE);
		ageT.setBounds(467, 32, 30, 30);

		psngrSeat = new JLabel("�¼�");
		psngrSeat.setForeground(Color.WHITE);
		psngrSeat.setFont(new Font("���� ���", Font.BOLD, 13));
		psngrSeat.setBounds(542, 2, 60, 25);
		psngrSeatT = new JLabel();
		psngrSeatT.setFont(new Font("���� ���", Font.PLAIN, 13));
		psngrSeatT.setOpaque(true);
		psngrSeatT.setBackground(Color.WHITE);
		psngrSeatT.setBounds(525, 32, 60, 30);

		add(selectL);
		add(select);
		add(psngrN);
		add(psngrNT);
		add(pspt);
		add(psptT);
		add(psptN);
		add(psptNT);
		add(sex);
		add(sexT);
		add(age);
		add(ageT);
		add(psngrSeat);
		add(psngrSeatT);
	}
}