package airline.action;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Member_Book_Detail_P extends JPanel {
	private JLabel psngrN, psngrNT, pspt, psptT, psptN, psptNT, sex, sexT, age, ageT, psngrSeat, psngrSeatT;

	public Member_Book_Detail_P() {
		// ≈æΩ¬∞¥ øπæ‡ ¡§∫∏ -> øπæ‡»Æ¿Œ «¡∑π¿”ø° « ø‰«— ∆–≥Œ
		setLayout(null);
		setBackground(new Color(3, 136, 166));

		psngrN = new JLabel("≈æΩ¬∞¥¿Ã∏ß");
		psngrN.setForeground(Color.WHITE);
		psngrN.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		psngrN.setBounds(20, 2, 65, 25);
		psngrNT = new JLabel();
		psngrNT.setOpaque(true);
		psngrNT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		psngrNT.setBackground(Color.WHITE);
		psngrNT.setBounds(11, 32, 80, 30);

		pspt = new JLabel("ø©±«π¯»£");
		pspt.setForeground(Color.WHITE);
		pspt.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		pspt.setBounds(132, 2, 65, 25);
		psptT = new JLabel();
		psptT.setOpaque(true);
		psptT.setBackground(Color.WHITE);
		psptT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		psptT.setBounds(118, 32, 80, 30);

		psptN = new JLabel("øµπÆ¿Ã∏ß");
		psptN.setForeground(Color.WHITE);
		psptN.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		psptN.setBounds(261, 2, 65, 25);
		psptNT = new JLabel();
		psptNT.setOpaque(true);
		psptNT.setBackground(Color.WHITE);
		psptNT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		psptNT.setBounds(225, 32, 125, 30);

		sex = new JLabel("º∫∫∞");
		sex.setForeground(Color.WHITE);
		sex.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		sex.setBounds(387, 2, 65, 25);
		sexT = new JLabel();
		sexT.setOpaque(true);
		sexT.setBackground(Color.WHITE);
		sexT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		sexT.setBounds(380, 32, 40, 30);

		age = new JLabel("≥™¿Ã");
		age.setForeground(Color.WHITE);
		age.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		age.setBounds(455, 2, 65, 25);
		ageT = new JLabel();
		ageT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		ageT.setOpaque(true);
		ageT.setBackground(Color.WHITE);
		ageT.setBounds(448, 32, 40, 30);

		psngrSeat = new JLabel("¡¬ºÆ");
		psngrSeat.setForeground(Color.WHITE);
		psngrSeat.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 13));
		psngrSeat.setBounds(543, 2, 60, 25);
		psngrSeatT = new JLabel();
		psngrSeatT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 13));
		psngrSeatT.setOpaque(true);
		psngrSeatT.setBackground(Color.WHITE);
		psngrSeatT.setBounds(516, 32, 80, 30);

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
