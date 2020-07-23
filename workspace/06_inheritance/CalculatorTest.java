import java.awt.*;
import java.awt.event.*;

class CalculatorTest extends Frame implements WindowListener, ActionListener{
	private Label dispL, inputL;
	private Button[] button;

	public void init(){
		setTitle("미니계산기");

		button = new Button[18];
		dispL = new Label();
		inputL = new Label();

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		p1.setLayout(new GridLayout(4,4,5,0));
		p2.setLayout(new GridLayout(1,2,5,10));
		String[] str = new String[] {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","+","="};


		for(int i=0; i<str.length; i++){
			p1.add(new Button(str[i]));
		}
		for(int i=16; i<18; i++){
			button[16] = new Button("<");
			button[17] = new Button("C");
			p2.add(button[i]);
		}

		p1.setBounds(9, 186, 283, 206);
		add(p1);
		p2.setBounds(9, 133, 283, 50);
		add(p2);

		inputL.setBounds(8, 85, 283, 45);
		inputL.setBackground(new Color(200, 200, 200));
		inputL.setAlignment(Label.RIGHT);
		add(inputL);

		dispL.setBounds(8, 35, 283, 45);
		dispL.setBackground(new Color(200, 200, 200));
		dispL.setAlignment(Label.RIGHT);
		add(dispL);

		setResizable(false);
		setLayout(null);
		setBounds(900, 200, 300, 400);
		setBackground(new Color(1, 1, 1));
		setVisible(true);

		this.addWindowListener(this);
		button[8].addActionListener(this);
	}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
 	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button[8]){		//계산기 C버튼에 활용!!
			inputL.setText("1");
		}
	}

	public static void main(String[] args) {
		new CalculatorTest().init();
	}
}
