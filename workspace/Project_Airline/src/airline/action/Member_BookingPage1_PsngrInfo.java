package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import airline.bean.BookDTO;
import airline.dao.AirlineDAO;

public class Member_BookingPage1_PsngrInfo extends JPanel implements ActionListener {
	private JLabel psngrN, pspt, psptN, sex, age, seatL, psptNL;
	private JTextField psngrNT, psptT, psptNT1, psptNT2, ageT;
	private JRadioButton maleBtn, femaleBtn;
	private JButton seatBtn;
	private BookDTO bookDTO = new BookDTO();;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private int people;
	private String seat;
	private String planecode, loginId;
	private String ageS;
	private int ageI;

	public Member_BookingPage1_PsngrInfo(String loginId, int people, String planecode) {
		this.loginId = loginId;
		this.people = people;
		this.planecode = planecode;
		// Å¾½Â°´ Á¤º¸°¡ µé¾î°¡´Â ÆÐ³Î -> ¿¹¾àÇÏ±â Áß ÀÎ¿ø¼ö¸¦ ´©¸£¸é »ý¼ºµÇ´Â ÆÐ³Î
		setLayout(null);
		setBackground(new Color(3, 136, 166));

		psngrN = new JLabel("Å¾½Â°´ÀÌ¸§");
		psngrN.setForeground(Color.WHITE);
		psngrN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		psngrN.setBounds(23, 2, 65, 25);
		psngrNT = new JTextField();
		psngrNT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		psngrNT.setBounds(10, 27, 90, 45);
		pspt = new JLabel("¿©±Ç¹øÈ£");
		pspt.setForeground(Color.WHITE);
		pspt.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		pspt.setBounds(132, 2, 65, 25);
		psptT = new JTextField();
		psptT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		psptT.setBounds(113, 27, 90, 45);
		psptN = new JLabel("¿µ¹®ÀÌ¸§");
		psptN.setForeground(Color.WHITE);
		psptN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		psptN.setBounds(224, 2, 65, 25);
		psptNL = new JLabel("(ÀÌ¸§ / ¼º)");
		psptNL.setForeground(Color.WHITE);
		psptNL.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		psptNL.setBounds(277, 2, 65, 25);
		psptNT1 = new JTextField();
		psptNT1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		psptNT1.setBounds(215, 27, 70, 45);
		psptNT2 = new JTextField();
		psptNT2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		psptNT2.setBounds(290, 27, 45, 45);
		sex = new JLabel("¼ºº°");
		sex.setForeground(Color.WHITE);
		sex.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		sex.setBounds(390, 2, 65, 25);
		maleBtn = new JRadioButton("³²¼º", true);
		maleBtn.setForeground(Color.WHITE);
		maleBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		maleBtn.setBackground(new Color(3, 136, 166));
		maleBtn.setBounds(345, 37, 60, 25);
		femaleBtn = new JRadioButton("¿©¼º");
		femaleBtn.setForeground(Color.WHITE);
		femaleBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		femaleBtn.setBackground(new Color(3, 136, 166));
		femaleBtn.setBounds(405, 37, 60, 25);
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleBtn);
		bg.add(femaleBtn);
		age = new JLabel("³ªÀÌ");
		age.setForeground(Color.WHITE);
		age.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		age.setBounds(500, 2, 65, 25);
		ageT = new JTextField();
		ageT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		ageT.setBounds(470, 27, 90, 45);
		seatBtn = new JButton("ÁÂ¼®");
		seatBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		seatBtn.setBounds(580, 10, 87, 30);
		seatL = new JLabel("");
		seatL.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		seatL.setBounds(580, 41, 87, 29);
		seatL.setHorizontalAlignment(JLabel.CENTER);
		seatL.setBackground(Color.WHITE);
		seatL.setOpaque(true);

		add(psngrN);
		add(psngrNT);
		add(pspt);
		add(psptT);
		add(psptN);
		add(psptNL);
		add(psptNT1);
		add(psptNT2);
		add(sex);
		add(maleBtn);
		add(femaleBtn);
		add(age);
		add(ageT);
		add(seatBtn);
		add(seatL);

		seatBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == seatBtn) { // ÁÂ¼® ¹öÆ°
			new Member_BookingPage1_FlightSeat(this);
		}
	}

	public int input(String loginId, String planecode) {
		int sw = 0;
		this.loginId = loginId;
		this.planecode = planecode;
		
			if (psngrNT.getText().equals("") || psptT.getText().equals("") || psptNT1.getText().equals("")
					|| psptNT2.getText().equals("") || ageT.getText().equals("") || seatL.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "¸ðµç Ç×¸ñµéÀ» Ã¤¿öÁÖ¼¼¿ä.");
				sw=0;
				
			} else {
				bookDTO.setSeq3(airlineDAO.getSeq3());
				bookDTO.setPlanecode(this.planecode);
				bookDTO.setName(psngrNT.getText());
				bookDTO.setPassportnum(psptT.getText());
				bookDTO.setFirstname(psptNT1.getText());
				bookDTO.setLastname(psptNT2.getText());
				int gender = 0;
				if (maleBtn.isSelected())
					gender = 1;
				else if (femaleBtn.isSelected())
					gender = 2;
				bookDTO.setGender(gender);
				bookDTO.setAge(ageT.getText());
				bookDTO.setPeople(people);
				bookDTO.setSeat(seatL.getText());
				bookDTO.setId(this.loginId);

				airlineDAO.book_insert(bookDTO);
				sw = 1;
				
			}
		
		return sw;
	}

	public JLabel getSeatL() {
		return seatL;
	}
	public JTextField getAgeT() {
		return ageT;
	}

}
