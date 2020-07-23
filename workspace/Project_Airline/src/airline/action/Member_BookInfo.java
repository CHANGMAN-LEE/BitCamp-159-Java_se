package airline.action; //������

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import airline.bean.MemberDTO;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Member_BookInfo extends JFrame implements ActionListener {
	private String loginId, planecode;
	private PlaneDTO planeDTO = new PlaneDTO();
	private MemberDTO memberDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private List<PlaneDTO> list = new ArrayList<PlaneDTO>();
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	private JPanel bookP, myInfo;
	private ImageIcon logo; // �ΰ�
	private JLabel bookPLogo, myInfoLogo; // �ΰ��
	private JButton searchBtn, newBtn, bookBtn, exitBtn, bkDetailBtn, editBtn, logOutBtn;
	private JLabel search, departure, arrival, date, myInfoL, nameL, idL, pwdL, phoneL, addressL, emailL;
	private JTextField idT, nameT, phoneT, addressT, emailT;
	private JComboBox arrivalC, departureC;
	private JPasswordField pwdT;
	private JTabbedPane sideTab;
	private Vector<String> airline;
	private DefaultTableModel model;
	private UtilDateModel model2;
	private JTable aTable;
	private Calendar calendar = Calendar.getInstance();
	private int year = calendar.get(Calendar.YEAR);
	private int month = calendar.get(Calendar.MONTH) + 1;
	private int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	private int hour = calendar.get(Calendar.HOUR_OF_DAY);
	private int minute = calendar.get(Calendar.MINUTE);

	public Member_BookInfo(String id) {
		this.loginId = id;
		setLayout(null);
		getContentPane().setBackground(new Color(3, 101, 140));

		// MAIN ========
		// Vector ------------------------------------------
		airline = new Vector<String>();
		airline.add("������ڵ�");
		airline.add("��¥");
		airline.add("�����");
		airline.add("������");
		airline.add("��߽ð�");
		airline.add("�����ð�");
		airline.add("����");
		airline.add("�� �¼� ��");
		model = new DefaultTableModel(airline, 0) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		output(model);
		aTable = new JTable(model);
		aTable.setFont(new Font("���� ���", Font.BOLD, 13));

		JScrollPane aMain = new JScrollPane(aTable);
		aMain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aMain.setBounds(5, 7, 730, 560);
		// ------------------------------------------ Vector
		// ======== MAIN

		// SIDE ========
		// Tab 1 --------------------------------------------
		// SearchField
		bookP = new JPanel();
		bookP.setLayout(null);

		search = new JLabel("�װ� �˻�");
		search.setFont(new Font("���� ���", Font.BOLD, 16));
		search.setBounds(90, 5, 120, 35);

		departure = new JLabel("�����");
		departure.setFont(new Font("���� ���", Font.BOLD, 13));
		departure.setBounds(14, 50, 120, 35);

		// departureS = new JTextField();
		departureC = new JComboBox();
		departureC.setModel(
				new DefaultComboBoxModel(new String[] { "-", "��õ", "����", "����", "����", "û��", "�뱸", "���", "����" }));
		departureC.setBounds(14, 80, 220, 35);

		arrival = new JLabel("������");
		arrival.setFont(new Font("���� ���", Font.BOLD, 13));
		arrival.setBounds(14, 120, 220, 35);
		// arrivalS = new JTextField();
		arrivalC = new JComboBox();
		arrivalC.setModel(
				new DefaultComboBoxModel(new String[] { "-", "��õ", "����", "����", "����", "û��", "�뱸", "���", "����" }));
		arrivalC.setBounds(14, 150, 220, 35);

		date = new JLabel("��¥");
		date.setFont(new Font("���� ���", Font.BOLD, 13));
		date.setBounds(14, 190, 220, 35);

		model2 = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model2);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(14, 220, 220, 45);
		// model2.getDay());
		// (model2.getYear() + "-" + (model2.getMonth()+1) + "-" +(model2.getDay()

		logo = new ImageIcon("memLogo.png");
		bookPLogo = new JLabel(logo);
		bookPLogo.setBounds(45, 290, 165, 20);
		newBtn = new JButton("���ΰ�ħ");
		newBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		newBtn.setBounds(14, 349, 220, 35);
		searchBtn = new JButton("�˻��ϱ�");
		searchBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		searchBtn.setBounds(14, 393, 220, 35);
		bookBtn = new JButton("�����ϱ�");
		bookBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		bookBtn.setBounds(14, 438, 220, 35);
		exitBtn = new JButton("����");
		exitBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		exitBtn.setBounds(14, 482, 220, 35);

		bookP.add(search);
		bookP.add(departure);
		bookP.add(departureC);
		bookP.add(arrival);
		bookP.add(arrivalC);
		bookP.add(date);
		bookP.add(datePicker);

		bookP.add(bookPLogo);
		bookP.add(searchBtn);
		bookP.add(newBtn);
		bookP.add(bookBtn);
		bookP.add(exitBtn);

		// -------------------------------------------- Tab 1

		// Tab 2 --------------------------------------------
		// myInfo ------------------------------------------
		myInfo = new JPanel();
		myInfo.setLayout(null);

		myInfoL = new JLabel("���� ����");
		myInfoL.setFont(new Font("���� ���", Font.BOLD, 16));
		myInfoL.setBounds(90, 5, 120, 35);

		idL = new JLabel("���̵�");
		idL.setFont(new Font("���� ���", Font.BOLD, 13));
		idL.setBounds(14, 50, 45, 30);
		idT = new JTextField(17);
		idT.setFont(new Font("���� ���", Font.PLAIN, 13));
		idT.setEditable(false);
		idT.setBounds(14, 75, 220, 30);

		nameL = new JLabel("�̸�");
		nameL.setBounds(14, 105, 35, 30);
		nameT = new JTextField(17);
		nameT.setFont(new Font("���� ���", Font.PLAIN, 13));
		nameT.setEditable(false);
		nameT.setBounds(14, 130, 220, 30);

		phoneL = new JLabel("����ó");
		phoneL.setFont(new Font("���� ���", Font.BOLD, 13));
		phoneL.setBounds(14, 160, 45, 30);
		phoneT = new JTextField(17);
		phoneT.setFont(new Font("���� ���", Font.PLAIN, 13));
		phoneT.setEditable(false);
		phoneT.setBounds(14, 185, 220, 30);

		emailL = new JLabel("�̸���");
		emailL.setFont(new Font("���� ���", Font.BOLD, 13));
		emailL.setBounds(14, 215, 45, 30);
		emailT = new JTextField(17);
		emailT.setFont(new Font("���� ���", Font.PLAIN, 13));
		emailT.setEditable(false);
		emailT.setBounds(14, 240, 220, 30);

		addressL = new JLabel("�ּ�");
		addressL.setFont(new Font("���� ���", Font.BOLD, 13));
		addressL.setBounds(14, 270, 35, 30);
		addressT = new JTextField(17);
		addressT.setFont(new Font("���� ���", Font.PLAIN, 13));
		addressT.setEditable(false);
		addressT.setBounds(14, 295, 220, 30);

		logo = new ImageIcon("memLogo.png");
		myInfoLogo = new JLabel(logo);
		myInfoLogo.setBounds(45, 355, 165, 20);

		bkDetailBtn = new JButton("����Ȯ��");
		bkDetailBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		bkDetailBtn.setBounds(14, 410, 106, 65);
		editBtn = new JButton("��������");
		editBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		editBtn.setBounds(128, 410, 106, 65);
		logOutBtn = new JButton("�α׾ƿ�");
		logOutBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		logOutBtn.setBounds(14, 482, 220, 35);

		myInfo.add(myInfoL);
		myInfo.add(idL);
		myInfo.add(idT);
		myInfo.add(nameL);
		myInfo.add(nameT);
		myInfo.add(phoneL);
		myInfo.add(phoneT);
		myInfo.add(addressL);
		myInfo.add(addressT);
		myInfo.add(emailL);
		myInfo.add(emailT);

		myInfo.add(myInfoLogo);
		myInfo.add(bkDetailBtn);
		myInfo.add(editBtn);
		myInfo.add(logOutBtn);

		output2(loginId);

		// ------------------------------------------ myInfo

		// -------------------------------------------- Tab 2

		// JTabbedPane
		sideTab = new JTabbedPane(SwingConstants.TOP);
		sideTab.setFont(new Font("���� ���", Font.BOLD, 13));
		sideTab.setBounds(740, 4, 250, 563);
		sideTab.addTab("    �˻�    ", bookP);
		sideTab.addTab("  MyPage  ", myInfo);

		// ======== SIDE

		// Container
		Container c = getContentPane();
		add(aMain);
		add(sideTab);

		setSize(1000, 600);
		setTitle("BitAirline_�װ��� ����");
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		editBtn.setFocusable(false);
		bookBtn.setFocusable(false);
		bkDetailBtn.setFocusable(false);
		exitBtn.setFocusable(false);
		logOutBtn.setFocusable(false);
		searchBtn.setFocusable(false);
	}

	public void event() {
		editBtn.addActionListener(this);
		bookBtn.addActionListener(this);
		bkDetailBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		logOutBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		newBtn.addActionListener(this);
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editBtn) {// ����
			new Member_MyInfoEdit1(loginId, this);
		} else if (e.getSource() == bookBtn) {// �����ϱ�
			int check = 0;
			planecode = JOptionPane.showInputDialog(this, "�װ��ڵ带 �Է����ּ���.");
			airlineDAO = new AirlineDAO();
			list = airlineDAO.getplaneList();
			for (PlaneDTO planeDTO : list) {
				if (planecode == null)
					return;
				if (planecode.equals(planeDTO.getPlaneCode())) {
					check = 1;
					break;
				} else {
					check = 2;
				}
			}
			if (check == 1) {
				new Member_BookingPage1_(loginId, planecode);
			} else if (check == 2) {
				JOptionPane.showMessageDialog(this, "��ϵ� �װ��ڵ尡 �����ϴ�.");
			}
		} else if (e.getSource() == bkDetailBtn) {// ����Ȯ���ϱ�
			new Member_Book_Detail_();
		} else if (e.getSource() == exitBtn) {// ����
			int choice = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == logOutBtn) {// �α׾ƿ�
			int choice = JOptionPane.showConfirmDialog(this, "�α׾ƿ��Ͻðڽ��ϱ�?", "�α׾ƿ�", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				new AirlineMain_Login();
				dispose();
			}
		} else if (e.getSource() == searchBtn) {// �˻��ϱ�
			output3(model);
			remove();
		} else if (e.getSource() == newBtn) {// ���ΰ�ħ
			JOptionPane.showMessageDialog(this, "��ü �װ��� ��ȸ�� �̵��մϴ�.");
			output(model);
		}

	}// actionPerformed()

	public void remove() {
		arrivalC.setSelectedItem("-");
		departureC.setSelectedItem("-");
	}

	public int output(DefaultTableModel model) {
		model.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list) {
			String[] date = planeDTO.getDate().split("-");
			String[] time = planeDTO.getTime1().split(":");
			if (year < Integer.parseInt(date[0])) { // �⵵�� Ŭ ��
				Vector<String> v = new Vector<String>();
				v.add(planeDTO.getPlaneCode());
				v.add(planeDTO.getDate());
				v.add(planeDTO.getDeparture());
				v.add(planeDTO.getArrival());
				v.add(planeDTO.getTime1());
				v.add(planeDTO.getTime2());
				v.add(planeDTO.getPrice());
				v.add(planeDTO.getTotalSeat());
				model.addRow(v);
				sw = 1;
			} else if (year == Integer.parseInt(date[0])) { // �⵵�� ���� ��
				if (month < Integer.parseInt(date[1])) { // ���� Ŭ ��
					Vector<String> v = new Vector<String>();
					v.add(planeDTO.getPlaneCode());
					v.add(planeDTO.getDate());
					v.add(planeDTO.getDeparture());
					v.add(planeDTO.getArrival());
					v.add(planeDTO.getTime1());
					v.add(planeDTO.getTime2());
					v.add(planeDTO.getPrice());
					v.add(planeDTO.getTotalSeat());
					model.addRow(v);
					sw = 2;
				} else if (month == Integer.parseInt(date[1])) { // ���� ���� ��
					if (dayOfMonth < Integer.parseInt(date[2])) { // ���� Ŭ ��
						Vector<String> v = new Vector<String>();
						v.add(planeDTO.getPlaneCode());
						v.add(planeDTO.getDate());
						v.add(planeDTO.getDeparture());
						v.add(planeDTO.getArrival());
						v.add(planeDTO.getTime1());
						v.add(planeDTO.getTime2());
						v.add(planeDTO.getPrice());
						v.add(planeDTO.getTotalSeat());
						model.addRow(v);
						sw = 3;
					} else if (dayOfMonth == Integer.parseInt(date[2])) { // ���� ���� ��
						if (hour < Integer.parseInt(time[0])) { // �ð��� Ŭ ��
							Vector<String> v = new Vector<String>();
							v.add(planeDTO.getPlaneCode());
							v.add(planeDTO.getDate());
							v.add(planeDTO.getDeparture());
							v.add(planeDTO.getArrival());
							v.add(planeDTO.getTime1());
							v.add(planeDTO.getTime2());
							v.add(planeDTO.getPrice());
							v.add(planeDTO.getTotalSeat());
							model.addRow(v);
							sw = 1;
						} else if (hour == Integer.parseInt(time[0])) { // �ð��� ���� ��
							if (minute <= Integer.parseInt(time[1])) { // ���� ���ų� Ŭ ��
								Vector<String> v = new Vector<String>();
								v.add(planeDTO.getPlaneCode());
								v.add(planeDTO.getDate());
								v.add(planeDTO.getDeparture());
								v.add(planeDTO.getArrival());
								v.add(planeDTO.getTime1());
								v.add(planeDTO.getTime2());
								v.add(planeDTO.getPrice());
								v.add(planeDTO.getTotalSeat());
								model.addRow(v);
								sw = 4;
							}
						}
					}
				}
			}
		} // for
		return sw;
	}

	public int output2(String loginId) {
		this.loginId = loginId;
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list2 = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list2) {
			if (memberDTO.getId().equals(loginId)) {
				idT.setText(memberDTO.getId());
				// pwdT.setText(memberDTO.getPw());
				nameT.setText(memberDTO.getName());
				phoneT.setText(memberDTO.getPhone());
				emailT.setText(memberDTO.getMail());
				addressT.setText(memberDTO.getAddress());
			}
			sw = 1;
		}
		return sw;
	}

	public int output3(DefaultTableModel model) {
		model.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();

		// JLabel �̸��� ����ؼ� �ѱ��� �߰� ��
		String arrivall = (String) arrivalC.getSelectedItem();
		String departuree = (String) departureC.getSelectedItem();

		String yearC = Integer.toString((model2.getYear()));
		String monthC = Integer.toString((model2.getMonth() + 1));
		String dayC = Integer.toString(model2.getDay());

		for (PlaneDTO planeDTO : list) {
			String[] date = planeDTO.getDate().split("-");

			if (planeDTO.getDeparture().equals(departuree) && planeDTO.getArrival().equals(arrivall)
					&& yearC.equals(date[0]) && monthC.equals(date[1]) && dayC.equals(date[2])) {
				Vector<String> v = new Vector<String>();
				v.add(planeDTO.getPlaneCode());
				v.add(planeDTO.getDate());
				v.add(planeDTO.getDeparture());
				v.add(planeDTO.getArrival());
				v.add(planeDTO.getTime1());
				v.add(planeDTO.getTime2());
				v.add(planeDTO.getPrice());
				v.add(planeDTO.getTotalSeat());
				model.addRow(v);
				sw = 1;
			}
		} // for
		return sw;
	}// output3()

	public JTextField getNameT() {
		return nameT;
	}

	public JTextField getPhoneT() {
		return phoneT;
	}

	public JTextField getAddressT() {
		return addressT;
	}

	public JTextField getEmailT() {
		return emailT;
	}

	public void setNameT(JTextField nameT) {
		this.nameT = nameT;
	}

	public void setPhoneT(JTextField phoneT) {
		this.phoneT = phoneT;
	}

	public void setAddressT(JTextField addressT) {
		this.addressT = addressT;
	}

	public void setEmailT(JTextField emailT) {
		this.emailT = emailT;
	}
	
	
	
	
}