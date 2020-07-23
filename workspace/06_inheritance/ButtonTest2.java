import java.awt.*;

class ButtonTest2 extends Frame {
	private Button newB, exitB;

	public void init(){
		newB = new Button("새로만들기");
		exitB = new Button("종료");

		newB.setBounds(70, 150, 80, 30);
		this.add(newB);
		exitB.setBounds(140, 300, 80, 30);
		this.add(exitB);

		setLayout(null);
		setBounds(900, 200, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		//ButtonTest2 bt = new ButtonTest2();
		//bt.init();
		new ButtonTest2().init();
	}
}
