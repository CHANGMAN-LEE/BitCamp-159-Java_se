package airline.action;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class Manager_Form extends JFrame implements ActionListener {
	private MemberDTO memberDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private JButton exitBtn, infoBtn, backbtn;
	private JLabel managerL, imgL;
	private ImageIcon managerimg;
	private Vector<String> title;
	private JTable table;
	private DefaultTableModel model;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private String answerid;

	public Manager_Form() {
		setLayout(null);

		JPanel managerP = new JPanel();
		managerP.setLayout(null);
		managerP.setBounds(750, 15, 230, 140);

		// JLabel
		managerimg = new ImageIcon("manager.png");
		imgL = new JLabel(managerimg);
		imgL.setBounds(50, 0, 128, 128);

		managerL = new JLabel("관리자 로그인");
		managerL.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		managerL.setBounds(75, 100, 100, 35);

		managerP.add(imgL);
		managerP.add(managerL);

		// JButton
		infoBtn = new JButton("회원상세정보");
		infoBtn.setBounds(755, 420, 220, 35);
		infoBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		backbtn = new JButton("뒤로");
		backbtn.setBounds(755, 460, 220, 35);
		backbtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		exitBtn = new JButton("종료");
		exitBtn.setBounds(755, 500, 220, 35);
		exitBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		// JTable
		Object data[][] = {};
		title = new Vector<String>();
		title.add("아이디");
		title.add("이름");
		title.add("연락처");
		title.add("이메일");
		title.add("거주지역");
		model = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		output(model);

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(5, 7, 730, 560);
		add(scroll);

		Container c = getContentPane();
		c.add(managerP);
		c.add(infoBtn);
		c.add(backbtn);
		c.add(exitBtn);
		c.add(scroll);

		setTitle("BitAirline_[관리자] 회원관리");
		setSize(1000, 600);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(new Color(3, 136, 166));
		setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// 이벤트
		infoBtn.addActionListener(this);
		backbtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	public int output(DefaultTableModel model) {
		model.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list) {
			if (memberDTO.getCode() == 2) {
				Vector<String> v = new Vector<String>();
				v.add(memberDTO.getId());
				v.add(memberDTO.getName());
				v.add(memberDTO.getPhone());
				v.add(memberDTO.getMail());
				v.add(memberDTO.getAddress());
				model.addRow(v);
				sw = 1;
			}
		}
		return sw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int check = 0;
		list = airlineDAO.getmemberList();
		if (e.getSource() == infoBtn) {
			answerid = JOptionPane.showInputDialog("회원 아이디를 입력해주세요.");
			if (answerid == null)
				return;
			for (MemberDTO memberDTO : list) {
				if (answerid.equals(memberDTO.getId())) {
					check = 1;
					break;
				} else {
					check = 2;
				}
			}
			if (check == 1) {
				new Manager_MemberInfo(answerid, model);
			} else if (check == 2) {
				JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == exitBtn) {
			int choice = JOptionPane.showConfirmDialog(this, "로그아웃하시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				new AirlineMain_Login();
				dispose();
			} else if (choice == JOptionPane.NO_OPTION) {
				return;
			}
		} else if (e.getSource() == backbtn) {
			new Manager_();
			dispose();
		}
	}// actionPerformed
}