import java.awt.*;

class Calculator extends Frame {
	private Label dispL, inputL;
	private Button[] button;

	public void init(){
		setTitle("미니계산기");

		button = new Button[18];
		dispL = new Label();
		inputL = new Label();

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();

		p1.setLayout(new GridLayout(1,4,5,0));
		p2.setLayout(new GridLayout(1,4,5,0));
		p3.setLayout(new GridLayout(1,4,5,0));
		p4.setLayout(new GridLayout(1,4,5,0));
		p5.setLayout(new GridLayout(1,2,5,10));

		for(int i=0; i<4; i++){
			button[0] = new Button(".");
			button[1] = new Button("0");
			button[2] = new Button("=");
			button[3] = new Button("+");
			p1.add(button[i]);			
		}
		for(int i=4; i<8; i++){
			button[4] = new Button("1");
			button[5] = new Button("2");
			button[6] = new Button("3");
			button[7] = new Button("-");
			p2.add(button[i]);
		}
		for(int i=8; i<12; i++){
			button[8] = new Button("4");
			button[9] = new Button("5");
			button[10] = new Button("6");
			button[11] = new Button("*");
			p3.add(button[i]);
		}
		for(int i=12; i<16; i++){
			button[12] = new Button("7");
			button[13] = new Button("8");
			button[14] = new Button("9");
			button[15] = new Button("/");
			p4.add(button[i]);
		}
		for(int i=16; i<18; i++){
			button[16] = new Button("<");
			button[17] = new Button("C");
			p5.add(button[i]);
		}
		
		p1.setBounds(9, 342, 283, 50);
		add(p1);
		p2.setBounds(9, 290, 283, 50);
		add(p2);
		p3.setBounds(9, 238, 283, 50);
		add(p3);
		p4.setBounds(9, 186, 283, 50);
		add(p4);
		p5.setBounds(9, 133, 283, 50);
		add(p5);

		inputL.setBounds(8, 85, 283, 45);
		inputL.setBackground(new Color(200, 200, 200));
		inputL.setText("3+9=");
		inputL.setAlignment(Label.RIGHT);
		add(inputL);

		dispL.setBounds(8, 35, 283, 45);
		dispL.setBackground(new Color(200, 200, 200));
		dispL.setText("12");
		dispL.setAlignment(Label.RIGHT);
		add(dispL);
		
		setLayout(null);
		setBounds(900, 200, 300, 400);
		setBackground(new Color(1, 1, 1));
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator().init();
	}
}
