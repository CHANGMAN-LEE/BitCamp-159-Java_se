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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import airline.bean.PaymentDTO;
import airline.dao.AirlineDAO;

public class Member_BookingPage2_ extends JFrame implements ActionListener {
	private JPanel allP, allPayP, payMthdP, psngrP, bookP;
	private JLabel bookL, allPL1, allPL2, allPL3, payMthdL, psngrL;
	private JComboBox payMthdComboBox;
	private JButton bookConfirmBtn, cancelBtn, backBtn;
	private String person;
	private int x = 0, y = 180, width = 607, height = 75;
	private int p = 78;
	private String loginId, planecode;
	private List<Member_BookingPage1_PsngrInfo> list;

	public Member_BookingPage2_(String person, String loginId, String planecode, List<Member_BookingPage1_PsngrInfo> list) {
		this.loginId = loginId;
		this.person = person;
		this.planecode = planecode;
		this.list = list;
		Integer.parseInt(person);

		setLayout(null);
		getContentPane().setBackground(new Color(3, 136, 166));

		allP = new JPanel();
		allP.setLayout(null);
		allP.setAutoscrolls(true);
		allP.setBackground(new Color(238, 238, 238));
		allP.setPreferredSize(new Dimension(625, y));

		JScrollPane all = new JScrollPane(allP);
		all.setBounds(0, 0, 625, 225);
		all.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		all.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 총 운임정보 목차 패널
		bookP = new JPanel();
		bookP.setLayout(null);
		bookP.setBackground(new Color(3, 136, 166));
		bookP.setBounds(0, 0, 607, 30);

		bookL = new JLabel("총 운임정보");
		bookL.setForeground(Color.WHITE);
		bookL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		bookL.setBounds(5, 2, 150, 25);
		bookP.add(bookL);

		// 결제방식이 들어가는 패널
		payMthdP = new JPanel();
		payMthdP.setLayout(null);
		payMthdP.setBackground(new Color(3, 136, 166));
		payMthdP.setBounds(0, 35, 607, 60);
		payMthdL = new JLabel("▶    결제방식");
		payMthdL.setForeground(Color.WHITE);
		payMthdL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payMthdL.setBounds(14, 17, 110, 25);
		payMthdComboBox = new JComboBox();
		payMthdComboBox.setModel(new DefaultComboBoxModel(new String[] { "신용카드", "무통장입금", "휴대폰결제" }));
		payMthdComboBox.setBackground(Color.WHITE);
		payMthdComboBox.setBounds(135, 17, 350, 25);

		payMthdP.add(payMthdL);
		payMthdP.add(payMthdComboBox);

		// 총 운임정보가 들어가는 패널 -> 가격
		allPayP = new JPanel();
		allPayP.setLayout(null);
		allPayP.setBackground(new Color(3, 136, 166));
		allPayP.setBounds(0, 100, 607, 35);
		allPL1 = new JLabel("▶    총 요금");
		allPL1.setForeground(Color.WHITE);
		allPL1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		allPL1.setBounds(14, 5, 100, 25);
		allPL2 = new JLabel();
		allPL2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		allPL2.setBounds(450, 5, 130, 25);
		allPL2.setOpaque(true);
		allPL2.setBackground(Color.WHITE);

		allPL3 = new JLabel("원");
		allPL3.setForeground(Color.WHITE);
		allPL3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		allPL3.setBounds(585, 5, 35, 25);

		allPayP.add(allPL1);
		allPayP.add(allPL2);
		allPayP.add(allPL3);

		// 탑승객 정보 목차
		psngrP = new JPanel();
		psngrP.setLayout(null);
		psngrP.setBackground(new Color(3, 136, 166));
		psngrP.setBounds(0, 140, 607, 35);
		psngrL = new JLabel("예약상세상황");
		psngrL.setForeground(Color.WHITE);
		psngrL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		psngrL.setBounds(5, 2, 120, 25);

		psngrP.add(psngrL);

		// 탑승객운임정보가 들어가는 패널
		output(loginId, person, planecode);

		// 예약완료, 취소 버튼
		bookConfirmBtn = new JButton("결제");
		bookConfirmBtn.setBounds(152, 230, 100, 35);
		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(259, 230, 100, 35);
		backBtn = new JButton("뒤로");
		backBtn.setBounds(366, 230, 100, 35);

		// JScollPane에 올리기
		allP.add(bookP);
		allP.add(allPayP);
		allP.add(payMthdP);
		allP.add(psngrP);

		Container c = getContentPane();
		c.add(all);
		c.add(bookConfirmBtn);
		c.add(cancelBtn);
		c.add(backBtn);

		setTitle("BitAirline_결제");
		setSize(630, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		bookConfirmBtn.addActionListener(this); // 예약하기 버튼
		cancelBtn.addActionListener(this); // 취소 버튼
		backBtn.addActionListener(this); // 뒤로가기 버튼
		bookConfirmBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
		backBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bookConfirmBtn) { // 예약하기 버튼
			if (Integer.parseInt(person) == 0) {
				JOptionPane.showMessageDialog(this, "선택된 승객이 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int result = JOptionPane.showConfirmDialog(this, "       결제하시겠습니까?", "결제", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "                    결제완료\n예약내역 창에서 확인하실 수 있습니다.", "결제",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		} else if (e.getSource() == cancelBtn) { // 취소 버튼
			int result = JOptionPane.showConfirmDialog(this, "       취소하시겠습니까?", "취소", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				dispose();
			}
		} else if (e.getSource() == backBtn) { // 뒤로가기 버튼
			int result = JOptionPane.showConfirmDialog(this, "뒤로가시면 새로입력해야합니다\n        뒤로가시겠습니까?", "취소",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				dispose();
				new Member_BookingPage1_(loginId, planecode);
			}
		}
	}

	public int output(String loginId, String person, String planecode) {
		this.person = person;
		this.loginId = loginId;
		this.planecode = planecode;
		int count = 0;

		for (int i = 0; i < Integer.parseInt(this.person); i++) {
			Member_BookingPage2_PsngrInfo pbP2 = new Member_BookingPage2_PsngrInfo(this.loginId, this.planecode, this.person, this.list);
			allP.setPreferredSize(new Dimension(625, y + p));
			pbP2.setBounds(x, y, width, height);
			y += p;
			allP.add(pbP2);
		}
		return count;
	}
}
