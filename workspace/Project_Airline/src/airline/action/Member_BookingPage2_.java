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

		// �� �������� ���� �г�
		bookP = new JPanel();
		bookP.setLayout(null);
		bookP.setBackground(new Color(3, 136, 166));
		bookP.setBounds(0, 0, 607, 30);

		bookL = new JLabel("�� ��������");
		bookL.setForeground(Color.WHITE);
		bookL.setFont(new Font("���� ���", Font.BOLD, 17));
		bookL.setBounds(5, 2, 150, 25);
		bookP.add(bookL);

		// ��������� ���� �г�
		payMthdP = new JPanel();
		payMthdP.setLayout(null);
		payMthdP.setBackground(new Color(3, 136, 166));
		payMthdP.setBounds(0, 35, 607, 60);
		payMthdL = new JLabel("��    �������");
		payMthdL.setForeground(Color.WHITE);
		payMthdL.setFont(new Font("���� ���", Font.BOLD, 15));
		payMthdL.setBounds(14, 17, 110, 25);
		payMthdComboBox = new JComboBox();
		payMthdComboBox.setModel(new DefaultComboBoxModel(new String[] { "�ſ�ī��", "�������Ա�", "�޴�������" }));
		payMthdComboBox.setBackground(Color.WHITE);
		payMthdComboBox.setBounds(135, 17, 350, 25);

		payMthdP.add(payMthdL);
		payMthdP.add(payMthdComboBox);

		// �� ���������� ���� �г� -> ����
		allPayP = new JPanel();
		allPayP.setLayout(null);
		allPayP.setBackground(new Color(3, 136, 166));
		allPayP.setBounds(0, 100, 607, 35);
		allPL1 = new JLabel("��    �� ���");
		allPL1.setForeground(Color.WHITE);
		allPL1.setFont(new Font("���� ���", Font.BOLD, 15));
		allPL1.setBounds(14, 5, 100, 25);
		allPL2 = new JLabel();
		allPL2.setFont(new Font("���� ���", Font.BOLD, 14));
		allPL2.setBounds(450, 5, 130, 25);
		allPL2.setOpaque(true);
		allPL2.setBackground(Color.WHITE);

		allPL3 = new JLabel("��");
		allPL3.setForeground(Color.WHITE);
		allPL3.setFont(new Font("���� ���", Font.BOLD, 14));
		allPL3.setBounds(585, 5, 35, 25);

		allPayP.add(allPL1);
		allPayP.add(allPL2);
		allPayP.add(allPL3);

		// ž�°� ���� ����
		psngrP = new JPanel();
		psngrP.setLayout(null);
		psngrP.setBackground(new Color(3, 136, 166));
		psngrP.setBounds(0, 140, 607, 35);
		psngrL = new JLabel("����󼼻�Ȳ");
		psngrL.setForeground(Color.WHITE);
		psngrL.setFont(new Font("���� ���", Font.BOLD, 17));
		psngrL.setBounds(5, 2, 120, 25);

		psngrP.add(psngrL);

		// ž�°����������� ���� �г�
		output(loginId, person, planecode);

		// ����Ϸ�, ��� ��ư
		bookConfirmBtn = new JButton("����");
		bookConfirmBtn.setBounds(152, 230, 100, 35);
		cancelBtn = new JButton("���");
		cancelBtn.setBounds(259, 230, 100, 35);
		backBtn = new JButton("�ڷ�");
		backBtn.setBounds(366, 230, 100, 35);

		// JScollPane�� �ø���
		allP.add(bookP);
		allP.add(allPayP);
		allP.add(payMthdP);
		allP.add(psngrP);

		Container c = getContentPane();
		c.add(all);
		c.add(bookConfirmBtn);
		c.add(cancelBtn);
		c.add(backBtn);

		setTitle("BitAirline_����");
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

		bookConfirmBtn.addActionListener(this); // �����ϱ� ��ư
		cancelBtn.addActionListener(this); // ��� ��ư
		backBtn.addActionListener(this); // �ڷΰ��� ��ư
		bookConfirmBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
		backBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bookConfirmBtn) { // �����ϱ� ��ư
			if (Integer.parseInt(person) == 0) {
				JOptionPane.showMessageDialog(this, "���õ� �°��� �����ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int result = JOptionPane.showConfirmDialog(this, "       �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "                    �����Ϸ�\n���೻�� â���� Ȯ���Ͻ� �� �ֽ��ϴ�.", "����",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		} else if (e.getSource() == cancelBtn) { // ��� ��ư
			int result = JOptionPane.showConfirmDialog(this, "       ����Ͻðڽ��ϱ�?", "���", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				dispose();
			}
		} else if (e.getSource() == backBtn) { // �ڷΰ��� ��ư
			int result = JOptionPane.showConfirmDialog(this, "�ڷΰ��ø� �����Է��ؾ��մϴ�\n        �ڷΰ��ðڽ��ϱ�?", "���",
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
