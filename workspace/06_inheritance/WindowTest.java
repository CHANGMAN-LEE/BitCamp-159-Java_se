import java.awt.*;

class WindowTest extends Frame{
	public WindowTest(){
		//super("����");
		setTitle("����");
		System.out.println("����");
		setForeground(new Color(255, 1, 1));
		//setBackground(Color.blue);
		setBackground(new Color(1, 1, 255));
		//setSize(300, 400);
		setBounds(500, 200, 300, 400);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g){		//�����Ӿȿ� �׷��ش�!! - Call Back Method
		g.drawString("����", 100, 80);
		g.drawLine(200, 150, 100, 200);
		g.drawRect(150, 150, 100, 100);
		g.drawOval(100, 120, 100, 100);
	}

	public static void main(String[] args) {
		//System.out.println("Hello World!");
		new WindowTest();
	}
}

//69, 78, 231