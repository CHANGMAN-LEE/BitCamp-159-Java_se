package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class ManagerAirForm_Input extends JFrame implements ActionListener {
	private PlaneDTO planeDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private JTextField start, startEng, arrivalT, arrivalTEng, stime, atime, priceT, total;
	private JButton inputBtn, cancelBtn;
	private JLabel codeL, startL, startInfoL, arrivalL, arrivalInfoL, dateL, stimeL, stimeInfoL, atimeL, atimeInfoL,
			priceL, totalL;
	private UtilDateModel model;
	private DefaultTableModel model2;
	private List<PlaneDTO> list = new ArrayList<PlaneDTO>();
	private JComboBox combo;

	public ManagerAirForm_Input(DefaultTableModel model2) {
		this.model2 = model2;
		setLayout(null);
		codeL = new JLabel("������ڵ�");
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] { "-", "BIT001", "BIT002", "BIT003", "BIT004", "BIT005",
				"BIT006", "BIT007", "BIT008", "BIT009", "BIT010" }));
		add(codeL);
		add(combo);
		codeL.setBounds(35, 40, 80, 35);
		combo.setBounds(120, 43, 185, 28);
		codeL.setFont(new Font("���� ���", Font.BOLD, 14));
		codeL.setForeground(Color.WHITE);
		combo.setFont(new Font("���� ���", Font.BOLD, 15));

		dateL = new JLabel("��¥");
		add(dateL);
		dateL.setBounds(35, 85, 80, 35);
		dateL.setFont(new Font("���� ���", Font.BOLD, 14));
		dateL.setForeground(Color.WHITE);
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		add(datePicker);
		datePicker.setBounds(120, 88, 185, 28);

		startL = new JLabel("�����");
		startInfoL = new JLabel("(���׸�/�����ڵ�)");
		start = new JTextField(15);
		startEng = new JTextField(15);
		add(startL);
		add(startInfoL);
		add(start);
		add(startEng);
		startL.setBounds(35, 123, 45, 35);
		startInfoL.setBounds(35, 139, 110, 35); // 16
		start.setBounds(120, 133, 110, 28);
		startEng.setBounds(240, 133, 65, 28); // 10
		startL.setFont(new Font("���� ���", Font.BOLD, 14));
		startInfoL.setFont(new Font("���� ���", Font.PLAIN, 10));
		start.setFont(new Font("���� ���", Font.PLAIN, 15));
		startEng.setFont(new Font("���� ���", Font.PLAIN, 15));
		startL.setForeground(Color.WHITE);
		startInfoL.setForeground(Color.WHITE);

		arrivalL = new JLabel("������");
		arrivalInfoL = new JLabel("(���׸�/�����ڵ�)");
		arrivalT = new JTextField(15);
		arrivalTEng = new JTextField(15);
		add(arrivalL);
		add(arrivalInfoL);
		add(arrivalT);
		add(arrivalTEng);
		arrivalL.setBounds(35, 168, 45, 35);
		arrivalInfoL.setBounds(35, 183, 90, 35);
		arrivalT.setBounds(120, 178, 110, 28);
		arrivalTEng.setBounds(240, 178, 65, 28);
		arrivalL.setFont(new Font("���� ���", Font.BOLD, 14));
		arrivalInfoL.setFont(new Font("���� ���", Font.PLAIN, 10));
		arrivalT.setFont(new Font("���� ���", Font.PLAIN, 15));
		arrivalTEng.setFont(new Font("���� ���", Font.PLAIN, 15));
		arrivalL.setForeground(Color.WHITE);
		arrivalInfoL.setForeground(Color.WHITE);

		stimeL = new JLabel("��߽ð�");
		stimeInfoL = new JLabel("(00 : 00 ����)");
		stime = new JTextField(15);
		add(stimeL);
		add(stimeInfoL);
		add(stime);
		stimeL.setBounds(35, 213, 80, 35);
		stimeInfoL.setBounds(35, 228, 80, 35);
		stime.setBounds(120, 223, 185, 28);
		stimeL.setFont(new Font("���� ���", Font.BOLD, 14));
		stimeInfoL.setFont(new Font("���� ���", Font.PLAIN, 10));
		stime.setFont(new Font("���� ���", Font.PLAIN, 15));
		stimeL.setForeground(Color.WHITE);
		stimeInfoL.setForeground(Color.WHITE);

		atimeL = new JLabel("�����ð�");
		atimeInfoL = new JLabel("(00 : 00 ����)");
		atime = new JTextField(15);
		add(atimeL);
		add(atimeInfoL);
		add(atime);
		atimeL.setBounds(35, 258, 80, 35);
		atimeInfoL.setBounds(35, 273, 80, 35);
		atime.setBounds(120, 268, 185, 28);
		atimeL.setFont(new Font("���� ���", Font.BOLD, 14));
		atimeInfoL.setFont(new Font("���� ���", Font.PLAIN, 10));
		atime.setFont(new Font("���� ���", Font.PLAIN, 15));
		atimeL.setForeground(Color.WHITE);
		atimeInfoL.setForeground(Color.WHITE);

		priceL = new JLabel("����");
		priceT = new JTextField(15);
		add(priceL);
		add(priceT);
		priceL.setBounds(35, 313, 80, 35);
		priceT.setBounds(120, 313, 185, 28);
		priceL.setFont(new Font("���� ���", Font.BOLD, 14));
		priceT.setFont(new Font("���� ���", Font.PLAIN, 15));
		priceL.setForeground(Color.WHITE);

		totalL = new JLabel("�� �¼���");
		total = new JTextField(15);
		add(totalL);
		add(total);
		totalL.setBounds(35, 358, 80, 35);
		total.setBounds(120, 358, 185, 28);
		totalL.setFont(new Font("���� ���", Font.BOLD, 14));
		total.setFont(new Font("���� ���", Font.PLAIN, 15));
		totalL.setForeground(Color.WHITE);

		inputBtn = new JButton("���");
		add(inputBtn);
		inputBtn.setBounds(72, 424, 91, 28);
		inputBtn.setFont(new Font("���� ���", Font.BOLD, 14));

		cancelBtn = new JButton("���");
		add(cancelBtn);
		cancelBtn.setBounds(173, 424, 91, 28);
		cancelBtn.setFont(new Font("���� ���", Font.BOLD, 14));

		getContentPane().setBackground(new Color(3, 136, 166));
		setTitle("BitAirline_[������] �װ��� ���");
		setResizable(false);
		setSize(350, 500);
		setVisible(true);
		setLocationRelativeTo(null);

		inputBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		inputBtn.setFocusable(false);
		cancelBtn.setFocusable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inputBtn) {

			// ��ĭ �� ��
			if (combo.getSelectedItem().equals("-") || startEng.getText().equals("") || arrivalT.getText().equals("")
					|| arrivalTEng.getText().equals("") || stime.getText().equals("") || atime.getText().equals("")
					|| priceT.getText().equals("") || total.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "�� ĭ�� ä���ּ���.");
				return;
			}

			String[] departuree = stime.getText().split(":");
			String[] arrivall = atime.getText().split(":");

			// ���� ��߽ð� ���� �� ��
			if (Integer.parseInt(departuree[0]) == Integer.parseInt(arrivall[0])
					&& Integer.parseInt(departuree[1]) == Integer.parseInt(arrivall[1])) {
				JOptionPane.showMessageDialog(this, "��߽ð��� �����ð��� �����մϴ�.\n               �������ּ���");
				return;

			}

			// ������ ��߽ð����� Ŭ ��
			if (Integer.parseInt(departuree[0]) > Integer.parseInt(arrivall[0])) {
				JOptionPane.showMessageDialog(this, "�����ð��� Ȯ�����ֽð� �������ּ���");
				return;
			}

			planeDTO = new PlaneDTO();
			int seq2 = airlineDAO.getSeq2();
			String planecode = (String) combo.getSelectedItem();
			String dday = model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay();
			String departure = start.getText();
			String arrival = arrivalT.getText();
			String departEng = startEng.getText();
			String arrivEng = arrivalTEng.getText();
			String time1 = stime.getText();
			String time2 = atime.getText();
			String price = priceT.getText();
			String totalseat = total.getText();

			planeDTO.setSeq2(seq2);
			planeDTO.setPlaneCode(planecode);
			planeDTO.setDate(dday);
			planeDTO.setDeparture(departure);
			planeDTO.setArrival(arrival);
			planeDTO.setDepartureEng(departEng);
			planeDTO.setArrivalEng(arrivEng);
			planeDTO.setTime1(time1);
			planeDTO.setTime2(time2);
			planeDTO.setPrice(price);
			planeDTO.setTotalSeat(totalseat);

			airlineDAO.plane_insert(planeDTO);
			JOptionPane.showMessageDialog(this, "   ��ϿϷ�       ");
			output(model2);
			dispose();
		} else if (e.getSource() == cancelBtn) {
			dispose();
		}
	}

	public int output(DefaultTableModel model2) {
		this.model2 = model2;
		model2.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list) {
			Vector<String> v = new Vector<String>();
			v.add(planeDTO.getPlaneCode());
			v.add(planeDTO.getDate());
			v.add(planeDTO.getDeparture());
			v.add(planeDTO.getArrival());
			v.add(planeDTO.getTime1());
			v.add(planeDTO.getTime2());
			v.add(planeDTO.getPrice());
			v.add(planeDTO.getTotalSeat());

			model2.addRow(v);
			sw = 1;
		}
		return sw;
	}
}