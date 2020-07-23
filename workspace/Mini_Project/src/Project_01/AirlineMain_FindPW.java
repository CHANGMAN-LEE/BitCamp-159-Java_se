package Project_01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AirlineMain_FindPW extends JFrame implements ActionListener {
	private JTextField nameT, mailT, codeT;
	private JLabel nameL, mailL, codeL;
	private JButton okBtn, cancelBtn, sendBtn;
	private Random random;

	public AirlineMain_FindPW() {
		setLayout(null);

		nameL = new JLabel("이름");
		nameL.setBounds(46, 69, 50, 21);
		add(nameL);

		nameT = new JTextField();
		nameT.setBounds(118, 69, 137, 21);
		add(nameT);
		nameT.setColumns(10);

		mailL = new JLabel("이메일");
		mailL.setBounds(46, 100, 50, 21);
		add(mailL);

		mailT = new JTextField();
		mailT.setColumns(10);
		mailT.setBounds(118, 100, 137, 21);
		add(mailT);

		sendBtn = new JButton("전송");
		sendBtn.setBounds(266, 99, 60, 23);
		add(sendBtn);

		codeL = new JLabel("인증코드");
		codeL.setBounds(46, 133, 50, 21);
		add(codeL);

		codeT = new JTextField();
		codeT.setColumns(10);
		codeT.setBounds(118, 133, 137, 21);
		add(codeT);

		okBtn = new JButton("확인");
		okBtn.setBounds(46, 219, 91, 23);
		add(okBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(196, 219, 91, 23);
		add(cancelBtn);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1450, 60, 350, 300);
		setVisible(true);
		setResizable(false);

		sendBtn.addActionListener(this);
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "전송") {
			System.out.println("눌림");
			int codeNum = (int) (Math.random() * (900000)) + 10000;
			System.out.println(codeNum);
			sendMail();
			JOptionPane.showMessageDialog(this, "인증번호가 전송되었습니다.");
			sendBtn.setEnabled(false);
		} else if (e.getActionCommand() == "확인") {
			if (nameT.getText().equals("") || mailT.getText().equals("") || codeT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸을 모두 채워주세요.");
			} else if (!nameT.getText().equals("") || !mailT.getText().equals("") || !codeT.getText().equals("")) {
				JOptionPane.showInputDialog(this, "변경하실 비밀번호를 입력하세요.");
				setVisible(false);
			}
		} else if (e.getActionCommand() == "취소") {
			setVisible(false);
		}
	}

	public void sendMail() {
		String toMail = mailT.getText();
		String fromMail;
		String fromMailUser;
	}
}
