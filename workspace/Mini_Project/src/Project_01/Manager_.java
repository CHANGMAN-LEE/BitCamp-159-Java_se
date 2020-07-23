package Project_01;					//지예린

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager_ extends JFrame implements ActionListener {
	//private static final long serialVersionUID = 1L;

	private JButton managerBtn, airBtn;

	public Manager_() {
		managerBtn = new JButton("회원관리");
		managerBtn.setBounds(120, 160, 100, 35);
		airBtn = new JButton("항공권관리");
		airBtn.setBounds(120, 330, 100, 35);

		JPanel p = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon info = new ImageIcon("info.png");
				ImageIcon air = new ImageIcon("air.png");
				g.drawImage(info.getImage(), 140, 80, 64, 64, null);
				g.drawImage(air.getImage(), 140, 250, 64, 64, null);
			}
		};

		p.setLayout(null);
		p.add(managerBtn);
		p.add(airBtn);

		add("Center", p);
		setTitle("관리자페이지");
		setSize(350, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트
		managerBtn.addActionListener(this);
		airBtn.addActionListener(this);
		managerBtn.setFocusable(false);
		airBtn.setFocusable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == managerBtn) {
			new Manager_Form();
			setVisible(false);
		} else if (e.getSource() == airBtn) {
			// 미애언니 페이지연결
			new ManagerAirForm_();
		}
	}
}
