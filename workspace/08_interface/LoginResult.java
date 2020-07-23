import java.awt.*;
import java.awt.event.*;

class LoginResult extends Frame implements WindowListener, ActionListener{

	private String id, pwd;
	private Button okBtn;

	public LoginResult(String id, String pwd){
		setLayout(null);
		setTitle("로그인 결과");

		this.id = id;
		this.pwd = pwd;
		okBtn = new Button("확인");

		okBtn.setBounds(130,100,60,35);

		add(okBtn);

		setResizable(false);
		setFont(new Font("새굴림", Font.BOLD, 30));
		setBounds(800, 200, 250, 150);
		setBackground(new Color(200, 200, 200));
		setVisible(true);

		this.addWindowListener(this);
		okBtn.addActionListener(this);
	}

	public void paint(Graphics g){
		if(id.equals("angel") && pwd.equals("1004")){
			g.drawString("로그인 성공", 40, 80);
		}else{
			g.drawString("로그인 실패", 40, 80);
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
		if(e.getActionCommand() == "확인"){
			setVisible(false);
		}
	}

}
