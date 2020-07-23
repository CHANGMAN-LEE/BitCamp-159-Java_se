import java.awt.*;
import java.awt.event.*;

class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn;
	private TextArea area;
	
	//init
	public void init(){
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		area = new TextArea();
		Panel p = new Panel();

		area.setFont(new Font("������", Font.BOLD, 20));
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
		if(e.getActionCommand() == "���θ����"){		//���� C��ư�� Ȱ��!!
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
