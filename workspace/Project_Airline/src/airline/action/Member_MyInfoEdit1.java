package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import airline.bean.MemberDTO;
import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;

public class Member_MyInfoEdit1 extends JFrame implements ActionListener {
	private JButton cancelBtn, confirmBtn;
	private JLabel info, pwdL;
	private JTextArea notice; 
	private JPasswordField pwdT;
	private String loginId;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private MemberDTO memberDTO;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private Member_BookInfo member_bookInfo;
	
	public Member_MyInfoEdit1(String loginId, Member_BookInfo member_bookInfo){
		this.loginId = loginId;
		this.member_bookInfo = member_bookInfo;
		setLayout(null);
		getContentPane().setBackground(new Color(3,136,166));
		
		info = new JLabel("��й�ȣ Ȯ��");
		info.setForeground(Color.WHITE);
		info.setFont(new Font("���� ���", Font.BOLD, 17));
		info.setBounds(5, 0, 110, 40);	
		
		notice = new JTextArea("������ ������ȣ�� ����\n���� Ȯ�� �����̿���,\n�α��� �� \n����� ��й�ȣ�� �Է����ּ���.");
		notice.setEditable(false);
		notice.setForeground(Color.RED);
		notice.setFont(new Font("���� ���", Font.BOLD, 18));
		notice.setBackground(Color.WHITE);
		notice.setBounds(22, 53, 300, 100);
		
		pwdT = new JPasswordField();
		pwdL = new JLabel("��й�ȣ �Է�");
		pwdL.setForeground(Color.WHITE);
		pwdL.setFont(new Font("���� ���", Font.BOLD, 14));
		pwdL.setBounds(22, 163, 90, 25);
		pwdT.setEchoChar('*');
		pwdT.setFont(new Font("���� ���", Font.BOLD, 13));
		pwdT.setBounds(22, 185, 300, 35);
		
		cancelBtn = new JButton("���");
		cancelBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		cancelBtn.setBounds(72, 236, 91, 28);
		confirmBtn = new JButton("Ȯ��");
		confirmBtn.setFont(new Font("���� ���", Font.BOLD, 14));
		confirmBtn.setBounds(173, 236, 91, 28);
		
		add(info);
		add(notice);
		add(pwdL); add(pwdT);
		add(cancelBtn); add(confirmBtn);
		
		setTitle("ȸ������Ȯ��");
		setSize(350, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		cancelBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
		cancelBtn.setFocusable(false);
		confirmBtn.setFocusable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelBtn){
			dispose();
		} else if(e.getSource() == confirmBtn){
			airlineDAO = new AirlineDAO();
			list = airlineDAO.getmemberList();
			for (MemberDTO memberDTO : list) {
				if(loginId.equals(memberDTO.getId())) {
					if(pwdT.getText().equals(memberDTO.getPw())) {
						new Member_MyInfoEdit2(loginId, member_bookInfo);
					}else if(!pwdT.getText().equals(memberDTO.getPw())) {
						JOptionPane.showMessageDialog(this, "��й�ȣ�� Ʋ���ϴ�.");
						return;
					}
				}
			}
			dispose();
		}
	}

}
