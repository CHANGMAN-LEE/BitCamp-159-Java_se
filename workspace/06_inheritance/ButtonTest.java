import java.awt.*;

class ButtonTest extends Frame {
	private Button northB, eastB;
	private Button newB, exitB;
	public void init(){
		northB = new Button("����");
		eastB = new Button("����");
		newB = new Button("���θ����");
		exitB = new Button("����");

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
