package Project_01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AirlineMain_FindID extends JFrame implements ActionListener {
	private JTextField nameT, phoneT;
	private JLabel nameL, phoneL;
	private JButton okBtn, cancelBtn;

	public AirlineMain_FindID() {
		setLayout(null);
		setTitle("아이디 찾기");

		nameL = new JLabel("이름");
		nameL.setBounds(46, 69, 50, 21);
		add(nameL);

		nameT = new JTextField();
		nameT.setBounds(150, 69, 137, 21);
		add(nameT);
		nameT.setColumns(10);

		phoneL = new JLabel("연락처");
		phoneL.setBounds(46, 100, 50, 21);
		add(phoneL);

		phoneT = new JTextField();
		phoneT.setColumns(10);
		phoneT.setBounds(150, 100, 137, 21);
		add(phoneT);

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

		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "확인") {
			JOptionPane.showMessageDialog(this, "고객님의 아이디는 " + "?? " + "입니다.");
			setVisible(false);
		} else if (e.getActionCommand() == "취소") {
			setVisible(false);
		}
	}
}
