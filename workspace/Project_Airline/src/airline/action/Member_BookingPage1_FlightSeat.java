package airline.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import airline.bean.BookDTO;
import airline.bean.MemberDTO;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;

public class Member_BookingPage1_FlightSeat extends JFrame implements ActionListener {
	private BookDTO bookDTO = new BookDTO();
	private AirlineDAO airlineDAO = new AirlineDAO();
	private List<BookDTO> list = new ArrayList<BookDTO>();
	private Image img;
	private ImageIcon air;
	private JPanel seatP, infoP;
	private JLabel classL, businessImgL, businessL, economyImgL, economyL, infoL, seatL;
	private JButton choiceBtn, backBtn, businessA1, businessC1, businessD1, businessG1, businessH1, businessK1,
			businessA2, businessC2, businessD2, businessG2, businessH2, businessK2, businessA3, businessC3, businessD3,
			businessG3, businessH3, businessK3, businessA4, businessC4, businessD4, businessG4, businessH4, businessK4,
			businessA5, businessC5, businessD5, businessG5, businessH5, businessK5, economyA10, economyC10, economyD10,
			economyE10, economyF10, economyG10, economyH10, economyK10, economyA11, economyC11, economyD11, economyE11,
			economyF11, economyG11, economyH11, economyK11, economyA12, economyC12, economyD12, economyE12, economyF12,
			economyG12, economyH12, economyK12, economyA14, economyC14, economyD14, economyE14, economyF14, economyG14,
			economyH14, economyK14, economyA15, economyC15, economyD15, economyE15, economyF15, economyG15, economyH15,
			economyK15, economyA16, economyC16, economyD16, economyE16, economyF16, economyG16, economyH16, economyK16,
			economyA17, economyC17, economyD17, economyE17, economyF17, economyG17, economyH17, economyK17, economyA18,
			economyC18, economyD18, economyE18, economyF18, economyG18, economyH18, economyK18, economyA19, economyC19,
			economyD19, economyE19, economyF19, economyG19, economyH19, economyK19, economyA20, economyC20, economyD20,
			economyE20, economyF20, economyG20, economyH20, economyK20, economyA21, economyC21, economyD21, economyE21,
			economyF21, economyG21, economyH21, economyK21, economyA22, economyC22, economyD22, economyE22, economyF22,
			economyG22, economyH22, economyK22, economyA23, economyC23, economyD23, economyE23, economyF23, economyG23,
			economyH23, economyK23, economyA24, economyC24, economyD24, economyE24, economyF24, economyG24, economyH24,
			economyK24, economyA25, economyC25, economyD25, economyE25, economyF25, economyG25, economyH25, economyK25,
			economyA26, economyC26, economyD26, economyE26, economyF26, economyG26, economyH26, economyK26, economyD27,
			economyE27, economyF27, economyG27, economyH27, economyK27;
	private Member_BookingPage1_PsngrInfo mbp;

	public Member_BookingPage1_FlightSeat(Member_BookingPage1_PsngrInfo mbp) {
		this.mbp = mbp;
		setLayout(null);
		getContentPane().setBackground(new Color(3, 101, 140));

		// ÁÂ¼®¶õ
		seatP = new JPanel();
		seatP.setLayout(null);

		classL = new JLabel("ÁÂ ¼® µî ±Þ ");
		classL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		classL.setBounds(80, 0, 185, 35);

		businessImgL = new JLabel(new ImageIcon("business.png"));
		businessImgL.setBounds(50, 35, 30, 30);
		economyImgL = new JLabel(new ImageIcon("economy.png"));
		economyImgL.setBounds(50, 65, 30, 30);

		businessL = new JLabel("ºñÁî´Ï½º µî±Þ ");
		businessL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		businessL.setBounds(100, 32, 100, 35);

		economyL = new JLabel("ÀÌÄÚ³ë¹Ì µî±Þ ");
		economyL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		economyL.setBounds(100, 62, 100, 35);

		seatP.add(classL);
		seatP.add(businessImgL);
		seatP.add(economyImgL);
		seatP.add(businessL);
		seatP.add(economyL);

		seatP.setBackground(new Color(238, 238, 238));
		seatP.setBounds(745, 7, 240, 100);

		// Á¤º¸¶õ
		infoP = new JPanel();
		infoP.setLayout(null);

		String name = "ºñÆ®Ä·";
		String seat = "";

		infoL = new JLabel("¼± ÅÃ ÇÑ   ÁÂ ¼® Á¤ º¸");
		infoL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		infoL.setBounds(39, 2, 240, 35);

		seatL = new JLabel();
		seatL.setHorizontalAlignment(JLabel.CENTER);
		seatL.setBounds(63, 43, 112, 35);

		choiceBtn = new JButton("¼±ÅÃ ¿Ï·á");
		choiceBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		choiceBtn.setBounds(20, 100, 200, 35);
		backBtn = new JButton("µÚ·Î°¡±â");
		backBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		backBtn.setBounds(20, 140, 200, 35);

		infoP.add(infoL);
		infoP.add(seatL);
		infoP.add(choiceBtn);
		infoP.add(backBtn);

		infoP.setBackground(new Color(238, 238, 238));
		infoP.setBounds(745, 370, 240, 190);

		Icon air = new ImageIcon("seat.png");
		JLabel backgroundL = new JLabel(air);
		backgroundL.setPreferredSize(new Dimension(700, 1500));
		backgroundL.setAutoscrolls(true);

		JScrollPane scroll = new JScrollPane(backgroundL);
		// scroll.setViewportView(backgroundL);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(5, 7, 730, 560);
		scroll.setAutoscrolls(true);

		// business¼®
		businessA1 = new JButton();
		businessA1.setBounds(260, 242, 13, 13);
		businessA1.setBackground(new Color(235, 196, 92));
		businessA1.setOpaque(false);
		businessC1 = new JButton();
		businessC1.setBounds(287, 242, 13, 13);
		businessC1.setBackground(new Color(235, 196, 92));
		businessC1.setOpaque(false);
		businessD1 = new JButton();
		businessD1.setBounds(335, 229, 13, 13);
		businessD1.setBackground(new Color(235, 196, 92));
		businessD1.setOpaque(false);
		businessG1 = new JButton();
		businessG1.setBounds(364, 229, 13, 13);
		businessG1.setBackground(new Color(235, 196, 92));
		businessG1.setOpaque(false);
		businessH1 = new JButton();
		businessH1.setBounds(411, 242, 13, 13);
		businessH1.setBackground(new Color(235, 196, 92));
		businessH1.setOpaque(false);
		businessK1 = new JButton();
		businessK1.setBounds(440, 242, 13, 13);
		businessK1.setBackground(new Color(235, 196, 92));
		businessK1.setOpaque(false);

		businessA2 = new JButton();
		businessA2.setBounds(260, 282, 13, 13);
		businessA2.setBackground(new Color(235, 196, 92));
		businessC2 = new JButton();
		businessC2.setBounds(287, 282, 13, 13);
		businessC2.setBackground(new Color(235, 196, 92));
		businessD2 = new JButton();
		businessD2.setBounds(335, 269, 13, 13);
		businessD2.setBackground(new Color(235, 196, 92));
		businessG2 = new JButton();
		businessG2.setBounds(364, 269, 13, 13);
		businessG2.setBackground(new Color(235, 196, 92));
		businessH2 = new JButton();
		businessH2.setBounds(411, 282, 13, 13);
		businessH2.setBackground(new Color(235, 196, 92));
		businessK2 = new JButton();
		businessK2.setBounds(440, 282, 13, 13);
		businessK2.setBackground(new Color(235, 196, 92));

		businessA3 = new JButton();
		businessA3.setBounds(260, 322, 13, 13);
		businessA3.setBackground(new Color(235, 196, 92));
		businessC3 = new JButton();
		businessC3.setBounds(287, 322, 13, 13);
		businessC3.setBackground(new Color(235, 196, 92));
		businessD3 = new JButton();
		businessD3.setBounds(335, 309, 13, 13);
		businessD3.setBackground(new Color(235, 196, 92));
		businessG3 = new JButton();
		businessG3.setBounds(364, 309, 13, 13);
		businessG3.setBackground(new Color(235, 196, 92));
		businessH3 = new JButton();
		businessH3.setBounds(411, 322, 13, 13);
		businessH3.setBackground(new Color(235, 196, 92));
		businessK3 = new JButton();
		businessK3.setBounds(440, 322, 13, 13);
		businessK3.setBackground(new Color(235, 196, 92));

		businessA4 = new JButton();
		businessA4.setBounds(260, 362, 13, 13);
		businessA4.setBackground(new Color(235, 196, 92));
		businessC4 = new JButton();
		businessC4.setBounds(287, 362, 13, 13);
		businessC4.setBackground(new Color(235, 196, 92));
		businessD4 = new JButton();
		businessD4.setBounds(335, 349, 13, 13);
		businessD4.setBackground(new Color(235, 196, 92));
		businessG4 = new JButton();
		businessG4.setBounds(364, 349, 13, 13);
		businessG4.setBackground(new Color(235, 196, 92));
		businessH4 = new JButton();
		businessH4.setBounds(411, 362, 13, 13);
		businessH4.setBackground(new Color(235, 196, 92));
		businessK4 = new JButton();
		businessK4.setBounds(440, 362, 13, 13);
		businessK4.setBackground(new Color(235, 196, 92));

		businessA5 = new JButton();
		businessA5.setBounds(260, 402, 13, 13);
		businessA5.setBackground(new Color(235, 196, 92));
		businessC5 = new JButton();
		businessC5.setBounds(287, 402, 13, 13);
		businessC5.setBackground(new Color(235, 196, 92));
		businessD5 = new JButton();
		businessD5.setBounds(335, 389, 13, 13);
		businessD5.setBackground(new Color(235, 196, 92));
		businessG5 = new JButton();
		businessG5.setBounds(364, 389, 13, 13);
		businessG5.setBackground(new Color(235, 196, 92));
		businessH5 = new JButton();
		businessH5.setBounds(411, 402, 13, 13);
		businessH5.setBackground(new Color(235, 196, 92));
		businessK5 = new JButton();
		businessK5.setBounds(440, 402, 13, 13);
		businessK5.setBackground(new Color(235, 196, 92));

		// economy¼®
		economyA10 = new JButton();
		economyA10.setBounds(260, 557, 13, 13);
		economyA10.setBackground(new Color(242, 99, 157));
		economyC10 = new JButton();
		economyC10.setBounds(279, 557, 13, 13);
		economyC10.setBackground(new Color(242, 99, 157));
		economyD10 = new JButton();
		economyD10.setBounds(322, 541, 13, 13);
		economyD10.setBackground(new Color(242, 99, 157));
		economyE10 = new JButton();
		economyE10.setBounds(340, 541, 13, 13);
		economyE10.setBackground(new Color(242, 99, 157));
		economyF10 = new JButton();
		economyF10.setBounds(360, 541, 13, 13);
		economyF10.setBackground(new Color(242, 99, 157));
		economyG10 = new JButton();
		economyG10.setBounds(378, 541, 13, 13);
		economyG10.setBackground(new Color(242, 99, 157));
		economyH10 = new JButton();
		economyH10.setBounds(420, 560, 13, 13);
		economyH10.setBackground(new Color(242, 99, 157));
		economyK10 = new JButton();
		economyK10.setBounds(439, 560, 13, 13);
		economyK10.setBackground(new Color(242, 99, 157));

		economyA11 = new JButton();
		economyA11.setBounds(260, 580, 13, 13);
		economyA11.setBackground(new Color(242, 99, 157));
		economyC11 = new JButton();
		economyC11.setBounds(279, 580, 13, 13);
		economyC11.setBackground(new Color(242, 99, 157));
		economyD11 = new JButton();
		economyD11.setBounds(322, 565, 13, 13);
		economyD11.setBackground(new Color(242, 99, 157));
		economyE11 = new JButton();
		economyE11.setBounds(340, 565, 13, 13);
		economyE11.setBackground(new Color(242, 99, 157));
		economyF11 = new JButton();
		economyF11.setBounds(359, 565, 13, 13);
		economyF11.setBackground(new Color(242, 99, 157));
		economyG11 = new JButton();
		economyG11.setBounds(377, 565, 13, 13);
		economyG11.setBackground(new Color(242, 99, 157));
		economyH11 = new JButton();
		economyH11.setBounds(420, 584, 13, 13);
		economyH11.setBackground(new Color(242, 99, 157));
		economyK11 = new JButton();
		economyK11.setBounds(439, 584, 13, 13);
		economyK11.setBackground(new Color(242, 99, 157));

		economyA12 = new JButton();
		economyA12.setBounds(260, 603, 13, 13);
		economyA12.setBackground(new Color(242, 99, 157));
		economyC12 = new JButton();
		economyC12.setBounds(279, 603, 13, 13);
		economyC12.setBackground(new Color(242, 99, 157));
		economyD12 = new JButton();
		economyD12.setBounds(322, 589, 13, 13);
		economyD12.setBackground(new Color(242, 99, 157));
		economyE12 = new JButton();
		economyE12.setBounds(340, 589, 13, 13);
		economyE12.setBackground(new Color(242, 99, 157));
		economyF12 = new JButton();
		economyF12.setBounds(359, 589, 13, 13);
		economyF12.setBackground(new Color(242, 99, 157));
		economyG12 = new JButton();
		economyG12.setBounds(377, 589, 13, 13);
		economyG12.setBackground(new Color(242, 99, 157));
		economyH12 = new JButton();
		economyH12.setBounds(420, 608, 13, 13);
		economyH12.setBackground(new Color(242, 99, 157));
		economyK12 = new JButton();
		economyK12.setBounds(439, 608, 13, 13);
		economyK12.setBackground(new Color(242, 99, 157));

		economyA14 = new JButton();
		economyA14.setBounds(260, 626, 13, 13);
		economyA14.setBackground(new Color(242, 99, 157));
		economyC14 = new JButton();
		economyC14.setBounds(279, 626, 13, 13);
		economyC14.setBackground(new Color(242, 99, 157));
		economyD14 = new JButton();
		economyD14.setBounds(322, 612, 13, 13);
		economyD14.setBackground(new Color(242, 99, 157));
		economyE14 = new JButton();
		economyE14.setBounds(340, 612, 13, 13);
		economyE14.setBackground(new Color(242, 99, 157));
		economyF14 = new JButton();
		economyF14.setBounds(359, 612, 13, 13);
		economyF14.setBackground(new Color(242, 99, 157));
		economyG14 = new JButton();
		economyG14.setBounds(377, 612, 13, 13);
		economyG14.setBackground(new Color(242, 99, 157));
		economyH14 = new JButton();
		economyH14.setBounds(420, 630, 13, 13);
		economyH14.setBackground(new Color(242, 99, 157));
		economyK14 = new JButton();
		economyK14.setBounds(439, 630, 13, 13);
		economyK14.setBackground(new Color(242, 99, 157));

		economyA15 = new JButton();
		economyA15.setBounds(260, 648, 13, 13);
		economyA15.setBackground(new Color(242, 99, 157));
		economyC15 = new JButton();
		economyC15.setBounds(279, 648, 13, 13);
		economyC15.setBackground(new Color(242, 99, 157));
		economyD15 = new JButton();
		economyD15.setBounds(322, 633, 13, 13);
		economyD15.setBackground(new Color(242, 99, 157));
		economyE15 = new JButton();
		economyE15.setBounds(340, 633, 13, 13);
		economyE15.setBackground(new Color(242, 99, 157));
		economyF15 = new JButton();
		economyF15.setBounds(359, 633, 13, 13);
		economyF15.setBackground(new Color(242, 99, 157));
		economyG15 = new JButton();
		economyG15.setBounds(377, 633, 13, 13);
		economyG15.setBackground(new Color(242, 99, 157));
		economyH15 = new JButton();
		economyH15.setBounds(420, 652, 13, 13);
		economyH15.setBackground(new Color(242, 99, 157));
		economyK15 = new JButton();
		economyK15.setBounds(439, 652, 13, 13);
		economyK15.setBackground(new Color(242, 99, 157));

		economyA16 = new JButton();
		economyA16.setBounds(260, 671, 13, 13);
		economyA16.setBackground(new Color(242, 99, 157));
		economyC16 = new JButton();
		economyC16.setBounds(279, 671, 13, 13);
		economyC16.setBackground(new Color(242, 99, 157));
		economyD16 = new JButton();
		economyD16.setBounds(322, 656, 13, 13);
		economyD16.setBackground(new Color(242, 99, 157));
		economyE16 = new JButton();
		economyE16.setBounds(340, 656, 13, 13);
		economyE16.setBackground(new Color(242, 99, 157));
		economyF16 = new JButton();
		economyF16.setBounds(359, 656, 13, 13);
		economyF16.setBackground(new Color(242, 99, 157));
		economyG16 = new JButton();
		economyG16.setBounds(377, 656, 13, 13);
		economyG16.setBackground(new Color(242, 99, 157));
		economyH16 = new JButton();
		economyH16.setBounds(420, 675, 13, 13);
		economyH16.setBackground(new Color(242, 99, 157));
		economyK16 = new JButton();
		economyK16.setBounds(439, 675, 13, 13);
		economyK16.setBackground(new Color(242, 99, 157));

		economyA17 = new JButton();
		economyA17.setBounds(260, 694, 13, 13);
		economyA17.setBackground(new Color(242, 99, 157));
		economyC17 = new JButton();
		economyC17.setBounds(279, 694, 13, 13);
		economyC17.setBackground(new Color(242, 99, 157));
		economyD17 = new JButton();
		economyD17.setBounds(322, 679, 13, 13);
		economyD17.setBackground(new Color(242, 99, 157));
		economyE17 = new JButton();
		economyE17.setBounds(340, 679, 13, 13);
		economyE17.setBackground(new Color(242, 99, 157));
		economyF17 = new JButton();
		economyF17.setBounds(359, 679, 13, 13);
		economyF17.setBackground(new Color(242, 99, 157));
		economyG17 = new JButton();
		economyG17.setBounds(377, 679, 13, 13);
		economyG17.setBackground(new Color(242, 99, 157));
		economyH17 = new JButton();
		economyH17.setBounds(420, 698, 13, 13);
		economyH17.setBackground(new Color(242, 99, 157));
		economyK17 = new JButton();
		economyK17.setBounds(439, 698, 13, 13);
		economyK17.setBackground(new Color(242, 99, 157));

		economyA18 = new JButton();
		economyA18.setBounds(260, 717, 13, 13);
		economyA18.setBackground(new Color(242, 99, 157));
		economyC18 = new JButton();
		economyC18.setBounds(279, 717, 13, 13);
		economyC18.setBackground(new Color(242, 99, 157));
		economyD18 = new JButton();
		economyD18.setBounds(322, 703, 13, 13);
		economyD18.setBackground(new Color(242, 99, 157));
		economyE18 = new JButton();
		economyE18.setBounds(340, 703, 13, 13);
		economyE18.setBackground(new Color(242, 99, 157));
		economyF18 = new JButton();
		economyF18.setBounds(359, 703, 13, 13);
		economyF18.setBackground(new Color(242, 99, 157));
		economyG18 = new JButton();
		economyG18.setBounds(377, 703, 13, 13);
		economyG18.setBackground(new Color(242, 99, 157));
		economyH18 = new JButton();
		economyH18.setBounds(420, 722, 13, 13);
		economyH18.setBackground(new Color(242, 99, 157));
		economyK18 = new JButton();
		economyK18.setBounds(439, 722, 13, 13);
		economyK18.setBackground(new Color(242, 99, 157));

		economyA19 = new JButton();
		economyA19.setBounds(260, 740, 13, 13);
		economyA19.setBackground(new Color(242, 99, 157));
		economyC19 = new JButton();
		economyC19.setBounds(279, 740, 13, 13);
		economyC19.setBackground(new Color(242, 99, 157));
		economyD19 = new JButton();
		economyD19.setBounds(322, 726, 13, 13);
		economyD19.setBackground(new Color(242, 99, 157));
		economyE19 = new JButton();
		economyE19.setBounds(340, 726, 13, 13);
		economyE19.setBackground(new Color(242, 99, 157));
		economyF19 = new JButton();
		economyF19.setBounds(359, 726, 13, 13);
		economyF19.setBackground(new Color(242, 99, 157));
		economyG19 = new JButton();
		economyG19.setBounds(377, 726, 13, 13);
		economyG19.setBackground(new Color(242, 99, 157));
		economyH19 = new JButton();
		economyH19.setBounds(420, 744, 13, 13);
		economyH19.setBackground(new Color(242, 99, 157));
		economyK19 = new JButton();
		economyK19.setBounds(439, 744, 13, 13);
		economyK19.setBackground(new Color(242, 99, 157));

		economyA20 = new JButton();
		economyA20.setBounds(260, 763, 13, 13);
		economyA20.setBackground(new Color(242, 99, 157));
		economyC20 = new JButton();
		economyC20.setBounds(279, 763, 13, 13);
		economyC20.setBackground(new Color(242, 99, 157));
		economyD20 = new JButton();
		economyD20.setBounds(322, 750, 13, 13);
		economyD20.setBackground(new Color(242, 99, 157));
		economyE20 = new JButton();
		economyE20.setBounds(340, 750, 13, 13);
		economyE20.setBackground(new Color(242, 99, 157));
		economyF20 = new JButton();
		economyF20.setBounds(359, 750, 13, 13);
		economyF20.setBackground(new Color(242, 99, 157));
		economyG20 = new JButton();
		economyG20.setBounds(377, 750, 13, 13);
		economyG20.setBackground(new Color(242, 99, 157));
		economyH20 = new JButton();
		economyH20.setBounds(420, 766, 13, 13);
		economyH20.setBackground(new Color(242, 99, 157));
		economyK20 = new JButton();
		economyK20.setBounds(439, 766, 13, 13);
		economyK20.setBackground(new Color(242, 99, 157));

		economyA21 = new JButton();
		economyA21.setBounds(260, 785, 13, 13);
		economyA21.setBackground(new Color(242, 99, 157));
		economyC21 = new JButton();
		economyC21.setBounds(279, 785, 13, 13);
		economyC21.setBackground(new Color(242, 99, 157));
		economyD21 = new JButton();
		economyD21.setBounds(322, 773, 13, 13);
		economyD21.setBackground(new Color(242, 99, 157));
		economyE21 = new JButton();
		economyE21.setBounds(340, 773, 13, 13);
		economyE21.setBackground(new Color(242, 99, 157));
		economyF21 = new JButton();
		economyF21.setBounds(359, 773, 13, 13);
		economyF21.setBackground(new Color(242, 99, 157));
		economyG21 = new JButton();
		economyG21.setBounds(377, 773, 13, 13);
		economyG21.setBackground(new Color(242, 99, 157));
		economyH21 = new JButton();
		economyH21.setBounds(420, 789, 13, 13);
		economyH21.setBackground(new Color(242, 99, 157));
		economyK21 = new JButton();
		economyK21.setBounds(439, 789, 13, 13);
		economyK21.setBackground(new Color(242, 99, 157));

		economyA22 = new JButton();
		economyA22.setBounds(260, 807, 13, 13);
		economyA22.setBackground(new Color(242, 99, 157));
		economyC22 = new JButton();
		economyC22.setBounds(279, 807, 13, 13);
		economyC22.setBackground(new Color(242, 99, 157));
		economyD22 = new JButton();
		economyD22.setBounds(322, 796, 13, 13);
		economyD22.setBackground(new Color(242, 99, 157));
		economyE22 = new JButton();
		economyE22.setBounds(340, 796, 13, 13);
		economyE22.setBackground(new Color(242, 99, 157));
		economyF22 = new JButton();
		economyF22.setBounds(359, 796, 13, 13);
		economyF22.setBackground(new Color(242, 99, 157));
		economyG22 = new JButton();
		economyG22.setBounds(377, 796, 13, 13);
		economyG22.setBackground(new Color(242, 99, 157));
		economyH22 = new JButton();
		economyH22.setBounds(420, 812, 13, 13);
		economyH22.setBackground(new Color(242, 99, 157));
		economyK22 = new JButton();
		economyK22.setBounds(439, 812, 13, 13);
		economyK22.setBackground(new Color(242, 99, 157));

		economyA23 = new JButton();
		economyA23.setBounds(260, 830, 13, 13);
		economyA23.setBackground(new Color(242, 99, 157));
		economyC23 = new JButton();
		economyC23.setBounds(279, 830, 13, 13);
		economyC23.setBackground(new Color(242, 99, 157));
		economyD23 = new JButton();
		economyD23.setBounds(322, 819, 13, 13);
		economyD23.setBackground(new Color(242, 99, 157));
		economyE23 = new JButton();
		economyE23.setBounds(340, 819, 13, 13);
		economyE23.setBackground(new Color(242, 99, 157));
		economyF23 = new JButton();
		economyF23.setBounds(359, 819, 13, 13);
		economyF23.setBackground(new Color(242, 99, 157));
		economyG23 = new JButton();
		economyG23.setBounds(377, 819, 13, 13);
		economyG23.setBackground(new Color(242, 99, 157));
		economyH23 = new JButton();
		economyH23.setBounds(420, 835, 13, 13);
		economyH23.setBackground(new Color(242, 99, 157));
		economyK23 = new JButton();
		economyK23.setBounds(439, 835, 13, 13);
		economyK23.setBackground(new Color(242, 99, 157));

		economyA24 = new JButton();
		economyA24.setBounds(260, 853, 13, 13);
		economyA24.setBackground(new Color(242, 99, 157));
		economyC24 = new JButton();
		economyC24.setBounds(279, 853, 13, 13);
		economyC24.setBackground(new Color(242, 99, 157));
		economyD24 = new JButton();
		economyD24.setBounds(322, 842, 13, 13);
		economyD24.setBackground(new Color(242, 99, 157));
		economyE24 = new JButton();
		economyE24.setBounds(340, 842, 13, 13);
		economyE24.setBackground(new Color(242, 99, 157));
		economyF24 = new JButton();
		economyF24.setBounds(359, 842, 13, 13);
		economyF24.setBackground(new Color(242, 99, 157));
		economyG24 = new JButton();
		economyG24.setBounds(377, 842, 13, 13);
		economyG24.setBackground(new Color(242, 99, 157));
		economyH24 = new JButton();
		economyH24.setBounds(420, 857, 13, 13);
		economyH24.setBackground(new Color(242, 99, 157));
		economyK24 = new JButton();
		economyK24.setBounds(439, 857, 13, 13);
		economyK24.setBackground(new Color(242, 99, 157));

		economyA25 = new JButton();
		economyA25.setBounds(260, 876, 13, 13);
		economyA25.setBackground(new Color(242, 99, 157));
		economyC25 = new JButton();
		economyC25.setBounds(279, 876, 13, 13);
		economyC25.setBackground(new Color(242, 99, 157));
		economyD25 = new JButton();
		economyD25.setBounds(322, 865, 13, 13);
		economyD25.setBackground(new Color(242, 99, 157));
		economyE25 = new JButton();
		economyE25.setBounds(340, 865, 13, 13);
		economyE25.setBackground(new Color(242, 99, 157));
		economyF25 = new JButton();
		economyF25.setBounds(359, 865, 13, 13);
		economyF25.setBackground(new Color(242, 99, 157));
		economyG25 = new JButton();
		economyG25.setBounds(377, 865, 13, 13);
		economyG25.setBackground(new Color(242, 99, 157));
		economyH25 = new JButton();
		economyH25.setBounds(420, 879, 13, 13);
		economyH25.setBackground(new Color(242, 99, 157));
		economyK25 = new JButton();
		economyK25.setBounds(439, 879, 13, 13);
		economyK25.setBackground(new Color(242, 99, 157));

		economyA26 = new JButton();
		economyA26.setBounds(260, 899, 13, 13);
		economyA26.setBackground(new Color(242, 99, 157));
		economyC26 = new JButton();
		economyC26.setBounds(279, 899, 13, 13);
		economyC26.setBackground(new Color(242, 99, 157));
		economyD26 = new JButton();
		economyD26.setBounds(322, 888, 13, 13);
		economyD26.setBackground(new Color(242, 99, 157));
		economyE26 = new JButton();
		economyE26.setBounds(340, 888, 13, 13);
		economyE26.setBackground(new Color(242, 99, 157));
		economyF26 = new JButton();
		economyF26.setBounds(359, 888, 13, 13);
		economyF26.setBackground(new Color(242, 99, 157));
		economyG26 = new JButton();
		economyG26.setBounds(377, 888, 13, 13);
		economyG26.setBackground(new Color(242, 99, 157));
		economyH26 = new JButton();
		economyH26.setBounds(420, 901, 13, 13);
		economyH26.setBackground(new Color(242, 99, 157));
		economyK26 = new JButton();
		economyK26.setBounds(439, 901, 13, 13);
		economyK26.setBackground(new Color(242, 99, 157));

		economyD27 = new JButton();
		economyD27.setBounds(322, 912, 13, 13);
		economyD27.setBackground(new Color(242, 99, 157));
		economyE27 = new JButton();
		economyE27.setBounds(340, 912, 13, 13);
		economyE27.setBackground(new Color(242, 99, 157));
		economyF27 = new JButton();
		economyF27.setBounds(359, 912, 13, 13);
		economyF27.setBackground(new Color(242, 99, 157));
		economyG27 = new JButton();
		economyG27.setBounds(377, 912, 13, 13);
		economyG27.setBackground(new Color(242, 99, 157));
		economyH27 = new JButton();
		economyH27.setBounds(420, 924, 13, 13);
		economyH27.setBackground(new Color(242, 99, 157));
		economyK27 = new JButton();
		economyK27.setBounds(439, 924, 13, 13);
		economyK27.setBackground(new Color(242, 99, 157));

		ButtonGroup bg = new ButtonGroup();

		bg.add(businessA1); bg.add(businessC1); bg.add(businessD1); 
		bg.add(businessG1); bg.add(businessH1); bg.add(businessK1);
		bg.add(businessA2); bg.add(businessC2); bg.add(businessD2);
		bg.add(businessG2); bg.add(businessH2); bg.add(businessK2);
		bg.add(businessA3);	bg.add(businessC3);	bg.add(businessD3);
		bg.add(businessG3);	bg.add(businessH3); bg.add(businessK3);	
		bg.add(businessA4);	bg.add(businessC4);	bg.add(businessD4);
		bg.add(businessG4);	bg.add(businessH4);	bg.add(businessK4);
		bg.add(businessA5);	bg.add(businessC5);	bg.add(businessD5);
		bg.add(businessG5);	bg.add(businessH5);	bg.add(businessK5);

		// economy
		bg.add(economyA10);	bg.add(economyC10);	bg.add(economyD10);	bg.add(economyE10);
		bg.add(economyF10);	bg.add(economyG10);	bg.add(economyH10);	bg.add(economyK10);

		bg.add(economyA11);	bg.add(economyC11);	bg.add(economyD11); bg.add(economyE11);
		bg.add(economyF11);	bg.add(economyG11);	bg.add(economyH11);	bg.add(economyK11);

		bg.add(economyA12);	bg.add(economyC12);	bg.add(economyD12);	bg.add(economyE12);
		bg.add(economyF12);	bg.add(economyG12);	bg.add(economyH12);	bg.add(economyK12);

		bg.add(economyA14);	bg.add(economyC14);	bg.add(economyD14);	bg.add(economyE14);
		bg.add(economyF14);	bg.add(economyG14);	bg.add(economyH14);	bg.add(economyK14);

		bg.add(economyA15);	bg.add(economyC15);	bg.add(economyD15);	bg.add(economyE15);
		bg.add(economyF15);	bg.add(economyG15);	bg.add(economyH15);	bg.add(economyK15);

		bg.add(economyA16);	bg.add(economyC16);	bg.add(economyD16);	bg.add(economyE16);
		bg.add(economyF16);	bg.add(economyG16);	bg.add(economyH16);	bg.add(economyK16);

		bg.add(economyA17);	bg.add(economyC17);	bg.add(economyD17);	bg.add(economyE17);
		bg.add(economyF17);	bg.add(economyG17);	bg.add(economyH17);	bg.add(economyK17);

		bg.add(economyA18);	bg.add(economyC18);	bg.add(economyD18);	bg.add(economyE18);
		bg.add(economyF18); bg.add(economyG18);	bg.add(economyH18);	bg.add(economyK18);

		bg.add(economyA19);	bg.add(economyC19);	bg.add(economyD19);	bg.add(economyE19);
		bg.add(economyF19);	bg.add(economyG19);	bg.add(economyH19);	bg.add(economyK19);

		bg.add(economyA20);	bg.add(economyC20);	bg.add(economyD20);	bg.add(economyE20);
		bg.add(economyF20);	bg.add(economyG20);	bg.add(economyH20);	bg.add(economyK20);

		bg.add(economyA21);	bg.add(economyC21);	bg.add(economyD21);	bg.add(economyE21);
		bg.add(economyF21);	bg.add(economyG21);	bg.add(economyH21);	bg.add(economyK21);

		bg.add(economyA22);	bg.add(economyC22);	bg.add(economyD22);	bg.add(economyE22);
		bg.add(economyF22);	bg.add(economyG22);	bg.add(economyH22);	bg.add(economyK22);

		bg.add(economyA23);	bg.add(economyC23);	bg.add(economyD23);	bg.add(economyE23);
		bg.add(economyF23);	bg.add(economyG23);	bg.add(economyH23);	bg.add(economyK23);

		bg.add(economyA24);	bg.add(economyC24);	bg.add(economyD24);	bg.add(economyE24);
		bg.add(economyF24);	bg.add(economyG24);	bg.add(economyH24); bg.add(economyK24);

		bg.add(economyA25);	bg.add(economyC25);	bg.add(economyD25);	bg.add(economyE25);
		bg.add(economyF25);	bg.add(economyG25);	bg.add(economyH25);	bg.add(economyK25);

		bg.add(economyA26);	bg.add(economyC26);	bg.add(economyD26);	bg.add(economyE26);
		bg.add(economyF26);	bg.add(economyG26);	bg.add(economyH26);	bg.add(economyK26);

		bg.add(economyD27);	bg.add(economyE27);	bg.add(economyF27);
		bg.add(economyG27); bg.add(economyH27);	bg.add(economyK27);

		backgroundL.add(businessA1); backgroundL.add(businessC1); backgroundL.add(businessD1);
		backgroundL.add(businessG1); backgroundL.add(businessH1); backgroundL.add(businessK1);

		backgroundL.add(businessA2); backgroundL.add(businessC2); backgroundL.add(businessD2);
		backgroundL.add(businessG2); backgroundL.add(businessH2); backgroundL.add(businessK2);

		backgroundL.add(businessA3); backgroundL.add(businessC3); backgroundL.add(businessD3);
		backgroundL.add(businessG3); backgroundL.add(businessH3); backgroundL.add(businessK3);

		backgroundL.add(businessA4); backgroundL.add(businessC4); backgroundL.add(businessD4);
		backgroundL.add(businessG4); backgroundL.add(businessH4); backgroundL.add(businessK4);

		backgroundL.add(businessA5); backgroundL.add(businessC5); backgroundL.add(businessD5);
		backgroundL.add(businessG5); backgroundL.add(businessH5); backgroundL.add(businessK5);

		backgroundL.add(economyA10); backgroundL.add(economyC10); backgroundL.add(economyD10); backgroundL.add(economyE10); 
		backgroundL.add(economyF10); backgroundL.add(economyG10); backgroundL.add(economyH10); backgroundL.add(economyK10);

		backgroundL.add(economyA11); backgroundL.add(economyC11); backgroundL.add(economyD11); backgroundL.add(economyE11);
		backgroundL.add(economyF11); backgroundL.add(economyG11); backgroundL.add(economyH11); backgroundL.add(economyK11);

		backgroundL.add(economyA12); backgroundL.add(economyC12); backgroundL.add(economyD12); backgroundL.add(economyE12);
		backgroundL.add(economyF12); backgroundL.add(economyG12); backgroundL.add(economyH12); backgroundL.add(economyK12);

		backgroundL.add(economyA14); backgroundL.add(economyC14); backgroundL.add(economyD14); backgroundL.add(economyE14);
		backgroundL.add(economyF14); backgroundL.add(economyG14); backgroundL.add(economyH14); backgroundL.add(economyK14);

		backgroundL.add(economyA15); backgroundL.add(economyC15); backgroundL.add(economyD15); backgroundL.add(economyE15);
		backgroundL.add(economyF15); backgroundL.add(economyG15); backgroundL.add(economyH15); backgroundL.add(economyK15);

		backgroundL.add(economyA16); backgroundL.add(economyC16); backgroundL.add(economyD16); backgroundL.add(economyE16);
		backgroundL.add(economyF16); backgroundL.add(economyG16); backgroundL.add(economyH16); backgroundL.add(economyK16);

		backgroundL.add(economyA17); backgroundL.add(economyC17); backgroundL.add(economyD17); backgroundL.add(economyE17);
		backgroundL.add(economyF17); backgroundL.add(economyG17); backgroundL.add(economyH17); backgroundL.add(economyK17);

		backgroundL.add(economyA18); backgroundL.add(economyC18); backgroundL.add(economyD18); backgroundL.add(economyE18);
		backgroundL.add(economyF18); backgroundL.add(economyG18); backgroundL.add(economyH18); backgroundL.add(economyK18);

		backgroundL.add(economyA19); backgroundL.add(economyC19); backgroundL.add(economyD19); backgroundL.add(economyE19);
		backgroundL.add(economyF19); backgroundL.add(economyG19); backgroundL.add(economyH19); backgroundL.add(economyK19);

		backgroundL.add(economyA20); backgroundL.add(economyC20); backgroundL.add(economyD20); backgroundL.add(economyE20);
		backgroundL.add(economyF20); backgroundL.add(economyG20); backgroundL.add(economyH20); backgroundL.add(economyK20);

		backgroundL.add(economyA21); backgroundL.add(economyC21); backgroundL.add(economyD21); backgroundL.add(economyE21); 
		backgroundL.add(economyF21); backgroundL.add(economyG21); backgroundL.add(economyH21); backgroundL.add(economyK21);

		backgroundL.add(economyA22); backgroundL.add(economyC22); backgroundL.add(economyD22);backgroundL.add(economyE22);
		backgroundL.add(economyF22); backgroundL.add(economyG22); backgroundL.add(economyH22); backgroundL.add(economyK22);

		backgroundL.add(economyA23); backgroundL.add(economyC23); backgroundL.add(economyD23); backgroundL.add(economyE23);
		backgroundL.add(economyF23); backgroundL.add(economyG23); backgroundL.add(economyH23); backgroundL.add(economyK23);

		backgroundL.add(economyA24); backgroundL.add(economyC24); backgroundL.add(economyD24); backgroundL.add(economyE24);
		backgroundL.add(economyF24); backgroundL.add(economyG24); backgroundL.add(economyH24); backgroundL.add(economyK24);

		backgroundL.add(economyA25); backgroundL.add(economyC25); backgroundL.add(economyD25); backgroundL.add(economyE25);
		backgroundL.add(economyF25); backgroundL.add(economyG25); backgroundL.add(economyH25); backgroundL.add(economyK25);

		backgroundL.add(economyA26); backgroundL.add(economyC26); backgroundL.add(economyD26); backgroundL.add(economyE26);
		backgroundL.add(economyF26); backgroundL.add(economyG26); backgroundL.add(economyH26); backgroundL.add(economyK26);

		backgroundL.add(economyD27); backgroundL.add(economyE27); backgroundL.add(economyF27); backgroundL.add(economyG27);
		backgroundL.add(economyH27); backgroundL.add(economyK27);

		Container c = getContentPane();
		// c.add(businessA1);
		c.add(scroll);
		c.add(seatP);
		c.add(infoP);

		// c.add(scroll);
		setTitle("BitAirline_ÁÂ¼® ¼±ÅÃ");
		setSize(1000, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		// ÀÌº¥Æ®
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		choiceBtn.addActionListener(this);
		backBtn.addActionListener(this);
		choiceBtn.setFocusable(false);
		backBtn.setFocusable(false);

//=================================================== ÁÂ¼®ÀÌº¥Æ® =======================================================
		businessA1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessA1) {
					seatL.setText("A1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(false); businessC1.setVisible(true); businessD1.setVisible(true);
					businessG1.setVisible(true); businessH1.setVisible(true); businessK1.setVisible(true);
					businessA2.setVisible(true); businessC2.setVisible(true); businessD2.setVisible(true);
					businessG2.setVisible(true); businessH2.setVisible(true); businessK2.setVisible(true);
					businessA3.setVisible(true); businessC3.setVisible(true); businessD3.setVisible(true);
					businessG3.setVisible(true); businessH3.setVisible(true); businessK3.setVisible(true);
					businessA4.setVisible(true); businessC4.setVisible(true); businessD4.setVisible(true);
					businessG4.setVisible(true); businessH4.setVisible(true); businessK4.setVisible(true);
					businessA5.setVisible(true); businessC5.setVisible(true); businessD5.setVisible(true);
					businessG5.setVisible(true); businessH5.setVisible(true); businessK5.setVisible(true);

					economyA10.setVisible(true); economyC10.setVisible(true); economyD10.setVisible(true);
					economyE10.setVisible(true); economyF10.setVisible(true); economyG10.setVisible(true);
					economyH10.setVisible(true); economyK10.setVisible(true); economyA11.setVisible(true);
					economyC11.setVisible(true); economyD11.setVisible(true); economyE11.setVisible(true);
					economyF11.setVisible(true); economyG11.setVisible(true); economyH11.setVisible(true);
					economyK11.setVisible(true); economyA12.setVisible(true); economyC12.setVisible(true);
					economyD12.setVisible(true); economyE12.setVisible(true); economyF12.setVisible(true);
					economyG12.setVisible(true); economyH12.setVisible(true); economyK12.setVisible(true);
					economyA14.setVisible(true); economyC14.setVisible(true); economyD14.setVisible(true);
					economyE14.setVisible(true); economyF14.setVisible(true); economyG14.setVisible(true);
					economyH14.setVisible(true); economyK14.setVisible(true); economyA15.setVisible(true);
					economyC15.setVisible(true); economyD15.setVisible(true); economyE15.setVisible(true);
					economyF15.setVisible(true); economyG15.setVisible(true); economyH15.setVisible(true);
					economyK15.setVisible(true); economyA16.setVisible(true); economyC16.setVisible(true);
					economyD16.setVisible(true); economyE16.setVisible(true); economyF16.setVisible(true);
					economyG16.setVisible(true); economyH16.setVisible(true); economyK16.setVisible(true);
					economyA17.setVisible(true); economyC17.setVisible(true); economyD17.setVisible(true);
					economyE17.setVisible(true); economyF17.setVisible(true); economyG17.setVisible(true);
					economyH17.setVisible(true); economyK17.setVisible(true); economyA18.setVisible(true);
					economyC18.setVisible(true); economyD18.setVisible(true); economyE18.setVisible(true);
					economyF18.setVisible(true); economyG18.setVisible(true); economyH18.setVisible(true);
					economyK18.setVisible(true); economyA19.setVisible(true); economyC19.setVisible(true);
					economyD19.setVisible(true); economyE19.setVisible(true); economyF19.setVisible(true);
					economyG19.setVisible(true); economyH19.setVisible(true); economyK19.setVisible(true);
					economyA20.setVisible(true); economyC20.setVisible(true); economyD20.setVisible(true);
					economyE20.setVisible(true); economyF20.setVisible(true); economyG20.setVisible(true);
					economyH20.setVisible(true); economyK20.setVisible(true); economyA21.setVisible(true);
					economyC21.setVisible(true); economyD21.setVisible(true); economyE21.setVisible(true);
					economyF21.setVisible(true); economyG21.setVisible(true); economyH21.setVisible(true);
					economyK21.setVisible(true); economyA22.setVisible(true); economyC22.setVisible(true);
					economyD22.setVisible(true); economyE22.setVisible(true); economyF22.setVisible(true);
					economyG22.setVisible(true); economyH22.setVisible(true); economyK22.setVisible(true);
					economyA23.setVisible(true); economyC23.setVisible(true); economyD23.setVisible(true);
					economyE23.setVisible(true); economyF23.setVisible(true); economyG23.setVisible(true);
					economyH23.setVisible(true); economyK23.setVisible(true); economyA24.setVisible(true);
					economyC24.setVisible(true); economyD24.setVisible(true); economyE24.setVisible(true);
					economyF24.setVisible(true); economyG24.setVisible(true); economyH24.setVisible(true);
					economyK24.setVisible(true); economyA25.setVisible(true); economyC25.setVisible(true);
					economyD25.setVisible(true); economyE25.setVisible(true); economyF25.setVisible(true);
					economyG25.setVisible(true); economyH25.setVisible(true); economyK25.setVisible(true);
					economyA26.setVisible(true); economyC26.setVisible(true); economyD26.setVisible(true);
					economyE26.setVisible(true); economyF26.setVisible(true); economyG26.setVisible(true);
					economyH26.setVisible(true); economyK26.setVisible(true); economyD27.setVisible(true);
					economyE27.setVisible(true); economyF27.setVisible(true); economyG27.setVisible(true);
					economyH27.setVisible(true); economyK27.setVisible(true);
				}
			}
		});

		businessA2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessA2) {
					seatL.setText("A2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true); businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true); businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(false); businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true); businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true); businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true); businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true); businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true); businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true); businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true); businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true); economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true); economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true); economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true); economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true); economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true); economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true); economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true); economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true); economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true); economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true); economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true); economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true); economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true); economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true); economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true); economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true); economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true); economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true); economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true); economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true); economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true); economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true); economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true); economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true); economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true); economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true); economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true); economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true); economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true); economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true); economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true); economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true); economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true); economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true); economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true); economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true); economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true); economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true); economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true); economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true); economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true); economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true); economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true); economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true); economyK27.setVisible(true);
				}
			}
		});
		businessA3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessA3) {
					seatL.setText("A3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(false);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessA4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessA4) {
					seatL.setText("A4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(false);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessA5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessA5) {
					seatL.setText("A5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(false);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

		businessC1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessC1) {
					seatL.setText("C1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(false);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

		businessC2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessC2) {
					seatL.setText("C2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(false);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessC3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessC3) {
					seatL.setText("C3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(false);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessC4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessC4) {
					seatL.setText("C4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(false);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessC5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessC5) {
					seatL.setText("C5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(false);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

		businessD1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessD1) {
					seatL.setText("D1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(false);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

		businessD2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessD2) {
					seatL.setText("D2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(false);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessD3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessD3) {
					seatL.setText("D3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(false);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessD4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessD4) {
					seatL.setText("D4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(false);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessD5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessD5) {
					seatL.setText("D5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(false);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

		businessG1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessG1) {
					seatL.setText("G1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(false);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessG2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessG2) {
					seatL.setText("G2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(false);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessG3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessG3) {
					seatL.setText("G3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(false);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessG4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessG4) {
					seatL.setText("G4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(false);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessG5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessG5) {
					seatL.setText("G5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(false);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessH1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessH1) {
					seatL.setText("H1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(false);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessH2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessH2) {
					seatL.setText("H2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(false);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessH3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessH3) {
					seatL.setText("H3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(false);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessH4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessH4) {
					seatL.setText("H4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(false);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessH5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessH5) {
					seatL.setText("H5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(false);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessK1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessK1) {
					seatL.setText("K1ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(false);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessK2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessK2) {
					seatL.setText("K2ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(false);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessK3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessK3) {
					seatL.setText("K3ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(false);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessK4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessK4) {
					seatL.setText("K4ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(false);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		businessK5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == businessK5) {
					seatL.setText("K5ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(false);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

//------------------economy----------------
		economyA10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA10) {
					seatL.setText("A10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(false);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA11) {
					seatL.setText("A11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(false);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA12) {
					seatL.setText("A12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(false);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA14) {
					seatL.setText("A14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(false);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA15) {
					seatL.setText("A15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(false);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA16) {
					seatL.setText("A16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(false);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA17) {
					seatL.setText("A17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(false);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA18) {
					seatL.setText("A18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(false);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA19) {
					seatL.setText("A19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(false);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA20) {
					seatL.setText("A20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(false);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA21) {
					seatL.setText("A21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(false);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA22) {
					seatL.setText("A22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(false);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA23) {
					seatL.setText("A23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(false);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA24) {
					seatL.setText("A24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(false);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA25) {
					seatL.setText("A25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(false);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyA26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyA26) {
					seatL.setText("A26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(false);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

// ---- C ------
		economyC10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC10) {
					seatL.setText("C10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(false);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC11) {
					seatL.setText("C11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(false);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC12) {
					seatL.setText("C12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(false);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC14) {
					seatL.setText("C14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(false);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC15) {
					seatL.setText("C15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(false);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC16) {
					seatL.setText("C16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(false);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC17) {
					seatL.setText("C17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(false);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC18) {
					seatL.setText("C18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(false);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC19) {
					seatL.setText("C19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(false);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC20) {
					seatL.setText("C20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(false);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC21) {
					seatL.setText("C21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(false);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC22) {
					seatL.setText("C22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(false);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC23) {
					seatL.setText("C23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(false);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC24) {
					seatL.setText("C24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(false);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC25) {
					seatL.setText("C25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(false);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyC26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyC26) {
					seatL.setText("C26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(false);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

//---- D -----
		economyD10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD10) {
					seatL.setText("D10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(false);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD11) {
					seatL.setText("D11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(false);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD12) {
					seatL.setText("D12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(false);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD14) {
					seatL.setText("D14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(false);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD15) {
					seatL.setText("D15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(false);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD16) {
					seatL.setText("D16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(false);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD17) {
					seatL.setText("D17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(false);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD18) {
					seatL.setText("D18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(false);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD19) {
					seatL.setText("D19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(false);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD20) {
					seatL.setText("D20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(false);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD21) {
					seatL.setText("D21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(false);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD22) {
					seatL.setText("D22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(false);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD23) {
					seatL.setText("D23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(false);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD24) {
					seatL.setText("D24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(false);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD25) {
					seatL.setText("D25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(false);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD26) {
					seatL.setText("D26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(false);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyD27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyD27) {
					seatL.setText("D27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(false);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

//------ E -----
		economyE10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE10) {
					seatL.setText("E10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(false);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE11) {
					seatL.setText("E11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(false);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE12) {
					seatL.setText("E12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(false);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE14) {
					seatL.setText("E14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(false);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE15) {
					seatL.setText("E15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(false);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE16) {
					seatL.setText("E16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(false);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE17) {
					seatL.setText("E17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(false);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE18) {
					seatL.setText("E18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(false);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE19) {
					seatL.setText("E19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(false);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE20) {
					seatL.setText("E20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(false);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE21) {
					seatL.setText("E21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(false);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE22) {
					seatL.setText("E22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(false);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE23) {
					seatL.setText("E23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(false);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE24) {
					seatL.setText("E24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(false);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE25) {
					seatL.setText("E25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(false);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE26) {
					seatL.setText("E26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(false);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyE27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyE27) {
					seatL.setText("E27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(false);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

// ------- F -------
		economyF10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF10) {
					seatL.setText("F10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(false);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF11) {
					seatL.setText("F11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(false);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF12) {
					seatL.setText("F12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(false);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF14) {
					seatL.setText("F14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(false);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF15) {
					seatL.setText("F15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(false);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF16) {
					seatL.setText("F16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(false);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF17) {
					seatL.setText("F17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(false);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF18) {
					seatL.setText("F18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(false);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF19) {
					seatL.setText("F19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(false);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF20) {
					seatL.setText("F20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(false);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF21) {
					seatL.setText("F21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(false);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF22) {
					seatL.setText("F22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(false);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF23) {
					seatL.setText("F23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(false);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF24) {
					seatL.setText("F24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(false);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF25) {
					seatL.setText("F25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(false);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF26) {
					seatL.setText("F26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(false);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyF27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyF27) {
					seatL.setText("F27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(false);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

// ------- G -------
		economyG10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG10) {
					seatL.setText("G10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(false);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG11) {
					seatL.setText("G11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(false);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG12) {
					seatL.setText("G12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(false);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG14) {
					seatL.setText("G14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(false);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG15) {
					seatL.setText("G15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(false);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG16) {
					seatL.setText("G16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(false);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG17) {
					seatL.setText("G17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(false);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG18) {
					seatL.setText("G18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(false);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG19) {
					seatL.setText("G19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(false);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG20) {
					seatL.setText("G20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(false);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG21) {
					seatL.setText("G21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(false);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG22) {
					seatL.setText("G22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(false);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG23) {
					seatL.setText("G23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(false);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG24) {
					seatL.setText("G24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(false);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG25) {
					seatL.setText("G25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(false);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG26) {
					seatL.setText("G26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(false);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyG27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyG27) {
					seatL.setText("G27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(false);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});

// ---------- H ------
		economyH10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH10) {
					seatL.setText("H10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(false);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH11) {
					seatL.setText("H11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(false);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH12) {
					seatL.setText("H12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(false);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH14) {
					seatL.setText("H14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(false);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH15) {
					seatL.setText("H15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(false);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH16) {
					seatL.setText("H16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(false);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH17) {
					seatL.setText("H17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(false);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH18) {
					seatL.setText("H18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(false);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH19) {
					seatL.setText("H19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(false);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH20) {
					seatL.setText("H20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(false);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH21) {
					seatL.setText("H21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(false);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH22) {
					seatL.setText("H22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(false);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH23) {
					seatL.setText("H23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(false);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH24) {
					seatL.setText("H24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(false);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH25) {
					seatL.setText("H25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(false);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH26) {
					seatL.setText("H26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(false);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyH27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyH27) {
					seatL.setText("H27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(false);		economyK27.setVisible(true);
				}
			}
		});

// ------ K ----------
		economyK10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK10) {
					seatL.setText("K10ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(false);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK11) {
					seatL.setText("K11ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(false);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK12) {
					seatL.setText("K12ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(false);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK14) {
					seatL.setText("K14ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(false);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK15) {
					seatL.setText("K15ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(false);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK16) {
					seatL.setText("K16ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(false);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK17) {
					seatL.setText("K17ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(false);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK18) {
					seatL.setText("K18ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(false);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK19) {
					seatL.setText("K19ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(false);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK20.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK20) {
					seatL.setText("K20ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(false);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK21.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK21) {
					seatL.setText("K21ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(false);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK22.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK22) {
					seatL.setText("K22ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(false);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK23.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK23) {
					seatL.setText("K23ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(false);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK24.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK24) {
					seatL.setText("K24ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(false);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK25.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK25) {
					seatL.setText("K25ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(false);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK26.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK26) {
					seatL.setText("K26ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(false);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(true);
				}
			}
		});
		economyK27.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == economyK27) {
					seatL.setText("K27ÁÂ¼®");
					seatL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));

					businessA1.setVisible(true);		businessC1.setVisible(true);	businessD1.setVisible(true);
					businessG1.setVisible(true);		businessH1.setVisible(true);	businessK1.setVisible(true);
					businessA2.setVisible(true);		businessC2.setVisible(true);	businessD2.setVisible(true);
					businessG2.setVisible(true);		businessH2.setVisible(true);	businessK2.setVisible(true);
					businessA3.setVisible(true);		businessC3.setVisible(true);	businessD3.setVisible(true);
					businessG3.setVisible(true);		businessH3.setVisible(true);	businessK3.setVisible(true);
					businessA4.setVisible(true);		businessC4.setVisible(true);	businessD4.setVisible(true);
					businessG4.setVisible(true);		businessH4.setVisible(true);	businessK4.setVisible(true);
					businessA5.setVisible(true);		businessC5.setVisible(true);	businessD5.setVisible(true);
					businessG5.setVisible(true);		businessH5.setVisible(true);	businessK5.setVisible(true);
					
					economyA10.setVisible(true);		economyC10.setVisible(true);	economyD10.setVisible(true);
					economyE10.setVisible(true);		economyF10.setVisible(true);	economyG10.setVisible(true);
					economyH10.setVisible(true);		economyK10.setVisible(true);	economyA11.setVisible(true);		
					economyC11.setVisible(true);		economyD11.setVisible(true);	economyE11.setVisible(true);		
					economyF11.setVisible(true);		economyG11.setVisible(true);	economyH11.setVisible(true);		
					economyK11.setVisible(true);		economyA12.setVisible(true);	economyC12.setVisible(true);	
					economyD12.setVisible(true);		economyE12.setVisible(true);	economyF12.setVisible(true);	
					economyG12.setVisible(true);		economyH12.setVisible(true);	economyK12.setVisible(true);
					economyA14.setVisible(true);		economyC14.setVisible(true);	economyD14.setVisible(true);
					economyE14.setVisible(true);		economyF14.setVisible(true);	economyG14.setVisible(true);
					economyH14.setVisible(true);		economyK14.setVisible(true);	economyA15.setVisible(true);		
					economyC15.setVisible(true);		economyD15.setVisible(true);	economyE15.setVisible(true);		
					economyF15.setVisible(true);		economyG15.setVisible(true);	economyH15.setVisible(true);		
					economyK15.setVisible(true);		economyA16.setVisible(true);	economyC16.setVisible(true);	
					economyD16.setVisible(true);		economyE16.setVisible(true);	economyF16.setVisible(true);	
					economyG16.setVisible(true);		economyH16.setVisible(true);	economyK16.setVisible(true);					
					economyA17.setVisible(true);		economyC17.setVisible(true);	economyD17.setVisible(true);
					economyE17.setVisible(true);		economyF17.setVisible(true);	economyG17.setVisible(true);
					economyH17.setVisible(true);		economyK17.setVisible(true);	economyA18.setVisible(true);		
					economyC18.setVisible(true);		economyD18.setVisible(true);	economyE18.setVisible(true);		
					economyF18.setVisible(true);		economyG18.setVisible(true);	economyH18.setVisible(true);		
					economyK18.setVisible(true);		economyA19.setVisible(true);	economyC19.setVisible(true);	
					economyD19.setVisible(true);		economyE19.setVisible(true);	economyF19.setVisible(true);	
					economyG19.setVisible(true);		economyH19.setVisible(true);	economyK19.setVisible(true);					
					economyA20.setVisible(true);		economyC20.setVisible(true);	economyD20.setVisible(true);
					economyE20.setVisible(true);		economyF20.setVisible(true);	economyG20.setVisible(true);
					economyH20.setVisible(true);		economyK20.setVisible(true);	economyA21.setVisible(true);		
					economyC21.setVisible(true);		economyD21.setVisible(true);	economyE21.setVisible(true);		
					economyF21.setVisible(true);		economyG21.setVisible(true);	economyH21.setVisible(true);		
					economyK21.setVisible(true);		economyA22.setVisible(true);	economyC22.setVisible(true);	
					economyD22.setVisible(true);		economyE22.setVisible(true);	economyF22.setVisible(true);	
					economyG22.setVisible(true);		economyH22.setVisible(true);	economyK22.setVisible(true);					
					economyA23.setVisible(true);		economyC23.setVisible(true);	economyD23.setVisible(true);
					economyE23.setVisible(true);		economyF23.setVisible(true);	economyG23.setVisible(true);
					economyH23.setVisible(true);		economyK23.setVisible(true);	economyA24.setVisible(true);		
					economyC24.setVisible(true);		economyD24.setVisible(true);	economyE24.setVisible(true);		
					economyF24.setVisible(true);		economyG24.setVisible(true);	economyH24.setVisible(true);		
					economyK24.setVisible(true);		economyA25.setVisible(true);	economyC25.setVisible(true);	
					economyD25.setVisible(true);		economyE25.setVisible(true);	economyF25.setVisible(true);	
					economyG25.setVisible(true);		economyH25.setVisible(true);	economyK25.setVisible(true);					
					economyA26.setVisible(true);		economyC26.setVisible(true);	economyD26.setVisible(true);
					economyE26.setVisible(true);		economyF26.setVisible(true);	economyG26.setVisible(true);
					economyH26.setVisible(true);		economyK26.setVisible(true);	economyD27.setVisible(true);		
					economyE27.setVisible(true);		economyF27.setVisible(true);	economyG27.setVisible(true);		
					economyH27.setVisible(true);		economyK27.setVisible(false);
				}
			}
		});
	}// FlightSeat2()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choiceBtn) {
			int choice = JOptionPane.showConfirmDialog(this, "¼±ÅÃµÈ ÁÂ¼®À¸·Î ¿¹¸ÅÇÏ½Ã°Ú½À´Ï±î?", "BOOKING_MESSAGE",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				if (choice == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(this, "ÁÂ¼®¼±ÅÃÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
					mbp.getSeatL().setText(seatL.getText());
					dispose();
				}
			} else if (choice == JOptionPane.NO_OPTION) {
				dispose();
			}
		}
		if (e.getSource() == backBtn) {
			JOptionPane.showConfirmDialog(this, "       µÚ·Î°¡½Ã°Ú½À´Ï±î?", "BOOKING_MESSAGE", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
}