package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class AirlineMain_Login extends JFrame implements ActionListener {
	private ImageIcon loginBg;
	private JPanel loginBgP;
	private Icon logo;
	private JLabel titleL;
	private JLabel idL;
	private JTextField idT;
	private JLabel pwL;
	private JPasswordField pwT;
	private JButton loginBtn, signupBtn, findIdBtn, findPwBtn;
	private String sql;
	private int code;
	private AirlineDAO airlineDAO;
	private MemberDTO memberDTO;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private Font font;

	public AirlineMain_Login() {
		setLayout(null);
		setTitle("BitAirline_로그인");
		loginBg = new ImageIcon("loginBg.jpg");
		loginBgP = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(loginBg.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		loginBgP.setLayout(null);
		loginBgP.setBounds(0, 0, 1000, 600);

		logo = new ImageIcon("logo.png");
		titleL = new JLabel(logo);
		titleL.setBounds(107, 110, 310, 71);

		idL = new JLabel("아이디");
		idL.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		idL.setForeground(Color.WHITE);
		idL.setBounds(120, 200, 60, 31);
		idT = new JTextField();
		idT.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		idT.setBounds(215, 200, 163, 31);
		idT.setColumns(10);

		pwL = new JLabel("비밀번호");
		pwL.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		pwL.setForeground(Color.WHITE);
		pwL.setBounds(120, 253, 76, 31);
		pwT = new JPasswordField();
		pwT.setEchoChar('*');
		pwT.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		pwT.setBounds(215, 253, 163, 31);
		pwT.setColumns(10);

		loginBtn = new JButton("로 그 인");
		loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBounds(120, 315, 248, 31);

		signupBtn = new JButton("회 원 가 입");
		signupBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		signupBtn.setBorderPainted(false);
		signupBtn.setContentAreaFilled(false);
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setBounds(120, 370, 248, 31);

		findIdBtn = new JButton("ID 찾기");
		findIdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		findIdBtn.setHorizontalAlignment(JLabel.CENTER);
		findIdBtn.setBorderPainted(false);
		findIdBtn.setContentAreaFilled(false);
		findIdBtn.setForeground(Color.WHITE);
		findIdBtn.setBounds(120, 420, 121, 31);

		findPwBtn = new JButton("PW 찾기");
		findPwBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		findPwBtn.setHorizontalAlignment(JLabel.CENTER);
		findPwBtn.setBorderPainted(false);
		findPwBtn.setContentAreaFilled(false);
		findPwBtn.setForeground(Color.WHITE);
		findPwBtn.setBounds(257, 420, 123, 31);

		loginBgP.add(titleL);
		loginBgP.add(idT);
		loginBgP.add(pwT);
		loginBgP.add(idL);
		loginBgP.add(pwL);
		loginBgP.add(loginBtn);
		loginBgP.add(signupBtn);
		loginBgP.add(findIdBtn);
		loginBgP.add(findPwBtn);

		add(loginBgP);

		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		idT.addKeyListener(new KeyAdapter() {
		       @Override
		       public void keyPressed(KeyEvent e) {
		    	   if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						login();
					}
		       }
		});
		pwT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		loginBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		findIdBtn.addActionListener(this);
		findPwBtn.addActionListener(this);
		loginBtn.setFocusable(false);
		signupBtn.setFocusable(false);
		findIdBtn.setFocusable(false);
		findPwBtn.setFocusable(false);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "로 그 인") {
			login();
		} else if (e.getActionCommand() == "회 원 가 입") {
			new AirlineMain_SignUp();
		} else if (e.getActionCommand() == "ID 찾기") {
			new AirlineMain_FindID();
		} else if (e.getActionCommand() == "PW 찾기") {
			new AirlineMain_FindPW();
		}
	}
	public void login() {
		int check = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list) {
			if (idT.getText().equals("") || pwT.getText().equals("")) {
				check = 1;
			} else {
				if (idT.getText().equals(memberDTO.getId())) {
					if (pwT.getText().equals(memberDTO.getPw())) {
						if (memberDTO.getCode() == 1) {
							check = 2;
							break;
						} else if (memberDTO.getCode() == 2) {
							check = 3;
							break;
						}
					} else if (!pwT.getText().equals(memberDTO.getPw())) {
						check = 5;
						break;
					}
				} else if (!idT.getText().equals(memberDTO.getId())) {
					check = 4;
				}
			}
		}
		if (check == 1) {
			JOptionPane.showMessageDialog(this, "빈 칸을 채워주세요.");
		} else if (check == 2) {
			new Manager_();
			dispose();
		} else if (check == 3) {
			new Member_(idT.getText());
			dispose();
		} else if (check == 4) {
			JOptionPane.showMessageDialog(this, "존재하지 않는 회원입니다.");
		} else if (check == 5) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
		}
	}
}