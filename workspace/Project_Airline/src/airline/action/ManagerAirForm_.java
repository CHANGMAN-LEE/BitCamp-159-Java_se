package airline.action;

import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ManagerAirForm_ extends JFrame implements ActionListener {
	private PlaneDTO planeDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private JButton inputBtn, changeBtn, deleteBtn, backBtn, exitBtn;
	private JTable table;
	private JLabel managerL, imgL;
	private ImageIcon image1;
	private DefaultTableModel model;
	private List<PlaneDTO> list = new ArrayList<PlaneDTO>();
	private Thread t;
	private String planecode;
	private JPanel managerP;
	private JComboBox combo;

	public ManagerAirForm_() {

		JPanel managerP = new JPanel();
		managerP.setLayout(null);
		managerP.setBounds(750, 15, 230, 140);

		// JLabel
		image1 = new ImageIcon("manager.png");
		imgL = new JLabel(image1);
		imgL.setBounds(50, 0, 128, 128);

		managerL = new JLabel("관리자 로그인");
		managerL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		managerL.setBounds(75, 100, 100, 35);

		managerP.add(imgL);
		managerP.add(managerL);

		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] { "-", "BIT001", "BIT002", "BIT003", "BIT004", "BIT005",
				"BIT006", "BIT007", "BIT008", "BIT009", "BIT010" }));
		combo.setBounds(750, 180, 230, 35);

		inputBtn = new JButton("등록");
		changeBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");
		backBtn = new JButton("뒤로가기");
		exitBtn = new JButton("종료");

		add(managerP);

		add(combo);

		add(inputBtn);
		inputBtn.setBounds(755, 340, 220, 35);
		inputBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		add(changeBtn);
		changeBtn.setBounds(755, 380, 220, 35);
		changeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		add(deleteBtn);
		deleteBtn.setBounds(755, 420, 220, 35);
		deleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		add(backBtn);
		backBtn.setBounds(755, 460, 220, 35);
		backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		add(exitBtn);
		exitBtn.setBounds(755, 500, 220, 35);
		exitBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		Vector<String> v = new Vector<String>();
		v.add("비행기코드");
		v.add("날짜");
		v.add("출발지");
		v.add("도착지");
		v.add("출발시간");
		v.add("도착시간");
		v.add("가격");
		v.add("총 좌석수");
		model = new DefaultTableModel(v, 0);
		output(model);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(5, 7, 730, 560);
		add(scroll);

		Container c = getContentPane();
		c.add("Center", scroll);
		c.add(managerP);

		getContentPane().setBackground(new Color(3, 136, 166));
		setTitle("BitAirline_[관리자] 항공편관리");
		setSize(1000, 600);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		inputBtn.addActionListener(this);
		changeBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		backBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		combo.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public DefaultTableModel output4(DefaultTableModel model) {
		model.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list) {
			if (combo.getSelectedItem().equals(planeDTO.getPlaneCode()) || combo.getSelectedItem().equals("-")) {
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
			}
		}
		return model;
	}

	public int output(DefaultTableModel model) {
		model.setRowCount(0);
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
			v.add((planeDTO.getTotalSeat()) + " / " + planeDTO.getTotalSeat());
			model.addRow(v);
			sw = 1;
		}
		return sw;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inputBtn) {
			new ManagerAirForm_Input(model);

		} else if (e.getSource() == changeBtn) {
			int check = 0;
			airlineDAO = new AirlineDAO();
			list = airlineDAO.getplaneList();
			planecode = JOptionPane.showInputDialog("          코드를 입력하세요.");
			for (PlaneDTO planeDTO : list) {
				if (planecode == null)
					return;
				if (!planecode.equals("")) {
					if (planecode.equals(planeDTO.getPlaneCode())) {
						check = 1;
						break;
					} else if (!planecode.equals(planeDTO.getPlaneCode())) {
						check = 3;
					}
				} else if (planecode.equals("")) {
					check = 2;
				}
			}
			if (check == 1) {
				new ManagerAirForm_Change(planecode, model);
			} else if (check == 2) {
				JOptionPane.showMessageDialog(this, "코드를 입력해주세요.");
			} else if (check == 3) {
				JOptionPane.showMessageDialog(this, "존재하지 않는 코드입니다.");
			}

		} else if (e.getSource() == deleteBtn) {
			new ManagerAirForm_Delete(model);

		} else if (e.getSource() == backBtn) {
			new Manager_();
			dispose();

		} else if (e.getSource() == exitBtn) {
			int choice = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == combo) {
			output4(model);
		}
	}
}