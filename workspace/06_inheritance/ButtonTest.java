import java.awt.*;

class ButtonTest extends Frame {
	private Button northB, eastB;
	private Button newB, exitB;
	public void init(){
		northB = new Button("북쪽");
		eastB = new Button("동쪽");
		newB = new Button("새로만들기");
		exitB = new Button("종료");

		Panel p = new Panel();
		p.setLayout(new GridLayout(1,2,5,0));
		p.add(newB);
		p.add(exitB);

		this.add("North", northB);
		this.add("East", eastB);
		add("South", p);
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		ButtonTest bt = new ButtonTest();
		bt.init();
	}
}
