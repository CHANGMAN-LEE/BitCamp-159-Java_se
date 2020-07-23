import java.awt.*;
import java.awt.event.*;
import java.text.*;

class CalculatorTest2 extends Frame implements WindowListener, ActionListener{
	private Label dispL, inputL;
	private Button[] button;
	private StringBuffer dispBuf, inputBuf;
	private DecimalFormat df = new DecimalFormat("#,###.###");
	private double result;
	private char op;

	public void init(){
		setTitle("미니계산기");

		button = new Button[18];
		dispL = new Label();
		inputL = new Label("0");

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		p1.setLayout(new GridLayout(4,4,5,0));
		p2.setLayout(new GridLayout(1,2,5,10));
		String[] str = new String[] {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"};

		for(int i=0; i<str.length; i++){
			button[i] = new Button(str[i]);
			p1.add(button[i]);
			button[i].addActionListener(this);
		}
		//button[16].addActionListener(this);
		//button[17].addActionListener(this);
		button[16] = new Button("<");
		button[17] = new Button("C");
		for(int i=16; i<18; i++){
			p2.add(button[i]);
			button[i].addActionListener(this);
		}

		dispL.setBounds(8, 35, 283, 45);
		dispL.setBackground(new Color(200, 200, 200));
		dispL.setAlignment(Label.RIGHT);
		add(dispL);
		dispBuf = new StringBuffer();

		inputL.setBounds(8, 85, 283, 45);
		inputL.setBackground(new Color(200, 200, 200));
		inputL.setAlignment(Label.RIGHT);
		add(inputL);
		inputBuf = new StringBuffer("0");

		p2.setBounds(8, 133, 283, 50);
		add(p2);
		p1.setBounds(8, 186, 283, 206);
		add(p1);

		setResizable(false);
		setLayout(null);
		setBounds(900, 200, 300, 400);
		setBackground(new Color(1, 1, 1));
		setVisible(true);

		//이벤트
		this.addWindowListener(this);
	}
	
	//ActionListener Override
	public void actionPerformed(ActionEvent e){
		String push = e.getActionCommand();
		if(push == "1" || push == "2" || push == "3" || push == "4" || push == "5" ||
							push == "6" || push == "7" || push == "8" || push == "9"|| push == "0"){
			dispL.setText(dispBuf+"");
			if(inputBuf.length() == 1 && inputBuf.toString().equals("0")){
				inputBuf.delete(0, 1);
			}
			inputBuf.append(push);
			inputL.setText(inputBuf+"");
		}else if(push == "C"){
			dispBuf.delete(0, dispBuf.length());
			inputBuf.delete(0, inputBuf.length());
			dispL.setText("");
			inputBuf.append("0");
			inputL.setText("0");
			result = op = 0;
		}else if(push == "<"){
			inputBuf.delete(inputBuf.length()-1, inputBuf.length());
			if(inputBuf.length() == 0){
				inputBuf.append("0");
			}
			inputL.setText(inputBuf+"");
		}else if(push == "."){
			if(inputBuf.indexOf(".") == -1){
				inputBuf.append(".");
				inputL.setText(inputBuf+"");
			}
		}else if(push == "="){
			if(inputBuf.length() == 0) return;
			calc();
			op=0;
			dispBuf.append(inputBuf+"=");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			dispBuf.delete(0, dispBuf.length());
			inputBuf.delete(0, inputBuf.length());
			result = op = 0;
		}else if(push == "+"){
			if(inputBuf.length() == 0) return;
			calc();
			op = '+';
			dispBuf.append(inputBuf+"+");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0, inputBuf.length());
		}else if(push == "-"){
			if(inputBuf.length() == 0) return;
			calc();
			op = '-';
			dispBuf.append(inputBuf+"-");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0, inputBuf.length());
		}else if(push == "*"){
			if(inputBuf.length() == 0) return;
			calc();
			op = '*';
			dispBuf.append(inputBuf+"*");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0, inputBuf.length());
		}else if(push == "/"){
			if(inputBuf.length() == 0) return;
			calc();
			op = '/';
			dispBuf.append(inputBuf+"/");
			dispL.setText(dispBuf+"");
			inputL.setText(df.format(result));
			inputBuf.delete(0, inputBuf.length());
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

	public void calc(){
		if(op == 0) result = Double.parseDouble(inputBuf+"");
		else if(op == '+') result = result + Double.parseDouble(inputBuf+"");
		else if(op == '-') result = result - Double.parseDouble(inputBuf+"");
		else if(op == '*') result = result * Double.parseDouble(inputBuf+"");
		else if(op == '/') result = result / Double.parseDouble(inputBuf+"");
	}

	public static void main(String[] args) {
		new CalculatorTest2().init();
	}
}
