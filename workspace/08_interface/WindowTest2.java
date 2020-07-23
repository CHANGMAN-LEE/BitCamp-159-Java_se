import java.awt.*;
import java.awt.event.*;

class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn;
	private TextArea area;
	
	//init
	public void init(){
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		area = new TextArea();
		Panel p = new Panel();

		area.setFont(new Font("새굴림", Font.BOLD, 20));
		p.setBackground(new Color(255,200,255));
		p.add(newBtn);
		p.add(exitBtn);

		add("North", p);
		add("Center", area);

		setResizable(false);
		setBounds(900, 100, 300, 400);
		setVisible(true);

		this.addWindowListener(this);
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}
	
	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		//if(e.getSource() == newBtn){
		if(e.getActionCommand() == "새로만들기"){		//계산기 C버튼에 활용!!
			area.setText("");
		}else if(e.getSource() == exitBtn){
			System.exit(0);
		}
	}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
 	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	//main
	public static void main(String[] args){
		new WindowTest2().init();
	}
}
