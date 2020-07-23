package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import airline.bean.PaymentDTO;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;

public class Member_BookingPage2_PsngrInfo extends JPanel {
	private static int i = 0;
	private static int j = 0;
	private PaymentDTO paymentDTO = new PaymentDTO();
	private PlaneDTO planeDTO = new PlaneDTO();
	private AirlineDAO airlineDAO = new AirlineDAO();
	private JLabel noL, ageL, personL, seatL, payL;
	private JLabel noT, ageT, personT, seatT, payT;
	private String loginId, planecode, person;
	List<Member_BookingPage1_PsngrInfo> list;

	public Member_BookingPage2_PsngrInfo(String loginId, String planecode, String person,
			List<Member_BookingPage1_PsngrInfo> list) {
		this.loginId = loginId;
		this.planecode = planecode;
		this.person = person;
		this.list = list;
		// Å¾½Â°´¿îÀÓÁ¤º¸°¡ µé¾î°¡´Â ÆÐ³Î -> ¿¹¾àÇÏ±â Áß °áÁ¦ Ã¢¿¡ ÇÊ¿äÇÑ ÆÐ³Î
		setLayout(null);
		setBackground(new Color(3, 136, 166));

		noL = new JLabel("NO.");
		noL.setForeground(Color.WHITE);
		noL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		noL.setBounds(49, 5, 35, 25);
		noT = new JLabel();
		noT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		noT.setBounds(16, 35, 90, 33);
		noT.setOpaque(true);
		noT.setBackground(Color.WHITE);
		ageL = new JLabel("±¸ºÐ");
		ageL.setForeground(Color.WHITE);
		ageL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		ageL.setBounds(170, 5, 35, 25);
		ageT = new JLabel();
		ageT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		ageT.setBounds(139, 35, 90, 33);
		ageT.setOpaque(true);
		ageT.setBackground(Color.WHITE);
		personL = new JLabel("ÀÎ¿ø");
		personL.setForeground(Color.WHITE);
		personL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		personL.setBounds(293, 5, 35, 25);
		personT = new JLabel();
		personT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		personT.setBounds(262, 35, 90, 33);
		personT.setOpaque(true);
		personT.setBackground(Color.WHITE);

		seatL = new JLabel("ÁÂ¼®");
		seatL.setForeground(Color.WHITE);
		seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		seatL.setBounds(414, 5, 35, 25);
		seatT = new JLabel();
		seatT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		seatT.setBounds(383, 35, 90, 33);
		seatT.setOpaque(true);
		seatT.setBackground(Color.WHITE);
		payL = new JLabel("°¡°Ý");
		payL.setForeground(Color.WHITE);
		payL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		payL.setBounds(534, 5, 35, 25);
		payT = new JLabel();
		payT.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		payT.setBounds(503, 35, 90, 33);
		payT.setOpaque(true);
		payT.setBackground(Color.WHITE);
		add(noL);
		add(noT);
		add(ageL);
		add(ageT);
		add(personL);
		add(personT);
		add(seatL);
		add(seatT);
		add(payL);
		add(payT);
	}

	public int input(String loginId, String person, String planecode, List<Member_BookingPage1_PsngrInfo> list) {
		this.person = person;
		this.loginId = loginId;
		this.planecode = planecode;
		this.list = list;
		int count = 0;
		int price = 0;
		for (; j < list.size();) {
			paymentDTO.setSeq4(airlineDAO.getSeq4());
			paymentDTO.setPay("");
			paymentDTO.setCharge(0);
			i++;
			paymentDTO.setCount(i);
			paymentDTO.setOldyoung(Integer.parseInt(list.get(j).getAgeT().getText())); // ³ªÀÌ¸¦ ³Ö¾îÁà
			paymentDTO.setPeople(Integer.parseInt(this.person));
			paymentDTO.setSeat(list.get(j).getSeatL().getText());
			if(Integer.parseInt(list.get(j).getAgeT().getText()) < 15) {
				price = (int)(Double.parseDouble(planeDTO.getPrice())*0.3);
			}else if(Integer.parseInt(list.get(j).getAgeT().getText()) >= 15) {
				price = Integer.parseInt(list.get(j).getAgeT().getText());
			}
			paymentDTO.setPrice(price);
			paymentDTO.setPlanecode(this.planecode);
			paymentDTO.setId(this.loginId);

			airlineDAO.payment_insert(paymentDTO);
		}

		return count;
	}
}
