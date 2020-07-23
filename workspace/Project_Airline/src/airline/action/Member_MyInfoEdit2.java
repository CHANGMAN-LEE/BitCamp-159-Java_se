package airline.action;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import airline.bean.MemberDTO;
import airline.dao.AirlineDAO;

public class Member_MyInfoEdit2 extends JFrame implements ActionListener {
	private String id, pwd, name, phone, address;
	private String age;
	private JLabel myInfoL, nameL, idL, pwdL, phoneL, addressL, emailL, questionL, answerL;
	private JTextField idT, nameT, phoneT, emailT, answerT;
	private JPasswordField pwdT;
	private JButton editBtn, cancelBtn, withdrawalBtn;
	private JComboBox addressComboBox, questionComboBox;
	private String loginId;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private Member_BookInfo member_bookInfo;

	public Member_MyInfoEdit2(String loginId, Member_BookInfo member_bookInfo) {
		this.loginId = loginId;
		this.member_bookInfo = member_bookInfo;
		setLayout(null);
		getContentPane().setBackground(new Color(3, 136, 166));

		myInfoL = new JLabel("±âº» Á¤º¸");
		myInfoL.setForeground(Color.WHITE);
		myInfoL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		myInfoL.setBounds(250, 0, 85, 40);

		idL = new JLabel("¾ÆÀÌµð");
		idL.setForeground(Color.WHITE);
		idL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		idL.setBounds(25, 63, 45, 25);
		idT = new JTextField();
		idT.setEditable(false);
		idT.setBounds(90, 63, 224, 28);

		pwdL = new JLabel("ºñ¹Ð¹øÈ£");
		pwdL.setForeground(Color.WHITE);
		pwdL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		pwdL.setBounds(25, 108, 56, 25);
		pwdT = new JPasswordField();
		pwdT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwdT.setEchoChar('*');
		pwdT.setBounds(90, 108, 224, 28);

		nameL = new JLabel("ÀÌ¸§");
		nameL.setForeground(Color.WHITE);
		nameL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		nameL.setBounds(25, 153, 35, 25);
		nameT = new JTextField();
		nameT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameT.setBounds(90, 153, 224, 28);

		phoneL = new JLabel("¿¬¶ôÃ³");
		phoneL.setForeground(Color.WHITE);
		phoneL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		phoneL.setBounds(25, 198, 50, 25);
		phoneT = new JTextField();
		phoneT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		phoneT.setBounds(90, 198, 224, 28);

		addressL = new JLabel("ÁÖ¼Ò");
		addressL.setForeground(Color.WHITE);
		addressL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		addressL.setBounds(25, 243, 35, 25);
		addressComboBox = new JComboBox();
		addressComboBox.setBackground(Color.WHITE);
		addressComboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		addressComboBox.setModel(new DefaultComboBoxModel(new String[] { "°­¿øµµ", "±¤ÁÖ±¤¿ª½Ã", "°æ±âµµ", "°æ»ó³²µµ", "°æ»óºÏµµ", "´ë±¸±¤¿ª½Ã",
				"´ëÀü±¤¿ª½Ã", "ºÎ»ê±¤¿ª½Ã", "¼­¿ïÆ¯º°½Ã", "¼¼Á¾Æ¯º°ÀÚÄ¡½Ã", "ÀÎÃµ±¤¿ª½Ã", "¿ï»ê±¤¿ª½Ã", "Àü¶ó³²µµ", "Àü¶óºÏµµ", "Á¦ÁÖÆ¯º°ÀÚÄ¡µµ", "ÃæÃ»ºÏµµ", "ÃæÃ»³²µµ" }));
		addressComboBox.setBounds(90, 242, 224, 28);

		emailL = new JLabel("ÀÌ¸ÞÀÏ");
		emailL.setForeground(Color.WHITE);
		emailL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		emailL.setBounds(25, 288, 45, 25);
		emailT = new JTextField();
		emailT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		emailT.setBounds(90, 288, 224, 28);

		questionL = new JLabel("Áú¹®");
		questionL.setForeground(Color.WHITE);
		questionL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		questionL.setBounds(25, 333, 35, 25);

		questionComboBox = new JComboBox();
		questionComboBox.setBackground(Color.WHITE);
		questionComboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		questionComboBox.setModel(new DefaultComboBoxModel(new String[] { "Ãâ½Å ÃÊµîÇÐ±³´Â?", "¾î¸Ó´Ï ¼ºÇÔÀº?", "¾Æ¹öÁö ¼ºÇÔÀº?" }));
		questionComboBox.setBounds(90, 332, 224, 28);

		answerL = new JLabel("´ä");
		answerL.setForeground(Color.WHITE);
		answerL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		answerL.setBounds(25, 366, 25, 25); // 34
		answerT = new JTextField();
		answerT.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		answerT.setBounds(90, 366, 224, 28);

		editBtn = new JButton("¼öÁ¤ ¿Ï·á");
		editBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		editBtn.setBounds(40, 424, 90, 28);
		cancelBtn = new JButton("Ãë¼Ò");
		cancelBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		cancelBtn.setBounds(135, 424, 80, 28);
		withdrawalBtn = new JButton("Å»Åð");
		withdrawalBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		withdrawalBtn.setBounds(221, 424, 80, 28);

		add(myInfoL);
		add(idL);
		add(idT);
		add(pwdL);
		add(pwdT);
		add(nameL);
		add(nameT);
		add(phoneL);
		add(phoneT);
		add(addressL);
		add(addressComboBox);
		add(emailL);
		add(emailT);
		add(questionL);
		add(questionComboBox);
		add(answerL);
		add(answerT);
		add(editBtn);
		add(cancelBtn);
		add(withdrawalBtn);
		
		output(loginId);

		setTitle("³ªÀÇ Á¤º¸");
		setSize(350, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		editBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		withdrawalBtn.addActionListener(this);
		editBtn.setFocusable(false);
		cancelBtn.setFocusable(false);
		withdrawalBtn.setFocusable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editBtn) { // ¼öÁ¤¹öÆ°
			airlineDAO = new AirlineDAO();
			list = airlineDAO.getmemberList();
			for (MemberDTO memberDTO : list) {
				if (memberDTO.getId().equals(loginId)) {
					memberDTO.setSeq(memberDTO.getSeq());
					memberDTO.setId(idT.getText());
					memberDTO.setPw(pwdT.getText());
					memberDTO.setPw2(pwdT.getText());
					memberDTO.setName(nameT.getText());
					memberDTO.setPhone(phoneT.getText());
					memberDTO.setAddress(addressComboBox.getActionCommand());
					memberDTO.setMail(emailT.getText());
					memberDTO.setQuestion(questionComboBox.getActionCommand());
					memberDTO.setAnswer(answerT.getText());
					memberDTO.setCode(memberDTO.getCode());

					airlineDAO.member_update(memberDTO);
				}
			}
			
			output(loginId);
			JOptionPane.showMessageDialog(this, "¼öÁ¤ ¿Ï·á", "¼öÁ¤", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} else if (e.getSource() == cancelBtn) { // Ãë¼Ò¹öÆ°
			dispose();
		} else if (e.getSource() == withdrawalBtn) { // Å»Åð¹öÆ°
			int result = JOptionPane.showConfirmDialog(this, "       Å»ÅðÇÏ½Ã°Ú½À´Ï±î?", "Å»Åð", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				airlineDAO.member_delete(loginId);
				JOptionPane.showMessageDialog(this, "          Å»ÅðµÇ¼Ì½À´Ï´Ù.", "Å»Åð", JOptionPane.INFORMATION_MESSAGE);
				member_bookInfo.dispose();
				new AirlineMain_Login();
				dispose();
			}
		}
	}

	public int output(String loginId) {
		this.loginId = loginId;
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getmemberList();
		for (MemberDTO memberDTO : list) {
			if (memberDTO.getId().equals(loginId)) {
				idT.setText(memberDTO.getId());
				pwdT.setText(memberDTO.getPw());
				nameT.setText(memberDTO.getName());
				phoneT.setText(memberDTO.getPhone());
				addressComboBox.setActionCommand(memberDTO.getAddress());
				emailT.setText(memberDTO.getMail());
				questionComboBox.setActionCommand(memberDTO.getQuestion());
				answerT.setText(memberDTO.getAnswer());
			}
		}
		return sw;
	}
}