package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AirlineMain_FindPW extends JFrame implements ActionListener {
	private ImageIcon mlogo;
	private Icon eIcon, qIcon;
	private JLabel titleL, pwdL, emailL, questionL;
	private JButton emailBtn, questionBtn, cancelBtn;
	private ButtonGroup bg = new ButtonGroup();
	
	public AirlineMain_FindPW() {
		setLayout(null);
		setTitle("BitAirline_비밀번호 찾기");
		getContentPane().setBackground(new Color(3, 136, 166));
		
		mlogo = new ImageIcon("mlogo.png");
		titleL = new JLabel(mlogo);
		titleL.setBounds(122, 10, 100, 30);
		
		pwdL = new JLabel("비밀번호 찾기");
		pwdL.setHorizontalAlignment(JLabel.CENTER);
		pwdL.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pwdL.setForeground(Color.WHITE);
		pwdL.setBounds(71, 40, 200, 30);
		
		eIcon = new ImageIcon("email.png");
		emailBtn = new JButton(eIcon);
		emailBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		emailBtn.setBounds(45, 80, 120, 85);
		emailBtn.setBorderPainted(false);
		emailBtn.setContentAreaFilled(false);
		
		emailL = new JLabel("이메일 인증");
		emailL.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		emailL.setBounds(68, 160, 80, 35);
		emailL.setForeground(Color.WHITE);
		
		qIcon = new ImageIcon("question.png");
		questionBtn = new JButton(qIcon);
		questionBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		questionBtn.setBounds(178, 80, 120, 85);
		questionBtn.setBorderPainted(false);
		questionBtn.setContentAreaFilled(false);
		
		questionL = new JLabel("질문/답변");
		questionL.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		questionL.setBounds(207, 160, 80, 35);
		questionL.setForeground(Color.WHITE);
		
		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cancelBtn.setBounds(128, 200, 85, 28);
		
		add(titleL);
		add(pwdL);
		add(emailBtn); add(questionBtn);
		add(emailL); add(questionL);
		add(cancelBtn);
		
		setSize(350, 270);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		emailBtn.addActionListener(this);
		questionBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		emailBtn.setFocusable(false);
		questionBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == emailBtn) { //이메일로 찾기 버튼
			new AirlineMain_FindPW1();
			dispose();
		}else if(e.getSource() == questionBtn) { //질문으로 찾기 버튼
			new AirlineMain_FindPW2();
			dispose();
		}else if(e.getActionCommand() == "취소") {
			dispose();
		}
	}
}
