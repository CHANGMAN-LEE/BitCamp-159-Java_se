import java.awt.*;
import java.awt.event.*;

class Login extends Frame implements ActionListener{
	private TextField idT, pwdT;
	private Button longinBtn, cancelBtn;
	
	public Login(){
		setLayout(null);
		setTitle("로그인");

		Label idL = new Label("아이디");
		idT = new TextField("");
		Label pwdL = new Label("비밀번호");
		pwdT = new TextField("");
		longinBtn = new Button("로그인");
		cancelBtn = new Button("취소");

		idL.setBounds(60,80,50,20);
		idT.setBounds(120,80,100,20);
		pwdL.setBounds(60,110,50,20);
		pwdT.setBounds(120,110,100,20);
		longinBtn.setBounds(90,160,50,20);
		cancelBtn.setBounds(160,160,50,20);

		add(idL);
		add(idT);
		add(pwdL);
		add(pwdT);
		add(longinBtn);
		add(cancelBtn);

		setResizable(false);
		setBounds(650, 150, 300, 250);
		setBackground(new Color(200, 200, 200));
		setVisible(true);

		this.addWindowListener(new WindowExit());
		cancelBtn.addActionListener(this);
		longinBtn.addActionListener(this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		//if(e.getSource() == cancelBtn){
		if(e.getActionCommand() == "취소"){
			idT.setText("");
			pwdT.setText("");
		}else if(e.getActionCommand() == "로그인"){
			String id = idT.getText();
			String pwd = pwdT.getText();
			new LoginResult(id, pwd);
		}
	}

	public static void main(String[] args){
		new Login();
	}
}
