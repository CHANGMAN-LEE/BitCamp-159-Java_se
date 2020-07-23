package airline.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manager_ extends JFrame implements ActionListener {

	private JButton managerBtn, airBtn, loginOutBtn;

	public Manager_() {

		setBackground(new Color(3, 136, 166));

		managerBtn = new JButton("È¸¿ø°ü¸®");
		managerBtn.setBounds(55, 220, 100, 35);
		managerBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));

		airBtn = new JButton("Ç×°ø±Ç°ü¸®");
		airBtn.setBounds(195, 220, 100, 35);
		airBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));

		loginOutBtn = new JButton("·Î±×¾Æ¿ô");
		loginOutBtn.setBounds(200, 420, 95, 25);
		loginOutBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		loginOutBtn.setHorizontalAlignment(JLabel.CENTER);
		loginOutBtn.setBackground(new Color(3, 136, 166));
		loginOutBtn.setBorderPainted(false);
		loginOutBtn.setForeground(Color.WHITE);

		JPanel p = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon info = new ImageIcon("info.png");
				ImageIcon air = new ImageIcon("air.png");
				g.drawImage(info.getImage(), 75, 145, 64, 64, null);
				g.drawImage(air.getImage(), 210, 145, 64, 64, null);
			}
		};

		p.setLayout(null);
		p.add(managerBtn);
		p.add(airBtn);
		p.add(loginOutBtn);

		add("Center", p);
		setTitle("BitAirline_°ü¸®ÀÚ ÆäÀÌÁö"); 
		setSize(350, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ÀÌº¥Æ®
		managerBtn.addActionListener(this);
		airBtn.addActionListener(this);
		loginOutBtn.addActionListener(this);
		managerBtn.setFocusable(false);
		airBtn.setFocusable(false);
		loginOutBtn.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == managerBtn) {
			new Manager_Form();
			dispose();
		} else if (e.getSource() == airBtn) {
			new ManagerAirForm_();
			dispose();
		} else if (e.getSource() == loginOutBtn) {
			new AirlineMain_Login();
			dispose();
		}
	}
}