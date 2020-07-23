package airline.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class Member_Book_Detail_ extends JFrame implements ActionListener {
	private JPanel allP, allPayP, bookInfoP; // -> 메인패널
	private JPanel bookP, airLP, personP, daDateP, bookDetailP; // ->메인패널에 들어가는 세부적인 패널
	private JLabel bookInfoL, bookDateL, bookDetailL; // -> 목차 라벨
	// 세부적인 라벨
	private JLabel bookDate, departure1, departure2, departure3, arrival1, arrival2, arrival3, airL, airLN, airLC, bkpL,
			nameL, idL;
	private JLabel departureL, departureD, arrivalL, arrivalD, allPay, allPerson, allPersonN, allPersons, moneyL, money;
	private JButton backBtn, bookCancelBtn;
	private int x = 0, y = 230, width = 615, height = 75;
	private int p = 78;

	public Member_Book_Detail_() {
		setLayout(null);
		getContentPane().setBackground(new Color(3, 136, 166));

		allP = new JPanel();
		allP.setLayout(null);
		allP.setAutoscrolls(true);
		allP.setBackground(new Color(238, 238, 238));
		allP.setPreferredSize(new Dimension(625, y));

		JScrollPane all = new JScrollPane(allP);
		all.setBounds(0, 0, 625, 325);
		all.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		all.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 예약한 예정
		bookInfoP = new JPanel();
		bookInfoP.setLayout(null);
		bookInfoP.setBackground(new Color(3, 136, 166));
		bookInfoP.setBounds(0, 0, 615, 185);
		bookInfoL = new JLabel("예약하신 여정");
		bookInfoL.setForeground(Color.WHITE);
		bookInfoL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bookInfoL.setBounds(5, 2, 150, 25);

		bookDateL = new JLabel("출발날짜 :");
		bookDateL.setForeground(Color.WHITE);
		bookDateL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bookDateL.setBounds(400, 25, 90, 25);
		bookDate = new JLabel("2020년 05월 15일");
		bookDate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bookDate.setForeground(Color.WHITE);
		bookDate.setBounds(470, 27, 130, 20);

		// 출발, 도착
		bookP = new JPanel();
		bookP.setLayout(null);
		bookP.setBackground(Color.WHITE);
		bookP.setBounds(14, 55, 210, 90);
		departure1 = new JLabel("출발");
		departure1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		departure1.setBounds(38, 0, 50, 35);
		departure2 = new JLabel("인천");
		departure2.setHorizontalAlignment(JLabel.CENTER);
		departure2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		departure2.setBounds(2, 25, 97, 30);
		departure3 = new JLabel("(LON)");
		departure3.setHorizontalAlignment(JLabel.CENTER);
		departure3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		departure3.setBounds(14, 50, 70, 25);

		arrival1 = new JLabel("도착");
		arrival1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		arrival1.setBounds(142, 0, 50, 35);
		arrival2 = new JLabel("인천");
		arrival2.setHorizontalAlignment(JLabel.CENTER);
		arrival2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		arrival2.setBounds(108, 25, 97, 30);
		arrival3 = new JLabel("(LON)");
		arrival3.setHorizontalAlignment(JLabel.CENTER);
		arrival3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		arrival3.setBounds(120, 50, 70, 25);

		bookP.add(departure1);
		bookP.add(departure2);
		bookP.add(departure3);
		bookP.add(arrival1);
		bookP.add(arrival2);
		bookP.add(arrival3);

		// 항공사
		airLP = new JPanel();
		airLP.setLayout(null);
		airLP.setBackground(Color.WHITE);
		airLP.setBounds(230, 55, 105, 90);
		airL = new JLabel("항공사");
		airL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		airL.setBounds(33, 0, 60, 25);
		airLN = new JLabel("비트항공"); // 항공사이름
		airLN.setHorizontalAlignment(JLabel.CENTER);
		airLN.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		airLN.setBounds(4, 25, 97, 30);
		airLC = new JLabel("OZ222"); // 비행기 코드
		airLC.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		airLC.setHorizontalAlignment(JLabel.CENTER);
		airLC.setBounds(17, 47, 70, 30);

		airLP.add(airL);
		airLP.add(airLN);
		airLP.add(airLC);

		// 좌석
		personP = new JPanel();
		personP.setLayout(null);
		personP.setBackground(Color.WHITE);
		personP.setBounds(340, 55, 95, 90);
		bkpL = new JLabel("예약자");
		bkpL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		bkpL.setBounds(28, 1, 60, 25);
		nameL = new JLabel("이창만"); // 예약자이름
		nameL.setHorizontalAlignment(JLabel.CENTER);
		nameL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameL.setBounds(4, 25, 87, 30);
		idL = new JLabel("onlythisframe"); // 아이디
		idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setBounds(4, 48, 87, 30);

		personP.add(bkpL);
		personP.add(nameL);
		personP.add(idL);

		// 출발일, 도착일
		daDateP = new JPanel();
		daDateP.setLayout(null);
		daDateP.setBackground(Color.WHITE);
		daDateP.setBounds(440, 55, 153, 90);
		departureL = new JLabel("출발시간 :");
		departureL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		departureL.setBounds(2, 10, 65, 30);
		departureD = new JLabel("11:00");
		departureD.setHorizontalAlignment(JLabel.CENTER);
		departureD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		departureD.setBounds(60, 10, 65, 30);
		arrivalL = new JLabel("도착시간 :");
		arrivalL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		arrivalL.setBounds(2, 50, 65, 30);
		arrivalD = new JLabel("14:00");
		arrivalD.setHorizontalAlignment(JLabel.CENTER);
		arrivalD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		arrivalD.setBounds(60, 50, 65, 30);

		daDateP.add(departureL);
		daDateP.add(departureD);
		daDateP.add(arrivalL);
		daDateP.add(arrivalD);

		// 총 결제금액 패널 (총 결제금액, 인원, 금액)
		allPayP = new JPanel();
		allPayP.setLayout(null);
		allPayP.setBackground(Color.WHITE);
		allPayP.setBounds(14, 150, 579, 29);
		allPay = new JLabel("▶  총 요금");
		allPay.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		allPay.setBounds(6, 0, 100, 29);

		// 인원
		allPerson = new JLabel("총 인원 :");
		allPerson.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		allPerson.setBounds(325, 0, 60, 29);
		allPersonN = new JLabel("5");
		allPersonN.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		allPersonN.setBounds(393, 0, 15, 29);
		allPersons = new JLabel("명");
		allPersons.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		allPersons.setBounds(405, 0, 25, 29);

		moneyL = new JLabel("1542000");
		moneyL.setHorizontalAlignment(JLabel.RIGHT);
		moneyL.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		moneyL.setBounds(469, 0, 85, 29);
		money = new JLabel("원");
		money.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		money.setBounds(557, 0, 25, 29);

		allPayP.add(allPay);
		allPayP.add(allPerson);
		allPayP.add(allPersonN);
		allPayP.add(allPersons);
		allPayP.add(moneyL);
		allPayP.add(money);

		bookInfoP.add(bookInfoL);
		bookInfoP.add(bookDateL);
		bookInfoP.add(bookDate);
		bookInfoP.add(bookP);
		bookInfoP.add(airLP);
		bookInfoP.add(personP);
		bookInfoP.add(daDateP);
		bookInfoP.add(allPayP);

		// 예약상세내역 목차
		bookDetailP = new JPanel();
		bookDetailP.setLayout(null);
		bookDetailP.setBackground(new Color(3, 136, 166));
		bookDetailP.setBounds(0, 190, 615, 35);
		bookDetailL = new JLabel("예약상세내역");
		bookDetailL.setForeground(Color.WHITE);
		bookDetailL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bookDetailL.setBounds(5, 0, 105, 35);

		bookDetailP.add(bookDetailL);

		// 탑승객 예약 정보
		output();

		// 뒤로가기 버튼, 예약취소 버튼
		backBtn = new JButton("뒤로");
		backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		backBtn.setBounds(207, 330, 100, 35);
		bookCancelBtn = new JButton("예약취소");
		bookCancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bookCancelBtn.setBounds(314, 330, 100, 35);

		// allP에 넣기
		allP.add(bookInfoP);
		allP.add(bookDetailP);

		Container c = getContentPane();
		c.add(all);
		c.add(backBtn);
		c.add(bookCancelBtn);

		setTitle("예약내역");
		setSize(630, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		backBtn.addActionListener(this);
		bookCancelBtn.addActionListener(this);
		backBtn.setFocusable(false);
		bookCancelBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) { // 뒤로가기 버튼
			dispose();
		} else if (e.getSource() == bookCancelBtn) { // 예약취소 버튼
			new Member_Book_Cancel_();
			dispose();
		}
	}

	public void output() {
		// int count = 0;
		// 사용자 정보값(몇 명 예약을 했는지)을 받아와서 i < 정보값 으로 변경해야함.
		for (int i = 0; i < 2; i++) {
			Member_Book_Detail_P bDtP = new Member_Book_Detail_P();
			allP.setPreferredSize(new Dimension(625, y + p));
			bDtP.setBounds(x, y, width, height);
			y += p;
			allP.add(bDtP);
		}
		// return count;
	}
}