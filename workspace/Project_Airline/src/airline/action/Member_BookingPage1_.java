package airline.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import airline.bean.BookDTO;
import airline.bean.MemberDTO;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;

public class Member_BookingPage1_ extends JFrame implements ActionListener {
	private MemberDTO memberDTO;
	private PlaneDTO planeDTO;
	private BookDTO bookDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private List<Member_BookingPage1_PsngrInfo> list = new ArrayList<Member_BookingPage1_PsngrInfo>();
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	private List<PlaneDTO> list3 = new ArrayList<PlaneDTO>();
	private JScrollPane all;
	private JPanel allP, selectP, personCheckP, bookPersonP, passengerIfP; // -> 메인패널
	private JPanel bookP, airLP, timeP; // ->메인패널에 들어가는 세부적인 패널
	private JLabel selectL, personL, bookPersonL, passengerInfoL; // 목차 라벨
	// 세부적인 라벨
	private JLabel dateL, dateL2, departure1, departure2, departure3, arrival1, arrival2, arrival3, airL, airLN, airLC;
	private JLabel timeL, timeL1, fTimeL, fTimeL2, wTimeL, wTimeL2, bookPersonN, bookPersonPh, bookPersonPhL,
			bookPersonE;
	private JLabel person; // 인원수를 -+하면 숫자가 올라가는 라벨
	private JTextField bookPersonT, bookPersonPhT, bookPersonET; // 예약자 정보 입력 텍스트필드
	private JButton bookBtn, cancelBtn, minusBtn, plusBtn;
	private int x = 0, y = 495, width = 677, height = 78;
	private int p = 81;
	private int people;
	private String loginId, planecode;
	private Member_BookingPage1_PsngrInfo pbP;
	private static int inx=0;

	public Member_BookingPage1_(String loginId, String planecode) {
		this.loginId = loginId;
		this.planecode = planecode;
		setLayout(null);
		getContentPane().setBackground(new Color(3, 136, 166));

		allP = new JPanel();
		allP.setLayout(null);
		allP.setAutoscrolls(true);
		allP.setBackground(new Color(238, 238, 238));
		allP.setPreferredSize(new Dimension(695, 495));
		all = new JScrollPane(allP);
		all.setBounds(0, 0, 695, 425);
		all.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		all.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 선택한 여행정보가 있는 패널
		selectP = new JPanel();
		selectP.setLayout(null);
		selectP.setBackground(new Color(3, 136, 166));
		selectP.setBounds(0, 0, 677, 225);

		selectL = new JLabel("선택하신 여행정보");
		selectL.setHorizontalAlignment(JLabel.CENTER);
		selectL.setOpaque(true);
		selectL.setForeground(Color.WHITE);
		selectL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		selectL.setBackground(new Color(3, 136, 166));
		selectL.setBounds(1, 2, 143, 25);

		// 선택한 여정(출발 날짜, 시간)
		dateL = new JLabel();
		dateL.setOpaque(true);
		dateL.setBackground(Color.WHITE);
		dateL.setHorizontalAlignment(JLabel.CENTER);
		dateL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dateL.setBounds(10, 35, 325, 25);

		dateL2 = new JLabel();
		dateL2.setOpaque(true);
		dateL2.setBackground(Color.WHITE);
		dateL2.setHorizontalAlignment(JLabel.CENTER);
		dateL2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dateL2.setBounds(342, 35, 325, 25);

		// 선택한 여정(ex. 인천 -> 런던)
		bookP = new JPanel();
		bookP.setLayout(null);
		bookP.setBackground(Color.WHITE);
		bookP.setBounds(10, 65, 657, 90);

		departure1 = new JLabel("출발");
		departure1.setHorizontalAlignment(JLabel.CENTER);
		departure1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		departure1.setBounds(146, 0, 30, 35);

		departure2 = new JLabel(); // ex 인천
		departure2.setHorizontalAlignment(JLabel.CENTER);

		departure2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		departure2.setBounds(72, 25, 180, 30);

		departure3 = new JLabel(); // ex. (ICN)
		departure3.setHorizontalAlignment(JLabel.CENTER);
		departure3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		departure3.setBounds(131, 50, 60, 25);

		arrival1 = new JLabel("도착");
		arrival1.setHorizontalAlignment(JLabel.CENTER);
		arrival1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		arrival1.setBounds(476, 0, 30, 35);

		arrival2 = new JLabel(); // ex 런던
		arrival2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		arrival2.setHorizontalAlignment(JLabel.CENTER);
		arrival2.setBounds(403, 25, 180, 30);

		arrival3 = new JLabel(); // ex (LON)
		arrival3.setHorizontalAlignment(JLabel.CENTER);
		arrival3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		arrival3.setBounds(463, 50, 60, 25);

		bookP.add(departure1);
		bookP.add(departure2);
		bookP.add(departure3);
		bookP.add(arrival1);
		bookP.add(arrival2);
		bookP.add(arrival3);

		// 선택한 여정(항공사, 총 소요시간)
		airLP = new JPanel();
		airLP.setLayout(null);
		airLP.setBackground(Color.WHITE);
		airLP.setBounds(10, 160, 325, 60);

		airL = new JLabel("항공사");
		airL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		airL.setBounds(5, 1, 60, 25);

		airLN = new JLabel("비트항공"); // 항공사 이름
		airLN.setHorizontalAlignment(JLabel.CENTER);
		airLN.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		airLN.setBounds(124, 12, 70, 30);

		airLC = new JLabel(); // 항공 코드
		airLC.setHorizontalAlignment(JLabel.CENTER);
		airLC.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		airLC.setBounds(123, 33, 70, 30);

		airLP.add(airL);
		airLP.add(airLN);
		airLP.add(airLC);

		timeP = new JPanel();
		timeP.setLayout(null);
		timeP.setBackground(Color.WHITE);
		timeP.setBounds(342, 160, 325, 60);
		timeL = new JLabel("총 소요시간");
		timeL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		timeL.setBounds(5, 1, 80, 25);

		timeL1 = new JLabel("");
		timeL1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		timeL1.setBounds(120, 12, 100, 30);

		fTimeL = new JLabel("비행시간 :");
		fTimeL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		fTimeL.setBounds(13, 40, 60, 20);

		fTimeL2 = new JLabel("");
		fTimeL2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		fTimeL2.setHorizontalAlignment(JLabel.CENTER);
		fTimeL2.setBounds(70, 39, 90, 20);

		wTimeL = new JLabel("대기시간 :");
		wTimeL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		wTimeL.setBounds(185, 40, 60, 20);

		wTimeL2 = new JLabel("0시간 0분");
		wTimeL2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		wTimeL2.setHorizontalAlignment(JLabel.CENTER);
		wTimeL2.setBounds(235, 39, 90, 20);

		timeP.add(timeL);
		timeP.add(timeL1);
		timeP.add(fTimeL);
		timeP.add(fTimeL2);
		timeP.add(wTimeL);
		timeP.add(wTimeL2);

		selectP.add(selectL);
		selectP.add(dateL);
		selectP.add(dateL2);
		selectP.add(bookP);
		selectP.add(airLP);
		selectP.add(timeP);

		// 인원수 선택하는 패널
		personCheckP = new JPanel();
		personCheckP.setLayout(null);
		personCheckP.setBackground(new Color(3, 136, 166));
		personCheckP.setBounds(0, 230, 677, 90);
		personL = new JLabel("인원 수");
		personL.setForeground(Color.WHITE);
		personL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		personL.setBounds(5, 2, 60, 25);

		minusBtn = new JButton("-");
		minusBtn.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		minusBtn.setBounds(10, 40, 40, 30);
		person = new JLabel();
		person.setText("0");
		person.setHorizontalAlignment(JLabel.CENTER);
		person.setBounds(65, 40, 50, 30);
		person.setOpaque(true);
		person.setBackground(Color.WHITE);
		plusBtn = new JButton("+");
		plusBtn.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		plusBtn.setBounds(130, 40, 41, 30);

		personCheckP.add(personL);
		personCheckP.add(minusBtn);
		personCheckP.add(person);
		personCheckP.add(plusBtn);

		// 예약자정보가 들어가는 패널
		bookPersonP = new JPanel();
		bookPersonP.setBackground(new Color(3, 136, 166));
		bookPersonP.setLayout(null);
		bookPersonP.setBounds(0, 325, 677, 125);
		bookPersonL = new JLabel("예약자 정보");
		bookPersonL.setForeground(Color.WHITE);
		bookPersonL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bookPersonL.setBounds(5, 2, 100, 25);

		bookPersonN = new JLabel("예약자명");
		bookPersonN.setForeground(Color.WHITE);
		bookPersonN.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bookPersonN.setBounds(10, 40, 60, 25);
		bookPersonT = new JTextField();
		bookPersonT.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		bookPersonT.setBounds(70, 37, 120, 30);

		bookPersonPh = new JLabel("연락처");
		bookPersonPh.setForeground(Color.WHITE);
		bookPersonPh.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bookPersonPh.setBounds(325, 40, 50, 25);

		bookPersonPhT = new JTextField();
		bookPersonPhT.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		bookPersonPhT.setBounds(375, 37, 210, 30);

		bookPersonPhL = new JLabel("- 빼고 입력");
		bookPersonPhL.setForeground(Color.WHITE);
		bookPersonPhL.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		bookPersonPhL.setBounds(595, 36, 100, 30);

		bookPersonE = new JLabel("이메일");
		bookPersonE.setForeground(Color.WHITE);
		bookPersonE.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bookPersonE.setBounds(10, 85, 50, 25);

		bookPersonET = new JTextField();
		bookPersonET.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		bookPersonET.setBounds(70, 82, 240, 30);

		bookPersonP.add(bookPersonL);
		bookPersonP.add(bookPersonT);
		bookPersonP.add(bookPersonPh);
		bookPersonP.add(bookPersonPhT);
		bookPersonP.add(bookPersonPhL);
		bookPersonP.add(bookPersonE);
		bookPersonP.add(bookPersonET);
		bookPersonP.add(bookPersonN);

		// 탑승객 정보 목차 패널
		passengerIfP = new JPanel();
		passengerIfP.setLayout(null);
		passengerIfP.setBackground(new Color(3, 136, 166));
		passengerIfP.setBounds(0, 455, 677, 35);
		passengerInfoL = new JLabel("탑승객 정보");
		passengerInfoL.setForeground(Color.WHITE);
		passengerInfoL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		passengerInfoL.setBounds(5, 2, 100, 25);

		passengerIfP.add(passengerInfoL);

		// 예약하기, 취소 버튼
		bookBtn = new JButton("예약");
		bookBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bookBtn.setBounds(245, 430, 100, 35);
		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cancelBtn.setBounds(352, 430, 100, 35);

		// JScollPane에 올리기
		allP.add(selectP);
		allP.add(personCheckP);
		allP.add(bookPersonP);
		allP.add(passengerIfP);

		Container c = getContentPane();
		c.add(all);
		c.add(bookBtn);
		c.add(cancelBtn);
		
		output(loginId);
		output2(planecode);

		setTitle("BitAirline_예약");
		setSize(700, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		minusBtn.addActionListener(this);
		plusBtn.addActionListener(this);
		bookBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		minusBtn.setFocusable(false);
		plusBtn.setFocusable(false);
		bookBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == plusBtn) { // 인원수 + 버튼
			people++;
			if (people > 5) {
				JOptionPane.showMessageDialog(this, "더 이상 인원수를 추가할 수 없습니다.");
				people = 5;
				return;
			}
			person.setText(people + "");
			pbP = new Member_BookingPage1_PsngrInfo(loginId, people, airLC.getText());
			list.add(pbP);
			allP.setPreferredSize(new Dimension(695, y + p));

			pbP.setBounds(x, y, width, height);
			y += p;
			allP.add(pbP);
			all.getVerticalScrollBar().setValue(all.getVerticalScrollBar().getMinimum());

		} else if (e.getSource() == minusBtn) { // 인원수 - 버튼
			people--;
			if (people < 0) {
				JOptionPane.showMessageDialog(this, "더 이상 인원수를 감소할 수 없습니다.");
				people = 0;
				return;
			}
			person.setText(people + "");
			y -= p;
			allP.setPreferredSize(new Dimension(695, y));
			list.remove(list.size() - 1);

		} else if (e.getSource() == bookBtn) { // 예약하기 버튼
			if(people == 0) {
				JOptionPane.showMessageDialog(this, "최소 인원은 1명 입니다.");
				return;
			}
			for (; inx < list.size();) {
				int sw = list.get(inx).input(loginId, planecode);
				if(sw==0) 
					return;
				else inx++;
			}
			//new Member_BookingPage2_(person.getText(), loginId, planecode, list);
			dispose();
		} else if (e.getSource() == cancelBtn) { // 취소 버튼
			dispose();
		}
	}

	public int output(String loginId) {
		this.loginId = loginId;
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list2 = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list2) {
			if (memberDTO.getId().equals(loginId)) {
				bookPersonT.setText(memberDTO.getName());
				bookPersonPhT.setText(memberDTO.getPhone());
				bookPersonET.setText(memberDTO.getMail());
			}
			sw = 1;
		}
		return sw;
	}

	public int output2(String planecode) {
		this.planecode = planecode;
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list3 = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list3) {
			if (planeDTO.getPlaneCode().equals(planecode)) {
				dateL.setText(planeDTO.getDate());
				dateL2.setText(planeDTO.getTime1() + " ~ " + planeDTO.getTime2());
				departure2.setText(planeDTO.getDeparture());
				departure3.setText(planeDTO.getDepartureEng());
				arrival2.setText(planeDTO.getArrival());
				arrival3.setText(planeDTO.getArrivalEng());
				airLC.setText(planeDTO.getPlaneCode());
				timeL1.setText("");
				fTimeL2.setText("");
				wTimeL2.setText("");
			}
			sw = 1;
		}
		return sw;
	}
	
	public int getPeople() {
		return people;
	}
}