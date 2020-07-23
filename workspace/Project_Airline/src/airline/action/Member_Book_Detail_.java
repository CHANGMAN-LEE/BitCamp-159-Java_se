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
	private JPanel allP, allPayP, bookInfoP; // -> �����г�
	private JPanel bookP, airLP, personP, daDateP, bookDetailP; // ->�����гο� ���� �������� �г�
	private JLabel bookInfoL, bookDateL, bookDetailL; // -> ���� ��
	// �������� ��
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

		// ������ ����
		bookInfoP = new JPanel();
		bookInfoP.setLayout(null);
		bookInfoP.setBackground(new Color(3, 136, 166));
		bookInfoP.setBounds(0, 0, 615, 185);
		bookInfoL = new JLabel("�����Ͻ� ����");
		bookInfoL.setForeground(Color.WHITE);
		bookInfoL.setFont(new Font("���� ���", Font.BOLD, 17));
		bookInfoL.setBounds(5, 2, 150, 25);

		bookDateL = new JLabel("��߳�¥ :");
		bookDateL.setForeground(Color.WHITE);
		bookDateL.setFont(new Font("���� ���", Font.BOLD, 13));
		bookDateL.setBounds(400, 25, 90, 25);
		bookDate = new JLabel("2020�� 05�� 15��");
		bookDate.setFont(new Font("���� ���", Font.BOLD, 13));
		bookDate.setForeground(Color.WHITE);
		bookDate.setBounds(470, 27, 130, 20);

		// ���, ����
		bookP = new JPanel();
		bookP.setLayout(null);
		bookP.setBackground(Color.WHITE);
		bookP.setBounds(14, 55, 210, 90);
		departure1 = new JLabel("���");
		departure1.setFont(new Font("���� ���", Font.BOLD, 13));
		departure1.setBounds(38, 0, 50, 35);
		departure2 = new JLabel("��õ");
		departure2.setHorizontalAlignment(JLabel.CENTER);
		departure2.setFont(new Font("���� ���", Font.BOLD, 22));
		departure2.setBounds(2, 25, 97, 30);
		departure3 = new JLabel("(LON)");
		departure3.setHorizontalAlignment(JLabel.CENTER);
		departure3.setFont(new Font("���� ���", Font.BOLD, 14));
		departure3.setBounds(14, 50, 70, 25);

		arrival1 = new JLabel("����");
		arrival1.setFont(new Font("���� ���", Font.BOLD, 13));
		arrival1.setBounds(142, 0, 50, 35);
		arrival2 = new JLabel("��õ");
		arrival2.setHorizontalAlignment(JLabel.CENTER);
		arrival2.setFont(new Font("���� ���", Font.BOLD, 22));
		arrival2.setBounds(108, 25, 97, 30);
		arrival3 = new JLabel("(LON)");
		arrival3.setHorizontalAlignment(JLabel.CENTER);
		arrival3.setFont(new Font("���� ���", Font.BOLD, 14));
		arrival3.setBounds(120, 50, 70, 25);

		bookP.add(departure1);
		bookP.add(departure2);
		bookP.add(departure3);
		bookP.add(arrival1);
		bookP.add(arrival2);
		bookP.add(arrival3);

		// �װ���
		airLP = new JPanel();
		airLP.setLayout(null);
		airLP.setBackground(Color.WHITE);
		airLP.setBounds(230, 55, 105, 90);
		airL = new JLabel("�װ���");
		airL.setFont(new Font("���� ���", Font.BOLD, 13));
		airL.setBounds(33, 0, 60, 25);
		airLN = new JLabel("��Ʈ�װ�"); // �װ����̸�
		airLN.setHorizontalAlignment(JLabel.CENTER);
		airLN.setFont(new Font("���� ���", Font.BOLD, 20));
		airLN.setBounds(4, 25, 97, 30);
		airLC = new JLabel("OZ222"); // ����� �ڵ�
		airLC.setFont(new Font("���� ���", Font.BOLD, 12));
		airLC.setHorizontalAlignment(JLabel.CENTER);
		airLC.setBounds(17, 47, 70, 30);

		airLP.add(airL);
		airLP.add(airLN);
		airLP.add(airLC);

		// �¼�
		personP = new JPanel();
		personP.setLayout(null);
		personP.setBackground(Color.WHITE);
		personP.setBounds(340, 55, 95, 90);
		bkpL = new JLabel("������");
		bkpL.setFont(new Font("���� ���", Font.BOLD, 13));
		bkpL.setBounds(28, 1, 60, 25);
		nameL = new JLabel("��â��"); // �������̸�
		nameL.setHorizontalAlignment(JLabel.CENTER);
		nameL.setFont(new Font("���� ���", Font.BOLD, 20));
		nameL.setBounds(4, 25, 87, 30);
		idL = new JLabel("onlythisframe"); // ���̵�
		idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setFont(new Font("���� ���", Font.BOLD, 12));
		idL.setHorizontalAlignment(JLabel.CENTER);
		idL.setBounds(4, 48, 87, 30);

		personP.add(bkpL);
		personP.add(nameL);
		personP.add(idL);

		// �����, ������
		daDateP = new JPanel();
		daDateP.setLayout(null);
		daDateP.setBackground(Color.WHITE);
		daDateP.setBounds(440, 55, 153, 90);
		departureL = new JLabel("��߽ð� :");
		departureL.setFont(new Font("���� ���", Font.BOLD, 13));
		departureL.setBounds(2, 10, 65, 30);
		departureD = new JLabel("11:00");
		departureD.setHorizontalAlignment(JLabel.CENTER);
		departureD.setFont(new Font("���� ���", Font.BOLD, 15));
		departureD.setBounds(60, 10, 65, 30);
		arrivalL = new JLabel("�����ð� :");
		arrivalL.setFont(new Font("���� ���", Font.BOLD, 13));
		arrivalL.setBounds(2, 50, 65, 30);
		arrivalD = new JLabel("14:00");
		arrivalD.setHorizontalAlignment(JLabel.CENTER);
		arrivalD.setFont(new Font("���� ���", Font.BOLD, 15));
		arrivalD.setBounds(60, 50, 65, 30);

		daDateP.add(departureL);
		daDateP.add(departureD);
		daDateP.add(arrivalL);
		daDateP.add(arrivalD);

		// �� �����ݾ� �г� (�� �����ݾ�, �ο�, �ݾ�)
		allPayP = new JPanel();
		allPayP.setLayout(null);
		allPayP.setBackground(Color.WHITE);
		allPayP.setBounds(14, 150, 579, 29);
		allPay = new JLabel("��  �� ���");
		allPay.setFont(new Font("���� ���", Font.BOLD, 14));
		allPay.setBounds(6, 0, 100, 29);

		// �ο�
		allPerson = new JLabel("�� �ο� :");
		allPerson.setFont(new Font("���� ���", Font.BOLD, 14));
		allPerson.setBounds(325, 0, 60, 29);
		allPersonN = new JLabel("5");
		allPersonN.setFont(new Font("���� ���", Font.BOLD, 16));
		allPersonN.setBounds(393, 0, 15, 29);
		allPersons = new JLabel("��");
		allPersons.setFont(new Font("���� ���", Font.BOLD, 14));
		allPersons.setBounds(405, 0, 25, 29);

		moneyL = new JLabel("1542000");
		moneyL.setHorizontalAlignment(JLabel.RIGHT);
		moneyL.setFont(new Font("���� ���", Font.BOLD, 16));
		moneyL.setBounds(469, 0, 85, 29);
		money = new JLabel("��");
		money.setFont(new Font("���� ���", Font.BOLD, 14));
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

		// ����󼼳��� ����
		bookDetailP = new JPanel();
		bookDetailP.setLayout(null);
		bookDetailP.setBackground(new Color(3, 136, 166));
		bookDetailP.setBounds(0, 190, 615, 35);
		bookDetailL = new JLabel("����󼼳���");
		bookDetailL.setForeground(Color.WHITE);
		bookDetailL.setFont(new Font("���� ���", Font.BOLD, 17));
		bookDetailL.setBounds(5, 0, 105, 35);

		bookDetailP.add(bookDetailL);

		// ž�°� ���� ����
		output();

		// �ڷΰ��� ��ư, ������� ��ư
		backBtn = new JButton("�ڷ�");
		backBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		backBtn.setBounds(207, 330, 100, 35);
		bookCancelBtn = new JButton("�������");
		bookCancelBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		bookCancelBtn.setBounds(314, 330, 100, 35);

		// allP�� �ֱ�
		allP.add(bookInfoP);
		allP.add(bookDetailP);

		Container c = getContentPane();
		c.add(all);
		c.add(backBtn);
		c.add(bookCancelBtn);

		setTitle("���೻��");
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
		if (e.getSource() == backBtn) { // �ڷΰ��� ��ư
			dispose();
		} else if (e.getSource() == bookCancelBtn) { // ������� ��ư
			new Member_Book_Cancel_();
			dispose();
		}
	}

	public void output() {
		// int count = 0;
		// ����� ������(�� �� ������ �ߴ���)�� �޾ƿͼ� i < ������ ���� �����ؾ���.
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