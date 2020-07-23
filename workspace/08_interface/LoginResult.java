import java.awt.*;
import java.awt.event.*;

class LoginResult extends Frame implements WindowListener, ActionListener{

	private String id, pwd;
	private Button okBtn;

	public LoginResult(String id, String pwd){
		setLayout(null);
		setTitle("�α��� ���");

		this.id = id;
		this.pwd = pwd;
		okBtn = new Button("Ȯ��");

		okBtn.setBounds(130,100,60,35);

		add(okBtn);

		setResizable(false);
		setFont(new Font("������", Font.BOLD, 30));
		setBounds(800, 200, 250, 150);
		setBackground(new Color(200, 200, 200));
		setVisible(true);

		this.addWindowListener(this);
		okBtn.addActionListener(this);
	}

	public void paint(Graphics g){
		if(id.equals("angel") && pwd.equals("1004")){
			g.drawString("�α��� ����", 40, 80);
		}else{
			g.drawString("�α��� ����", 40, 80);
		}
	}

	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
 	public void windowClosing(WindowEvent e){setVisible(false);}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "Ȯ��"){
			setVisible(false);
		}
	}

}
