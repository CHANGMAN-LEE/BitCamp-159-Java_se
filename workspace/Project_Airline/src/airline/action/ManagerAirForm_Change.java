package airline.action;

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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ManagerAirForm_Change extends JFrame implements ActionListener {
	private PlaneDTO planeDTO = new PlaneDTO();
	private AirlineDAO airlineDAO = new AirlineDAO();
	private List<PlaneDTO> list = new ArrayList<PlaneDTO>();
	private JTextField start, startEng, arrivalT, arrivalTEng, stime, atime, priceT, total;
	private JButton changeBtn, cancelBtn;
	private JLabel codeL, startL, startInfoL, arrivalL, arrivalInfoL, dateL, stimeL, stimeInfoL, atimeL, atimeInfoL,
			priceL, totalL;
	private UtilDateModel model;
	private DefaultTableModel model2;
	private String planecode;
	private int seq2;
	private JComboBox combo;

	public ManagerAirForm_Change(String planecode, DefaultTableModel model2) {
		this.planecode = planecode;
		this.model2 = model2;
		setLayout(null);
		codeL = new JLabel("∫Ò«‡±‚ƒ⁄µÂ");
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] { "-", "BIT001", "BIT002", "BIT003", "BIT004", "BIT005",
				"BIT006", "BIT007", "BIT008", "BIT009", "BIT010" }));
		add(codeL);
		add(combo);
		codeL.setBounds(35, 40, 80, 35);
		combo.setBounds(120, 43, 185, 28);
		codeL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		codeL.setForeground(Color.WHITE);
		combo.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));

		dateL = new JLabel("≥Ø¬•");
		add(dateL);
		dateL.setBounds(35, 85, 80, 35);
		dateL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		dateL.setForeground(Color.WHITE);
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		add(datePicker);
		datePicker.setBounds(120, 88, 185, 28);

		startL = new JLabel("√‚πﬂ¡ˆ");
		startInfoL = new JLabel("(∞¯«◊∏Ì/∞¯«◊ƒ⁄µÂ)");
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
		startL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		startInfoL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		start.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		startEng.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		startL.setForeground(Color.WHITE);
		startInfoL.setForeground(Color.WHITE);

		arrivalL = new JLabel("µµ¬¯¡ˆ");
		arrivalInfoL = new JLabel("(∞¯«◊∏Ì/∞¯«◊ƒ⁄µÂ)");
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
		arrivalL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		arrivalInfoL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		arrivalT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		arrivalTEng.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		arrivalL.setForeground(Color.WHITE);
		arrivalInfoL.setForeground(Color.WHITE);

		stimeL = new JLabel("√‚πﬂΩ√∞£");
		stimeInfoL = new JLabel("(00 : 00 «¸Ωƒ)");
		stime = new JTextField(15);
		add(stimeL);
		add(stimeInfoL);
		add(stime);
		stimeL.setBounds(35, 213, 80, 35);
		stimeInfoL.setBounds(35, 228, 80, 35);
		stime.setBounds(120, 223, 185, 28);
		stimeL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		stimeInfoL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		stime.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		stimeL.setForeground(Color.WHITE);
		stimeInfoL.setForeground(Color.WHITE);

		atimeL = new JLabel("µµ¬¯Ω√∞£");
		atimeInfoL = new JLabel("(00 : 00 «¸Ωƒ)");
		atime = new JTextField(15);
		add(atimeL);
		add(atimeInfoL);
		add(atime);
		atimeL.setBounds(35, 258, 80, 35);
		atimeInfoL.setBounds(35, 273, 80, 35);
		atime.setBounds(120, 268, 185, 28);
		atimeL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		atimeInfoL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 10));
		atime.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		atimeL.setForeground(Color.WHITE);
		atimeInfoL.setForeground(Color.WHITE);

		priceL = new JLabel("∞°∞›");
		priceT = new JTextField(15);
		add(priceL);
		add(priceT);
		priceL.setBounds(35, 313, 80, 35);
		priceT.setBounds(120, 313, 185, 28);
		priceL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		priceT.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		priceL.setForeground(Color.WHITE);

		totalL = new JLabel("√— ¡¬ºÆºˆ");
		total = new JTextField(15);
		add(totalL);
		add(total);
		totalL.setBounds(35, 358, 80, 35);
		total.setBounds(120, 358, 185, 28);
		totalL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		total.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		totalL.setForeground(Color.WHITE);

		changeBtn = new JButton("ºˆ¡§");
		add(changeBtn);
		changeBtn.setBounds(72, 424, 91, 28);
		changeBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));

		cancelBtn = new JButton("√Îº“");
		add(cancelBtn);
		cancelBtn.setBounds(173, 424, 91, 28);
		cancelBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));

		output(planecode);

		getContentPane().setBackground(new Color(3, 136, 166));
		setTitle("BitAirline_[∞¸∏Æ¿⁄] «◊∞¯∆Ì ºˆ¡§");
		setResizable(false);
		setSize(350, 500);
		setVisible(true);
		setLocationRelativeTo(null);

		changeBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		changeBtn.setFocusable(false);
		cancelBtn.setFocusable(false);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public int output(String planecode) {
		this.planecode = planecode;
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list) {
			if (planecode.equals(planeDTO.getPlaneCode())) {
				String[] date = planeDTO.getDate().split("-");
				int dateY = Integer.parseInt(date[0]);
				int dateM = Integer.parseInt(date[1]) - 1;
				int dateD = Integer.parseInt(date[2]);

				seq2 = planeDTO.getSeq2();
				combo.setSelectedItem(planeDTO.getPlaneCode());
				model.setDate(dateY, dateM, dateD);
				model.setSelected(true);
				start.setText(planeDTO.getDeparture());
				arrivalT.setText(planeDTO.getArrival());
				startEng.setText(planeDTO.getDepartureEng());
				arrivalTEng.setText(planeDTO.getArrivalEng());
				stime.setText(planeDTO.getTime1());
				atime.setText(planeDTO.getTime2());
				priceT.setText(planeDTO.getPrice());
				total.setText(planeDTO.getTotalSeat());
				sw = 1;
			}
		}
		return sw;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changeBtn) {

			// ∫Ûƒ≠ ¿œ ∂ß
			if (combo.getSelectedItem().equals("-") || startEng.getText().equals("") || arrivalT.getText().equals("")
					|| arrivalTEng.getText().equals("") || stime.getText().equals("") || atime.getText().equals("")
					|| priceT.getText().equals("") || total.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "∫Û ƒ≠¿ª √§øˆ¡÷ººø‰.");
				return;
			}

			String[] departuree = stime.getText().split(":");
			String[] arrivall = atime.getText().split(":");

			// µµ¬¯ √‚πﬂΩ√∞£ µø¿œ «“ ∂ß
			if (Integer.parseInt(departuree[0]) == Integer.parseInt(arrivall[0])
					&& Integer.parseInt(departuree[1]) == Integer.parseInt(arrivall[1])) {
				JOptionPane.showMessageDialog(this, "√‚πﬂΩ√∞£∞˙ µµ¬¯Ω√∞£¿Ã µø¿œ«’¥œ¥Ÿ.\n               ºˆ¡§«ÿ¡÷ººø‰");
				return;
			}

			// µµ¬¯¿Ã √‚πﬂΩ√∞£∫∏¥Ÿ ≈¨ ∂ß
			if (Integer.parseInt(departuree[0]) > Integer.parseInt(arrivall[0])) {
				JOptionPane.showMessageDialog(this, "µµ¬¯Ω√∞£¿ª »Æ¿Œ«ÿ¡÷Ω√∞Ì ºˆ¡§«ÿ¡÷ººø‰");
				return;
			}

			planeDTO.setSeq2(seq2);
			planeDTO.setPlaneCode(planecode);
			planeDTO.setDate(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay());
			planeDTO.setDeparture(start.getText());
			planeDTO.setArrival(arrivalT.getText());
			planeDTO.setDepartureEng(startEng.getText());
			planeDTO.setArrivalEng(arrivalTEng.getText());
			planeDTO.setTime1(stime.getText());
			planeDTO.setTime2(atime.getText());
			planeDTO.setPrice(priceT.getText());
			planeDTO.setTotalSeat(total.getText());

			airlineDAO.plane_update(planeDTO);
			// System.out.println("Ω««‡¡ﬂ");

			output(model2);
			JOptionPane.showMessageDialog(this, "              ºˆ¡§øœ∑·");
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

		String code1 = (String) combo.getSelectedItem();
		String departure = start.getText();

		for (PlaneDTO planeDTO : list) {
			if (planeDTO.getPlaneCode().equals(code1)) {
				Vector<String> v = new Vector<String>();
				String planecode = (String) combo.getSelectedItem();
				v.add(planeDTO.getPlaneCode());
				v.add(planeDTO.getDate());
				v.add(planeDTO.getDeparture());
				v.add(planeDTO.getArrival());
				v.add(planeDTO.getTime1());
				v.add(planeDTO.getTime2());
				v.add(planeDTO.getPrice()); 
				v.add((Integer.parseInt(total.getText()) + " / " + planeDTO.getTotalSeat()));

				model2.addRow(v);
				sw = 1;
			}
		}

		return sw;
	}

}
